package com.nortlu.repo

import io.github.pasteleiros.nortlulib.entity.EnderecoEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface EnderecoRepo  : CrudRepository<EnderecoEntity, Long>{


}