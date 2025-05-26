package com.sonner.notaFiscal.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "NotaFiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nota_fiscal", unique = true, nullable = false)
    private Integer id;

    @Column(name = "data_nota_fiscal", nullable = false)
    private LocalDate dataNotaFiscal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "valor", precision = 18, scale = 2, nullable = false)
    private BigDecimal valorNotaFiscal;

    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL)
    private List<ItensNota> itens;


    //Getters and Setters


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
}
