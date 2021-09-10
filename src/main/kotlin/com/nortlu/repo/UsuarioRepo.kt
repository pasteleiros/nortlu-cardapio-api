package com.nortlu.repo

import io.github.pasteleiros.nortlulib.entity.CategoriaEntity
import io.github.pasteleiros.nortlulib.entity.UsuarioEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UsuarioRepo: CrudRepository<UsuarioEntity, Long> {
}