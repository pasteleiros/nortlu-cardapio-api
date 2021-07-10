package com.nortlu.controller

import com.nortlu.service.CategoriaService
import io.github.pasteleiros.nortlulib.dto.CategoriaDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/categoria")
class CategoriaController (val categoriaService : CategoriaService){
//class CategoriaController (){

    //@Inject
    //lateinit var categoriaService : CategoriaService

    @Get("/listar")
    fun listarCaregorias() : List<CategoriaDto> = categoriaService.listar()

    @Post
    fun criarCategoria(@Body categoriaDto : CategoriaDto) : CategoriaDto = categoriaService.criar(categoriaDto)

    @Delete("/{id}")
    fun deletarCategoria(@PathVariable id: Long) = categoriaService.deletar(id)

    @Get("/{id}")
    fun buscarPorId(@PathVariable id: Long) : HttpResponse<CategoriaDto> = HttpResponse.ok(categoriaService.buscar(id))
}