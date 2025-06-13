package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByCodigoProduto(String codigoProduto);
    List<Produto> findByDescricaoProduto(String descricaoProduto);
    List<Produto> findByIdAndCodigoProdutoAndDescricaoProduto(Integer id, String codigoCliente, String descricaoProduto);
    List<Produto> findByIdOrCodigoProduto(Integer id, String codigoProduto);
    Optional<Produto> findOneByCodigoProduto(String codigoProduto);
}
