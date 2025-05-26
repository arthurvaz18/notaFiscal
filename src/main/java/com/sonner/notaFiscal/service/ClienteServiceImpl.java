package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.Repository.ClienteRepository;
import com.sonner.notaFiscal.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarCliente(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    public List<Cliente> pesquisarCliente(String nomeCliente, String codigoCliente) {

        if ( nomeCliente != null && codigoCliente != null) {
            return clienteRepository.findByNomeClienteAndCodigoCliente(nomeCliente, codigoCliente);
        } else if (nomeCliente != null){
            return clienteRepository.findByNomeCliente(nomeCliente);
        } else if (codigoCliente != null){
            return clienteRepository.findByCodigoCliente(codigoCliente);
        } else {
            return clienteRepository.findAll();
        }
    }

}
