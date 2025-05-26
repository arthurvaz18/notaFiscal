package com.sonner.notaFiscal.resource;

import com.sonner.notaFiscal.service.NotaFiscalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notasFiscais")
public class NotaFiscalResource {

    NotaFiscalService notaFiscalService;

    public NotaFiscalResource(NotaFiscalService notaFiscalService) {
        this.notaFiscalService = notaFiscalService;
    }
}
