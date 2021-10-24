package com.nortlu.controller

import com.nortlu.service.EnderecoService
import io.github.pasteleiros.nortlulib.dto.EnderecoDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/enderecos")
class EnderecoController ( val enderecoService: EnderecoService) {

    @Post
    fun salvar(@Body enderecoDto: EnderecoDto): HttpResponse<EnderecoDto> =
        HttpResponse.created(enderecoService.salvar(enderecoDto))

    @Put
    fun atualizar(@Body enderecoDto: EnderecoDto): HttpResponse<EnderecoDto> =
        HttpResponse.ok(enderecoService.atualizar(enderecoDto))

    @Get("/{id}")
    fun buscar(@PathVariable("id") idEndereco: Long): HttpResponse<EnderecoDto> =
        HttpResponse.ok(enderecoService.buscarEnderecoPorId(idEndereco))

    @Delete("/{id}")
    fun deletar(@PathVariable("id") idEndereco: Long): HttpResponse<EnderecoDto> =
        enderecoService.deletarEndereco(idEndereco).let {
            HttpResponse.ok()
        }

}