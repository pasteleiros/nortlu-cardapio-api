package com.nortlu.controller

import com.nortlu.service.CategoriaService
import io.github.pasteleiros.nortlulib.dto.CategoriaDto
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller("/categoria")
class CategoriaController (val categoriaService : CategoriaService){
//class CategoriaController (){

    //@Inject
    //lateinit var categoriaService : CategoriaService

    @Get("/listar")
    fun listarCaregorias() : List<CategoriaDto> = categoriaService.listar()
}