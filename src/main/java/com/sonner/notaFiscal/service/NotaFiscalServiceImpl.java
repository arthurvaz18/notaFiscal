package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.Repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalServiceImpl(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }
}
