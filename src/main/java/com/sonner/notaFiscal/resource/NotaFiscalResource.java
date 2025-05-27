package com.sonner.notaFiscal.resource;

import com.sonner.notaFiscal.model.Cliente;
import com.sonner.notaFiscal.model.ItensNota;
import com.sonner.notaFiscal.model.NotaFiscal;
import com.sonner.notaFiscal.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notasFiscais")
public class NotaFiscalResource {

    @Autowired
    NotaFiscalService notaFiscalService;

    public NotaFiscalResource(NotaFiscalService notaFiscalService) {
        this.notaFiscalService = notaFiscalService;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody NotaFiscal notaFiscal) {
        NotaFiscal notaSalva = notaFiscalService.salvar(notaFiscal);
        URI local = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").build().toUri();
        return ResponseEntity.created(local).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<NotaFiscal> buscarPorId(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<NotaFiscal> notaSalva = notaFiscalService.buscarPorId(id);
        if (notaSalva.isPresent()) {
            return ResponseEntity.ok(notaSalva.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<NotaFiscal> atualizar(@PathVariable Integer id, @RequestBody NotaFiscal notaFiscal) {
        if (notaFiscal.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<NotaFiscal>notaFiscalOptional = notaFiscalService.buscarPorId(id);

        if (notaFiscalOptional.isPresent()) {
            notaFiscalService.atualizar(id, notaFiscal);
            return ResponseEntity.ok(notaFiscal);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        Optional<NotaFiscal> notaSalva = notaFiscalService.buscarPorId(id);
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        notaFiscalService.deletarNotaFiscal(notaSalva.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NotaFiscal>> buscarTodas(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "dataNotaFiscal", required = false) LocalDate dataNotaFiscal,
            @RequestParam(value = "cliente", required = false) Cliente cliente
    ) {
        List<NotaFiscal> notasEncontradas = notaFiscalService.buscarNotaFiscal(id, dataNotaFiscal, cliente);
        return ResponseEntity.ok(notasEncontradas);
    }

}
