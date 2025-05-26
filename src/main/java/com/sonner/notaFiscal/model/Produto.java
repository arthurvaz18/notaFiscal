package com.sonner.notaFiscal.model;

import javax.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto", unique = true, nullable = false)
    private Integer id;

    @Column(name = "codigo_produto", unique = true, nullable = false)
    private String codigoProduto;

    @Column(name = "valo_produto", precision = 18, scale = 2, nullable = false)
    private String valorProduto;

    @Column(name = "descricao_produto", unique = true, nullable = false)
    private String descricaoProduto;

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(String valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
}
