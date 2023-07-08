package br.com.busolli.lorenzo.oficinamecanica;

import br.com.busolli.lorenzo.oficinamecanica.apoio.ConexaoBD;
import java.sql.*;
import br.com.busolli.lorenzo.oficinamecanica.view.FrmPrincipal;
import javax.swing.JOptionPane;

public class OficinaMecanina {

    static Connection conexao = null;
    
    public static void main(String[] args) {
        if(ConexaoBD.getInstance().getConnection() != null){
            new FrmPrincipal().setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null,"Erro ao conectar no Banco de Dados!");
        }
    }
    
}
