package com.nortlu.service

import com.nortlu.repo.ProdutoRepo
import io.github.pasteleiros.nortlulib.dto.ProdutoDto
import io.github.pasteleiros.nortlulib.exception.NaoEncontradoException
import io.github.pasteleiros.nortlulib.mapper.toDto
import io.github.pasteleiros.nortlulib.mapper.toEntity
import io.github.pasteleiros.nortlulib.mapper.toListDto
import javax.inject.Singleton

@Singleton
class ProdutoService (val produtoRepo: ProdutoRepo){

    fun salvar(produtoDto: ProdutoDto): ProdutoDto {
        produtoDto.ativo = true
        return produtoRepo.save(produtoDto.toEntity()).toDto();
    }

    fun buscarPorId(id: Long) = produtoRepo.findById(id).orElseThrow { NaoEncontradoException("Produto não encontrado") }.toDto();

    fun deletarLogico(idProduto: Long) {
        this.buscarPorId(idProduto).let {
            it.ativo = false
            produtoRepo.update(it.toEntity())
        }
    }

    fun atualizarEndereco(idProduto: Long, produtoDto: ProdutoDto){
        this.buscarPorId(idProduto).let {
            produtoRepo.update(produtoDto.toEntity());
        }
    }

    fun listarPorStatus(isAtivo: Boolean): List<ProdutoDto>? {
        return produtoRepo.findByStatus(isAtivo).toListDto()
    }
}