package com.sonner.notaFiscal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    @JsonFormat(pattern =  "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataHoraNotaFiscal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "valor_nota_fiscal")
    private BigDecimal valorNotaFiscal;

    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItensNota> itens = new ArrayList<>();

    public NotaFiscal() {}

    public NotaFiscal(Integer id, LocalDateTime dataNotaFiscal, Cliente cliente, BigDecimal valorNotaFiscal, List<ItensNota> itens) {
        this.id = id;
        this.dataHoraNotaFiscal = dataNotaFiscal;
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

    public LocalDateTime getDataHoraNotaFiscal() {
        return dataHoraNotaFiscal;
    }

    public void setDataHoraNotaFiscal(LocalDateTime dataHoraNotaFiscal) {
        this.dataHoraNotaFiscal = dataHoraNotaFiscal;
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
