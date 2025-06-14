package com.sonner.notaFiscal.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", unique = true, nullable = false)
    private Integer id;

    @Column(name = "codigo_cliente", unique = true, nullable = false)
    @NotNull
    private String codigoCliente;

    @Column(name = "nome_cliente", unique = true, nullable = false)
    @NotNull
    private String nomeCliente;

    ///////////////////Construtor//////////////////////////////////////////////////

    public Cliente() {
    }

    public Cliente(Integer id, String codigoCliente, String nomeCliente) {
        this.id = id;
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
    }

    ///////////////////Getters and Setters//////////////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
