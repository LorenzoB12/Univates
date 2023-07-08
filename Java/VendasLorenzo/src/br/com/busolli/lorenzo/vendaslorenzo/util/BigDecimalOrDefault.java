/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.util;

import java.math.BigDecimal;

/**
 *
 * @author loren
 */
public class BigDecimalOrDefault {
    
    public static BigDecimal parse(String valor){
        try{
            return new BigDecimal(valor);
        } catch(Exception e){
            return BigDecimal.ZERO;
        }
    }
    
}
