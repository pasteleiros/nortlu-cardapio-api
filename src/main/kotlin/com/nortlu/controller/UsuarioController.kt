package com.nortlu.controller

import com.nortlu.service.UsuarioService
import io.github.pasteleiros.nortlulib.dto.UsuarioDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/usuarios")
class UsuarioController(val usuarioService: UsuarioService) {

    @Post()
    fun salvarUsuario(@Body usuarioDto: UsuarioDto): HttpResponse<UsuarioDto> =
            HttpResponse.created(usuarioService.salvarUsuario(usuarioDto))

    @Get("/{id}")
    fun buscarUsuario(@PathVariable("id") idUsuario : Long ): HttpResponse<UsuarioDto> =
            HttpResponse.ok(usuarioService.buscarUsuarioPorId(idUsuario))

    @Delete("/{id}")
    fun deletarUsuario(@PathVariable("id") idUsuario : Long ): HttpResponse<UsuarioDto> = usuarioService.deletarUsuarioPorId(idUsuario).let {
        HttpResponse.ok()
    }

    @Put("/{id}")
    fun atualizarUsuario(@PathVariable("id") idUsuario : Long, @Body usuarioDto: UsuarioDto): HttpResponse<UsuarioDto>
        = HttpResponse.ok(usuarioService.atualizarUsuario(usuarioDto.apply { id = idUsuario }))

}