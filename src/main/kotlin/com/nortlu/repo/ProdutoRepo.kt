package com.nortlu.repo

import io.github.pasteleiros.nortlulib.entity.ProdutoEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ProdutoRepo : CrudRepository<ProdutoEntity, Long>