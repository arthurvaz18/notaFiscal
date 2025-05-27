package com.sonner.notaFiscal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_fiscal")
    private Integer id;

    @Column(name = "data_nota_fiscal")
    private LocalDate dataNotaFiscal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "valor_nota_fiscal")
    private BigDecimal valorNotaFiscal;

    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItensNota> itens = new ArrayList<>();

    public NotaFiscal() {}

    public NotaFiscal(Integer id, LocalDate dataNotaFiscal, Cliente cliente, BigDecimal valorNotaFiscal, List<ItensNota> itens) {
        this.id = id;
        this.dataNotaFiscal = dataNotaFiscal;
        this.cliente = cliente;
        this.valorNotaFiscal = valorNotaFiscal;
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataNotaFiscal() {
        return dataNotaFiscal;
    }

    public void setDataNotaFiscal(LocalDate dataNotaFiscal) {
        this.dataNotaFiscal = dataNotaFiscal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValorNotaFiscal() {
        return valorNotaFiscal;
    }

    public void setValorNotaFiscal(BigDecimal valorNotaFiscal) {
        this.valorNotaFiscal = valorNotaFiscal;
    }

    public List<ItensNota> getItens() {
        return itens;
    }

    public void setItens(List<ItensNota> itens) {
        this.itens = itens;
    }

    public void addItem(ItensNota item) {
        item.setNotaFiscal(this);
        this.itens.add(item);
    }
}
