package com.nortlu.repo

import io.github.pasteleiros.nortlulib.entity.PedidoEntity
import io.github.pasteleiros.nortlulib.entity.ProdutoEntity
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ProdutoRepo : CrudRepository<ProdutoEntity, Long>{
    @Query("FROM produto p WHERE p.ativo = :id")
    fun findByStatus(id: Boolean):List<ProdutoEntity>
}