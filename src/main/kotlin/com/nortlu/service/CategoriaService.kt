package com.nortlu.service

import com.nortlu.repo.CategoriaRepo
import io.github.pasteleiros.nortlulib.dto.CategoriaDto
import io.github.pasteleiros.nortlulib.mapper.toListDto
import javax.inject.Singleton

@Singleton
class CategoriaService (val categoriaRepo : CategoriaRepo) {
    fun listar() : List<CategoriaDto> = categoriaRepo.findAll().toList().toListDto()
}