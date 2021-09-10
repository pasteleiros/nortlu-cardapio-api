package com.nortlu.repo

import io.github.pasteleiros.nortlulib.entity.PedidoEntity
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface PedidoRepo : CrudRepository<PedidoEntity, Long>{
    @Query("FROM pedido p WHERE p.idStatus = :id")
    fun findByStatusPedido(id: Int):List<PedidoEntity>
}
