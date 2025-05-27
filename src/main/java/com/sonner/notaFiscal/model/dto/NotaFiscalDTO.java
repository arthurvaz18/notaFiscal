package com.sonner.notaFiscal.model.dto;

import java.time.LocalDate;
import java.util.List;

public class NotaFiscalDTO {
    private Integer idCliente;
    private LocalDate dataNotaFiscal;
    private List<ItensNotaDTO> itensNotaDTOList;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getDataNotaFiscal() {
        return dataNotaFiscal;
    }

    public void setDataNotaFiscal(LocalDate dataNotaFiscal) {
        this.dataNotaFiscal = dataNotaFiscal;
    }

    public List<ItensNotaDTO> getItensNotaDTOList() {
        return itensNotaDTOList;
    }

    public void setItensNotaDTOList(List<ItensNotaDTO> itensNotaDTOList) {
        this.itensNotaDTOList = itensNotaDTOList;
    }

    public static class ItensNotaDTO {
        private String codigoItens;
        private String ordemNota;
        private Integer produtoId;
        private Integer quantidadeProduto;

        public String getCodigoItens() {
            return codigoItens;
        }

        public void setCodigoItens(String codigoItens) {
            this.codigoItens = codigoItens;
        }

        public String getOrdemNota() {
            return ordemNota;
        }

        public void setOrdemNota(String ordemNota) {
            this.ordemNota = ordemNota;
        }

        public Integer getProdutoId() {
            return produtoId;
        }

        public void setProdutoId(Integer produtoId) {
            this.produtoId = produtoId;
        }

        public Integer getQuantidadeProduto() {
            return quantidadeProduto;
        }

        public void setQuantidadeProduto(Integer quantidadeProduto) {
            this.quantidadeProduto = quantidadeProduto;
        }


    }
}
