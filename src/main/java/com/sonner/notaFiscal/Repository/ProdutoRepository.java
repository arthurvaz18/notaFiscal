package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
