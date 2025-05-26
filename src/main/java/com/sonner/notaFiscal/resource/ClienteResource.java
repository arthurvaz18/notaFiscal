package com.sonner.notaFiscal.resource;

import com.sonner.notaFiscal.model.Cliente;
import com.sonner.notaFiscal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    ClienteService clienteService;

    @Autowired
    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.salvar(cliente);
        URI local = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteSalvo.getId())
                .toUri();
        return ResponseEntity.created(local).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable("id") Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Cliente> cliente = clienteService.buscarCliente(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Integer id,@RequestBody Cliente cliente) {

        if (!id.equals(cliente.getId())) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Cliente> clienteOptional = clienteService.buscarCliente(id);

        if (!clienteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        clienteService.atualizar(cliente);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id) {
        Optional<Cliente> clienteOptional = clienteService.buscarCliente(id);

        if (!clienteOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        clienteService.deletar(clienteOptional.get());

        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> pesquisarCliente(
            @RequestParam(value = "nomeCliente", required = false) String nomeCliente,
            @RequestParam(value = "codigoCliente", required = false) String codigoCliente) {
        List<Cliente> clientesEncontrados = clienteService.pesquisarCliente(nomeCliente, codigoCliente);
        return ResponseEntity.ok(clientesEncontrados);
    }
}
