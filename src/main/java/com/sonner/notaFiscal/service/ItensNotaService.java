package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.model.ItensNota;

import java.util.List;
import java.util.Optional;

public interface ItensNotaService {

    List<ItensNota> listarTodos();
    Optional<ItensNota> buscarPorId(Integer id);
    List<ItensNota> listarPorNotaFiscal(Integer notaFiscalId);
    ItensNota atualizarItem(Integer id, ItensNota itemAtualizado);
    void deletarItem(Integer id);
}
