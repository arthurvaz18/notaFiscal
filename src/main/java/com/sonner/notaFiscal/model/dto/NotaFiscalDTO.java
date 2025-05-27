package com.sonner.notaFiscal.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class NotaFiscalDTO {

    private Integer idCliente;
    private LocalDateTime dataNotaFiscal;
    private List<ItensNotaDTO> itensNotaDTOList;

    ///////////////////Getters and Setters//////////////////////////////////////////////////

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getDataNotaFiscal() {
        return dataNotaFiscal;
    }

    public void setDataNotaFiscal(LocalDateTime dataNotaFiscal) {
        this.dataNotaFiscal = dataNotaFiscal;
    }

    public List<ItensNotaDTO> getItensNotaDTOList() {
        return itensNotaDTOList;
    }

    public void setItensNotaDTOList(List<ItensNotaDTO> itensNotaDTOList) {
        this.itensNotaDTOList = itensNotaDTOList;
    }
}
