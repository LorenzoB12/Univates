/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo;

import br.com.busolli.lorenzo.vendaslorenzo.apoio.ConexaoBD;
import br.com.busolli.lorenzo.vendaslorenzo.view.DlgLogin;
import br.com.busolli.lorenzo.vendaslorenzo.view.FrmPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author loren
 */
public class VendasLorenzo {

    public static void main(String[] args) {
        /*if(ConexaoBD.getInstance().getConnection() != null){
            new FrmPrincipal().setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null,"Erro ao conectar no Banco de Dados!");
        }*/
        new DlgLogin(null, true).setVisible(true);
    }
    
}
