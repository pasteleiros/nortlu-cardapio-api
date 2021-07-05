package com.nortlu.service

import com.nortlu.repo.CategoriaRepo
import io.github.pasteleiros.nortlulib.dto.CategoriaDto
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

}