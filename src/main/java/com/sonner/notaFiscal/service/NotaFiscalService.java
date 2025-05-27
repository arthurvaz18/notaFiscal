package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.model.NotaFiscal;

import java.util.List;
import java.util.Optional;

public interface NotaFiscalService {

    NotaFiscal criarNotaFiscal(NotaFiscal notaFiscal);
    List<NotaFiscal> listarNotas();
    Optional<NotaFiscal> buscarNotaPorId(Integer id);
    void deletarNota(Integer id);
}
