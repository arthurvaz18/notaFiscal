package com.sonner.notaFiscal.model.dto;

public class ItensNotaDTO {
    private String codigoItens;
    private String ordemNota;
    private Integer idProduto;
    private Integer quantidadeProduto;

    ///////////////////Getters and Setters//////////////////////////////////////////////////

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

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
}
