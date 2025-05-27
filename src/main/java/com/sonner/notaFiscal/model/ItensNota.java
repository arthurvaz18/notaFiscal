package com.sonner.notaFiscal.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ItensNota")
public class ItensNota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_itens_nota", unique = true, nullable = false)
    private Integer id;

    @Column(name = "codigo_itens", unique = true, nullable = false)
    private String codigoItens;

    @Column(name = "ordem_nota",nullable = false)
    private String ordemNota;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @Column(name = "quantidade_produto")
    private Integer quantidadeProduto;

    @Column(name = "valorTotal", precision = 18, scale = 2, nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nota_fiscal_id", nullable = false)
    private NotaFiscal notaFiscal;

    ///////////////////Construtor//////////////////////////////////////////////////

    public ItensNota() {
    }

    public ItensNota(Integer id, String codigoItens, String ordemNota, Produto produto, Integer quantidadeProduto, BigDecimal valorTotal, NotaFiscal notaFiscal) {
        this.id = id;
        this.codigoItens = codigoItens;
        this.ordemNota = ordemNota;
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotal = valorTotal;
        this.notaFiscal = notaFiscal;
    }

    ///////////////////Getters and Setters//////////////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
