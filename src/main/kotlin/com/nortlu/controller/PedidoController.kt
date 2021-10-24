package com.nortlu.controller

import com.nortlu.service.EnderecoService
import com.nortlu.service.PedidoService
import io.github.pasteleiros.nortlulib.dto.EnderecoDto
import io.github.pasteleiros.nortlulib.dto.PedidoDto
import io.github.pasteleiros.nortlulib.enum.StatusPedido
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*

@Controller("/pedidos")
class PedidoController (val pedidoService: PedidoService) {

    @Get("/listar")
    fun listar(@QueryValue("status")  status : String): HttpResponse<List<PedidoDto>> {
      return  HttpResponse.ok(pedidoService.listarPorStatus(StatusPedido.parse(status)))
    }


    @Post
    fun salvar(@Body pedidoDto: PedidoDto):HttpResponse<PedidoDto> =
            HttpResponse.created(pedidoService.salvar(pedidoDto))

    @Put("/cancelar")
    fun cancelar(@Body pedidoDto: PedidoDto):HttpResponse<PedidoDto> =
        HttpResponse.created(pedidoService.cancelar(pedidoDto))

    @Get("/{id}")
    fun buscar(@PathVariable("id") idPedido : Long): HttpResponse<PedidoDto> =
            HttpResponse.ok(pedidoService.buscar(idPedido))

}