package com.sonner.notaFiscal.resource;

import com.sonner.notaFiscal.model.ItensNota;
import com.sonner.notaFiscal.service.ItensNotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
public class ItensNotaResource {

    @Autowired
    private ItensNotaService itensNotaService;

    @GetMapping
    public ResponseEntity<List<ItensNota>> listarTodos() {
        return ResponseEntity.ok(itensNotaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensNota> buscarPorId(@PathVariable Integer id) {
        return itensNotaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nf/{notaFiscalId}")
    public ResponseEntity<List<ItensNota>> listarPorNotaFiscal(@PathVariable Integer notaFiscalId) {
        return ResponseEntity.ok(itensNotaService.listarPorNotaFiscal(notaFiscalId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItensNota> atualizar(@PathVariable Integer id, @RequestBody ItensNota itemAtualizado) {
        return ResponseEntity.ok(itensNotaService.atualizarItem(id, itemAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        itensNotaService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }
}
