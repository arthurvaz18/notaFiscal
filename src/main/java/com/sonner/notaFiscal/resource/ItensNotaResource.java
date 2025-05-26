package com.sonner.notaFiscal.resource;

import com.sonner.notaFiscal.service.ItensNotaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itensNotas")
public class ItensNotaResource {

    ItensNotaService itensNotaService;

    public ItensNotaResource(ItensNotaService itensNotaService) {
        this.itensNotaService = itensNotaService;
    }
}
