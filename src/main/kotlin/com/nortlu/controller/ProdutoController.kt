package com.nortlu.controller

import com.nortlu.service.ProdutoService
import io.github.pasteleiros.nortlulib.dto.ProdutoDto
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/produtos")
class ProdutoController(val produtoService : ProdutoService) {

    @Post
    fun salvarProduto(@Body produtoDto : ProdutoDto):HttpResponse<ProdutoDto> =
        HttpResponse.created(produtoService.salvar(produtoDto))

    @Get("/{id}")
    fun buscarEndereco(@PathVariable("id") idProduto : Long): HttpResponse<ProdutoDto> =
        HttpResponse.ok(produtoService.buscarProdutoPorId(idProduto))

    @Delete("/{id}")
    fun deletarEndereco(@PathVariable("id") idProduto : Long): HttpResponse<ProdutoDto> = produtoService.deletarProduto(idProduto).let {
        HttpResponse.ok()
    }

    @Put("/{id}")
    fun atualizarEndereco(@PathVariable("id") idProduto : Long, @Body produtoDto: ProdutoDto):
            HttpResponse<ProdutoDto> = produtoService.atualizarEndereco(idProduto, produtoDto).let {
        HttpResponse.ok()
    }
}