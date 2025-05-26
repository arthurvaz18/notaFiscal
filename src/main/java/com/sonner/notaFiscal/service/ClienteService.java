package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente salvar(Cliente cliente);

    Optional<Cliente> buscarCliente(Integer id);

    void atualizar(Cliente cliente);

    void deletar(Cliente cliente);

    List<Cliente> pesquisarCliente(String nomeCliente, String codigoCliente);
}
