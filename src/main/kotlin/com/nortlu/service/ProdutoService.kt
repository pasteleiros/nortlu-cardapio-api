package com.nortlu.service

import com.nortlu.repo.ProdutoRepo
import io.github.pasteleiros.nortlulib.dto.EnderecoDto
import io.github.pasteleiros.nortlulib.dto.ProdutoDto
import io.github.pasteleiros.nortlulib.exception.NaoEncontradoException
import io.github.pasteleiros.nortlulib.mapper.toDto
import io.github.pasteleiros.nortlulib.mapper.toEntity
import javax.inject.Singleton

@Singleton
class ProdutoService (val produtoRepo: ProdutoRepo){

    fun salvar(produtoDto: ProdutoDto): ProdutoDto = produtoRepo.save(produtoDto.toEntity()).toDto();

    fun buscarProdutoPorId(id: Long) = produtoRepo.findById(id).orElseThrow { NaoEncontradoException("Endereço não encontrado") }.toDto();

    fun deletarProduto(idProduto: Long) {
        this.buscarProdutoPorId(idProduto).let { produtoRepo.deleteById(idProduto) }
    }

    fun atualizarEndereco(idProduto: Long, produtoDto: ProdutoDto){
        this.buscarProdutoPorId(idProduto).let {
            produtoRepo.update(produtoDto.toEntity());
        }
    }
}