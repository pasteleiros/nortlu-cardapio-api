package com.nortlu.controller

import com.nortlu.service.ProdutoService
import io.github.pasteleiros.nortlulib.dto.PedidoDto
import io.github.pasteleiros.nortlulib.dto.ProdutoDto
import io.github.pasteleiros.nortlulib.enum.StatusPedido
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/produtos")
class ProdutoController(val produtoService : ProdutoService) {

    @Post
    fun salvar(@Body produtoDto : ProdutoDto):HttpResponse<ProdutoDto> =
        HttpResponse.created(produtoService.salvar(produtoDto))

    @Get("/{id}")
    fun buscarEndereco(@PathVariable("id") idProduto : Long): HttpResponse<ProdutoDto> =
        HttpResponse.ok(produtoService.buscarPorId(idProduto))

    @Get("/listar")
    fun listarPorStatus(@QueryValue("ativo")  status : Boolean): HttpResponse<List<ProdutoDto>> {
        return  HttpResponse.ok(produtoService.listarPorStatus(status))
    }


    @Delete("/{id}")
    fun deletarLogico(@PathVariable("id") idProduto : Long): HttpResponse<ProdutoDto> = produtoService.deletarLogico(idProduto).let {
        HttpResponse.ok()
    }

    @Put("/{id}")
    fun atualizarEndereco(@PathVariable("id") idProduto : Long, @Body produtoDto: ProdutoDto):
            HttpResponse<ProdutoDto> = produtoService.atualizarEndereco(idProduto, produtoDto).let {
        HttpResponse.ok()
    }
}