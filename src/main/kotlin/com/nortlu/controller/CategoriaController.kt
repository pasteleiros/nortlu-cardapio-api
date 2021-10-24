package com.nortlu.controller

import com.nortlu.service.CategoriaService
import io.github.pasteleiros.nortlulib.dto.CategoriaDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/categorias")
class CategoriaController (val categoriaService : CategoriaService){
//class CategoriaController (){

    @Get("/listar")
    fun listarCaregorias(): HttpResponse<List<CategoriaDto>> = HttpResponse.ok(categoriaService.listar())

    @Post
    fun criarCategoria(@Body categoriaDto: CategoriaDto): HttpResponse<CategoriaDto> =
        HttpResponse.created(categoriaService.criar(categoriaDto))

    @Put
    fun deletarCategoria(@Body categoriaDto: CategoriaDto): HttpResponse<CategoriaDto> =
        HttpResponse.ok(categoriaService.atualizar(categoriaDto))

    @Get("/{id}")
    fun buscarPorId(@PathVariable id: Long): HttpResponse<CategoriaDto> = HttpResponse.ok(categoriaService.buscar(id))
}