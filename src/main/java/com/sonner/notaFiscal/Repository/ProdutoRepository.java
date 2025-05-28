package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.Cliente;
import com.sonner.notaFiscal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByCodigoProduto(String codigoProduto);
    List<Produto> findByDescricaoProduto(String descricaoProduto);
    List<Produto> findByIdAndCodigoProdutoAndDescricaoProduto(Integer id, String codigoCliente, String descricaoProduto);
    List<Produto> findByIdOrCodigoProduto(Integer id, String codigoProduto);
}
