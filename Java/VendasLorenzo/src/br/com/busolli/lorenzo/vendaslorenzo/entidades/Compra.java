/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.entidades;

import java.time.LocalDateTime;

/**
 *
 * @author loren
 */
public class Compra {
    
    private Long id;
    
    private String data;
    
    private Long forncedorId;
    
    public Compra(String data, Long forncedorId) {
        this.data = data;
        this.forncedorId = forncedorId;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getForncedorId() {
        return forncedorId;
    }

    public void setForncedorId(Long forncedorId) {
        this.forncedorId = forncedorId;
    }
    
}
