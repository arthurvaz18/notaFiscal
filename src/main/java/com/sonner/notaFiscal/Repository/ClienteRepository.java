package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeCliente(String nomeCliente);
    List<Cliente> findByCodigoCliente(String codigoCliente);
    Optional<Cliente> findOneByCodigoCliente(String codigoCliente);
    List<Cliente> findByIdOrNomeCliente(Integer id, String nomeCliente);
    List<Cliente> findByIdAndNomeClienteAndCodigoCliente(Integer id, String nomeCliente, String codigoCliente);
}
