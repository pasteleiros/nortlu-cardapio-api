package com.nortlu.service

import com.github.pasteleiros.nortlulib.mapper.toDto
import com.github.pasteleiros.nortlulib.mapper.toEntity
import com.github.pasteleiros.nortlulib.mapper.toListDto
import com.nortlu.repo.EnderecoRepo
import com.nortlu.repo.PedidoRepo
import io.github.pasteleiros.nortlulib.dto.PedidoDto
import io.github.pasteleiros.nortlulib.enum.StatusPedido
import io.github.pasteleiros.nortlulib.exception.NaoEncontradoException
import io.github.pasteleiros.nortlulib.mapper.toDto
import javax.inject.Singleton

@Singleton
class PedidoService(val pedidoRepo: PedidoRepo) {

    fun listarPorStatus(statusPedido: StatusPedido) = pedidoRepo.findByStatusPedido(statusPedido.id)

    fun salvar(pedidoDto: PedidoDto): PedidoDto = pedidoRepo.save(pedidoDto.toEntity()).toDto()

    fun atualizar(pedidoDto: PedidoDto): PedidoDto = pedidoRepo.update(pedidoDto.toEntity()).toDto()

    fun buscar(idPedido: Long): PedidoDto = pedidoRepo.findById(idPedido).orElseThrow { NaoEncontradoException("Pedido não encontrado") }.toDto()

    fun deletar(idPedido: Long)  = pedidoRepo.delete(buscar(idPedido).toEntity())

}