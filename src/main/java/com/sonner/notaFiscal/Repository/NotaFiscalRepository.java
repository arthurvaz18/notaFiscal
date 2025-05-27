package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.Cliente;
import com.sonner.notaFiscal.model.NotaFiscal;
import com.sonner.notaFiscal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer> {

    List<NotaFiscal> findByCliente(Cliente cliente);
    List<NotaFiscal> findByDataNotaFiscal(LocalDate dataNotaFiscal);
    Optional<NotaFiscal> findById(String id);
    List<NotaFiscal> findByIdAndDataNotaFiscal(Integer id, LocalDate dataNotaFiscal);
    List<NotaFiscal> findByIdAndCliente(Integer id, Cliente cliente);
    List<NotaFiscal> findByDataNotaFiscalAndCliente(LocalDate dataNotaFiscal, Cliente cliente);
    List<NotaFiscal> findByIdAndDataNotaFiscalAndCliente(Integer id, LocalDate dataNotaFiscal, Cliente cliente);
}
