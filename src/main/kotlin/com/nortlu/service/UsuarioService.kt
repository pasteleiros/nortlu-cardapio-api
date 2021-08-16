package com.nortlu.service

import com.nortlu.repo.UsuarioRepo
import io.github.pasteleiros.nortlulib.dto.EnderecoDto
import io.github.pasteleiros.nortlulib.dto.UsuarioDto
import io.github.pasteleiros.nortlulib.exception.NaoEncontradoException
import io.github.pasteleiros.nortlulib.mapper.toDto
import io.github.pasteleiros.nortlulib.mapper.toEntity
import javax.inject.Singleton

@Singleton
class UsuarioService(val usuarioRepo: UsuarioRepo, val enderecoService: EnderecoService) {

    fun salvarUsuario( usuarioDto: UsuarioDto): UsuarioDto = usuarioRepo.save(usuarioDto.toEntity()).toDto();

    fun buscarUsuarioPorId(id: Long): UsuarioDto = usuarioRepo.findById(id).orElseThrow { NaoEncontradoException("Usuário não encontrado") }.toDto()

    fun deletarUsuarioPorId(id: Long){
        this.buscarUsuarioPorId(id).let {
            usuarioRepo.deleteById(id)
        }
    }

    fun atualizarUsuario( usuarioDto: UsuarioDto): UsuarioDto =
         this.buscarUsuarioPorId(usuarioDto.id!!).let {
            usuarioRepo.update(usuarioDto.toEntity()).toDto();
        }

}