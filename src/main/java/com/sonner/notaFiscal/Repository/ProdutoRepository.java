package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByCodigoProduto(String codigoProduto);
    List<Produto> findByValorProduto(BigDecimal valorProduto);
    List<Produto> findByDescricaoProduto(String descricaoProduto);
    List<Produto> findByCodigoProdutoAndDescricaoProduto(String codigoProduto, String descricaoProduto);
    List<Produto> findByCodigoProdutoAndValorProduto(String codigoProduto, BigDecimal valorProduto);
    List<Produto> findByValorProdutoAndDescricaoProduto(BigDecimal valorProduto, String descricaoProduto);
    List<Produto> findByCodigoProdutoAndValorProdutoAndDescricaoProduto(String codigoCliente, BigDecimal valorProduto, String descricaoProduto);
}
