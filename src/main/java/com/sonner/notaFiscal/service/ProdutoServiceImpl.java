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
    public List<Produto> pesquisarProduto(String codigoProduto, BigDecimal valorProduto, String descricaoProduto) {

        if(codigoProduto == null && valorProduto == null && descricaoProduto == null) {
            return produtoRepository.findByCodigoProdutoAndValorProdutoAndDescricaoProduto(codigoProduto, valorProduto, descricaoProduto);
        }
        else if (codigoProduto != null) {
            return produtoRepository.findByCodigoProduto(codigoProduto);
        }
        else if(valorProduto != null) {
            return produtoRepository.findByValorProduto(valorProduto);
        }
        else if(descricaoProduto != null) {
            return produtoRepository.findByDescricaoProduto(descricaoProduto);
        } else {
            return produtoRepository.findAll();
        }
    }

}
