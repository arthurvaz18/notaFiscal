package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.Repository.ProdutoRepository;
import com.sonner.notaFiscal.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> buscarProduto(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public void atualizar(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void deletar(Produto produto) {
        produtoRepository.delete(produto);
    }

    @Override
    public List<Produto> pesquisarProduto(Integer id, String codigoProduto, String descricaoProduto) {

        if (id != null && codigoProduto != null && descricaoProduto != null) {
            return produtoRepository.findByIdAndCodigoProdutoAndDescricaoProduto(id,codigoProduto, descricaoProduto);
        } else if (codigoProduto != null) {
            return produtoRepository.findByCodigoProduto(codigoProduto);
        }else if (descricaoProduto != null) {
            return produtoRepository.findByDescricaoProduto(descricaoProduto);
        } else if (id != null) {
            return produtoRepository.findByIdOrCodigoProduto(id, codigoProduto);
        }else {
            return produtoRepository.findAll();
        }
    }


}
