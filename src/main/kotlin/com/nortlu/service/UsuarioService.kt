package com.nortlu.service

import com.nortlu.repo.UsuarioRepo
import io.github.pasteleiros.nortlulib.dto.UsuarioDto
import io.github.pasteleiros.nortlulib.exception.NaoEncontradoException
import io.github.pasteleiros.nortlulib.mapper.toDto
import io.github.pasteleiros.nortlulib.mapper.toEntity
import javax.inject.Singleton

@Singleton
class UsuarioService(val usuarioRepo: UsuarioRepo, val enderecoService: EnderecoService) {

    fun salvar(usuarioDto: UsuarioDto): UsuarioDto {
        validarEnderecoUsuario(usuarioDto)
        return usuarioRepo.save(usuarioDto.toEntity()).toDto();
    }

    private fun validarEnderecoUsuario(usuarioDto: UsuarioDto) {
        usuarioDto.enderecos.forEach {
            if (it.id == null) {
                val endereco = enderecoService.salvar(it)
                it.id = endereco.id
            } else {
                try {
                    enderecoService.buscarEnderecoPorId(it.id!!)
                } catch (e: NaoEncontradoException) {
                    it.id = null
                    it.id = enderecoService.salvar(it).id
                }
            }
        }
    }

    fun buscarPorId(id: Long): UsuarioDto =
        usuarioRepo.findById(id).orElseThrow { NaoEncontradoException("Usuário não encontrado") }.toDto()

    fun deletarUsuarioPorId(id: Long) {
        this.buscarPorId(id).let {
            usuarioRepo.deleteById(id)
        }
    }

    fun atualizarUsuario(usuarioDto: UsuarioDto): UsuarioDto {
        if (usuarioDto.id != null) {
            buscarPorId(usuarioDto.id!!)
            validarEnderecoUsuario(usuarioDto)
            return usuarioRepo.update(usuarioDto.toEntity()).toDto();
        }

        throw NaoEncontradoException("Usuario não encontrada")
    }


}