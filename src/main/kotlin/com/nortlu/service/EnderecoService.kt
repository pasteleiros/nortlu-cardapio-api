package com.nortlu.service

import com.nortlu.repo.EnderecoRepo
import io.github.pasteleiros.nortlulib.dto.EnderecoDto
import io.github.pasteleiros.nortlulib.exception.NaoEncontradoException
import io.github.pasteleiros.nortlulib.mapper.toDto
import io.github.pasteleiros.nortlulib.mapper.toEntity
import javax.inject.Singleton

@Singleton
class EnderecoService(val enderecoRepo: EnderecoRepo) {


    fun salvar(enderecoDto: EnderecoDto): EnderecoDto = enderecoRepo.save(enderecoDto.toEntity()).toDto();

    fun buscarEnderecoPorId(id: Long): EnderecoDto =
        enderecoRepo.findById(id).orElseThrow { NaoEncontradoException("Endereço não encontrado") }.toDto()

    fun deletarEndereco(idEndereco: Long) {
        this.buscarEnderecoPorId(idEndereco).let {
            enderecoRepo.deleteById(idEndereco)
        }

    }

    fun atualizar(enderecoDto: EnderecoDto): EnderecoDto {
        if (enderecoDto.id != null) {
            buscarEnderecoPorId(enderecoDto.id!!)
            return enderecoRepo.update(enderecoDto.toEntity()).toDto()
        }

        throw NaoEncontradoException("Endereço não encontrada")
    }


}