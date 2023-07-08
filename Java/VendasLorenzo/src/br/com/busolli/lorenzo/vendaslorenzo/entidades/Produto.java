/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.entidades;

import java.math.BigDecimal;

/**
 *
 * @author loren
 */
public class Produto {
    
    private Long id;
    private String descricao;
    private BigDecimal vlrUnitario;
    private String qtdeEstoque;

    public Produto(String descricao, BigDecimal vlrUnitario, String qtdeEstoque) {
        this.descricao = descricao;
        this.vlrUnitario = vlrUnitario;
        this.qtdeEstoque = qtdeEstoque;
    }

    public Produto(Long id, String descricao, BigDecimal vlrUnitario, String qtdeEstoque) {
        this.id = id;
        this.descricao = descricao;
        this.vlrUnitario = vlrUnitario;
        this.qtdeEstoque = qtdeEstoque;
    }
    
    public Produto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(BigDecimal vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public String getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(String qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }
}
