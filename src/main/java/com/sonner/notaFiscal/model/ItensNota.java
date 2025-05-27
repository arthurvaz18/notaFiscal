package com.sonner.notaFiscal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ItensNota")
public class ItensNota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ordemNota;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidadeProduto;

    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "nota_fiscal_id")
    @JsonBackReference
    private NotaFiscal notaFiscal;

    public ItensNota() {
    }

    public ItensNota(Integer id, String ordemNota, Produto produto, Integer quantidadeProduto, BigDecimal valorTotal, NotaFiscal notaFiscal) {
        this.id = id;
        this.ordemNota = ordemNota;
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotal = valorTotal;
        this.notaFiscal = notaFiscal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdemNota() {
        return ordemNota;
    }

    public void setOrdemNota(String ordemNota) {
        this.ordemNota = ordemNota;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}
