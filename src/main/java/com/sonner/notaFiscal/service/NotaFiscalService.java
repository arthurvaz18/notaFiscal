package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.model.Cliente;
import com.sonner.notaFiscal.model.NotaFiscal;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NotaFiscalService {

    NotaFiscal salvar(NotaFiscal notaFiscal);

    Optional<NotaFiscal> buscarPorId(Integer id);

    void deletarNotaFiscal(NotaFiscal notaFiscal);

    NotaFiscal atualizar(Integer id, NotaFiscal notaFiscal);

    List<NotaFiscal> buscarNotaFiscal(Integer id, LocalDate dataNotaFiscal, Cliente cliente);

}
