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
public class ItemCompra {
    
    private Long id;
    private Long compraId;
    private Long produtoId;
    private BigDecimal qtde;
    private BigDecimal valor;

    public ItemCompra(Long id, Long compraId, Long produtoId, BigDecimal qtde, BigDecimal valor) {
        this.id = id;
        this.compraId = compraId;
        this.produtoId = produtoId;
        this.qtde = qtde;
        this.valor = valor;
    }

    public ItemCompra( Long compraId, Long produtoId, BigDecimal qtde, BigDecimal valor) {
        this.compraId = compraId;
        this.produtoId = produtoId;
        this.qtde = qtde;
        this.valor = valor;
    }
    
    public ItemCompra(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public BigDecimal getQtde() {
        return qtde;
    }

    public void setQtde(BigDecimal qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
