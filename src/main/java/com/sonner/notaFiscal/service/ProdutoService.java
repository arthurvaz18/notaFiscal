package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto salvar(Produto produto);

    Optional<Produto> buscarProduto(Integer id);

    void atualizar(Produto produto);

    void deletar(Produto produto);

    List<Produto> pesquisarProduto(Integer id, String codigoProduto, String descricaoProduto);
}
