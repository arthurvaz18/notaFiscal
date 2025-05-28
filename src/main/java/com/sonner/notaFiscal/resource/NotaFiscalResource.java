package com.sonner.notaFiscal.resource;

import com.sonner.notaFiscal.model.NotaFiscal;
import com.sonner.notaFiscal.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaFiscalResource {

        @Autowired
        private NotaFiscalService notaFiscalService;

        @PostMapping
        public ResponseEntity<NotaFiscal> criarNota(@RequestBody NotaFiscal notaFiscal) {
            NotaFiscal notaSalva = notaFiscalService.criarNotaFiscal(notaFiscal);
            return ResponseEntity.status(HttpStatus.CREATED).body(notaSalva);
        }

        @GetMapping
        public ResponseEntity<List<NotaFiscal>> listarNotas() {
            List<NotaFiscal> notas = notaFiscalService.listarNotas();
            return ResponseEntity.ok(notas);
        }

        @GetMapping("{id}")
        public ResponseEntity<NotaFiscal> buscarNotaPorId(@PathVariable("id") Integer id) {
            return notaFiscalService.buscarNotaPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarNota(@PathVariable Integer id) {
            notaFiscalService.deletarNota(id);
            return ResponseEntity.noContent().build();
        }
}