package com.nortlu.controller

import io.github.pasteleiros.nortlulib.dto.EnderecoDto
import io.github.pasteleiros.nortlulib.dto.UsuarioDto
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloWorld {

    @Get("/world")
    fun hello() = UsuarioDto(1, "Uniliva", "12345678910", "teste@teste.com", "9999-9999", listOf<EnderecoDto>())
}