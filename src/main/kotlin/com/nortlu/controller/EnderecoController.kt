package com.nortlu.controller

import com.nortlu.service.EnderecoService
import io.github.pasteleiros.nortlulib.dto.EnderecoDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*

@Controller("/enderecos")
class EnderecoController ( val enderecoService: EnderecoService) {

    @Post
    fun salvarEndereco(@Body enderecoDto: EnderecoDto):HttpResponse<EnderecoDto> =
            HttpResponse.created(enderecoService.salvar(enderecoDto))

    @Get("/{id}")
    fun buscarEndereco(@PathVariable("id") idEndereco : Long): HttpResponse<EnderecoDto> =
            HttpResponse.ok(enderecoService.buscarEnderecoPorId(idEndereco))
}