package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.Repository.ItensNotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensNotaServiceImpl implements ItensNotaService {

    @Autowired
    ItensNotaRepository itensNotaRepository;

    public ItensNotaServiceImpl(ItensNotaRepository itensNotaRepository) {
        this.itensNotaRepository = itensNotaRepository;
    }
}
