package com.sonner.notaFiscal.resource;

import com.sonner.notaFiscal.model.Produto;
import com.sonner.notaFiscal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoResource {

    ProdutoService produtoService;

    @Autowired
    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Produto produto) {
        Produto clienteSalvo = produtoService.salvar(produto);
        URI local = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteSalvo.getId())
                .toUri();
        return ResponseEntity.created(local).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> buscar(@PathVariable("id") Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Produto> produto = produtoService.buscarProduto(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Integer id, @RequestBody Produto produto) {

        if (!id.equals(produto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Produto> produtoSalvo = produtoService.buscarProduto(id);

        if (!produtoSalvo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoService.atualizar(produto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id) {
        Optional<Produto> produtoSalvo = produtoService.buscarProduto(id);

        if (!produtoSalvo.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        produtoService.deletar(produtoSalvo.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<List<Produto>> listar(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "codigoProduto", required = false) String codigoProduto,
            @RequestParam(value = "descricaoProduto", required = false) String  descricaoProduto
    ) {
        List<Produto> produtosEncontrados = produtoService.pesquisarProduto(id, codigoProduto, descricaoProduto);
        return ResponseEntity.ok(produtosEncontrados);
    }

}
