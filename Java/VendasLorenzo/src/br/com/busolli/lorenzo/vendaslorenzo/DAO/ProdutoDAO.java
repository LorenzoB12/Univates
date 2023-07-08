/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.DAO;

import br.com.busolli.lorenzo.vendaslorenzo.apoio.ConexaoBD;
import br.com.busolli.lorenzo.vendaslorenzo.apoio.IDAOT;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Produto;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class ProdutoDAO implements IDAOT<Produto>{

    @Override
    public String salvar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String atualizar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Produto> consultarTodos() {
        
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM produtos ORDER BY id ASC";
            ResultSet retorno = st.executeQuery(sql);

            Produto produtoObj;
            while (retorno.next()) {
                produtoObj = new Produto();
                produtoObj.setId(retorno.getLong("id"));
                produtoObj.setDescricao(retorno.getString("descricao"));
                produtoObj.setQtdeEstoque(retorno.getString("qtde_estoque"));
                produtoObj.setVlrUnitario(new BigDecimal(retorno.getString("valor_unitario")));
                
                produtos.add(produtoObj);
            }

            return produtos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
        
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produto consultarId(int id) {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM produtos WHERE id = " + id + " ORDER BY id ASC";
            ResultSet retorno = st.executeQuery(sql);

            Produto produtoObj = new Produto();
            while (retorno.next()) {
                produtoObj.setId(retorno.getLong("id"));
                produtoObj.setDescricao(retorno.getString("descricao"));
                produtoObj.setQtdeEstoque(retorno.getString("qtde_estoque"));
                produtoObj.setVlrUnitario(new BigDecimal(retorno.getString("valor_unitario")));
            }

            return produtoObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
