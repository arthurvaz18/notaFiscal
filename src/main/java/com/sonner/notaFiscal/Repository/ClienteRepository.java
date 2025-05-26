package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
