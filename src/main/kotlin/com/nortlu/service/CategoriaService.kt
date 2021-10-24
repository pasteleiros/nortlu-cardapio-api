package com.nortlu.service

import com.nortlu.repo.CategoriaRepo
import io.github.pasteleiros.nortlulib.dto.CategoriaDto
import io.github.pasteleiros.nortlulib.exception.NaoEncontradoException
import io.github.pasteleiros.nortlulib.mapper.toDto
import io.github.pasteleiros.nortlulib.mapper.toEntity
import io.github.pasteleiros.nortlulib.mapper.toListDto
import javax.inject.Singleton

@Singleton
class CategoriaService (val categoriaRepo : CategoriaRepo, val redis : RedisServer) {
    fun listar() : List<CategoriaDto> {
        val categorias = categoriaRepo.findAll().toList().toListDto()
        val list = categorias.map {
            DadosRedis("CAT-${it.id}", it.descricao)
        }
        redis.salvaLsCache(list, 30)
        return categorias
    }

    fun criar(categoriaDto: CategoriaDto): CategoriaDto = categoriaRepo.save(categoriaDto.toEntity()).toDto()

    fun atualizar(categoriaDto: CategoriaDto): CategoriaDto {
        if (categoriaDto.id != null) {
            buscar(categoriaDto.id!!)
            return categoriaRepo.update(categoriaDto.toEntity()).toDto()
        }

        throw NaoEncontradoException("Categoria não encontrada")
    }

    fun buscar(id: Long): CategoriaDto = categoriaRepo.findById(id)
        .orElseThrow { NaoEncontradoException("Categoria não encontrada") }.toDto()
}