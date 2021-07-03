package com.nortlu.repo

import io.github.pasteleiros.nortlulib.entity.CategoriaEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface CategoriaRepo : CrudRepository<CategoriaEntity, Long>