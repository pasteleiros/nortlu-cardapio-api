package com.nortlu.controller

import com.nortlu.service.UsuarioService
import io.github.pasteleiros.nortlulib.dto.UsuarioDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/usuarios")
class UsuarioController(val usuarioService: UsuarioService) {

    @Post()
    fun salvarUsuario(@Body usuarioDto: UsuarioDto): HttpResponse<UsuarioDto> =
            HttpResponse.created(usuarioService.salvar(usuarioDto))

    @Get("/{id}")
    fun buscarUsuario(@PathVariable("id") idUsuario : Long ): HttpResponse<UsuarioDto> =
            HttpResponse.ok(usuarioService.buscarPorId(idUsuario))

    @Put
    fun atualizarUsuario( @Body usuarioDto: UsuarioDto): HttpResponse<UsuarioDto>
        = HttpResponse.ok(usuarioService.atualizarUsuario(usuarioDto))

}