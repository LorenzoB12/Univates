/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import entidade.Curriculo;
import entidade.TituloFinanceiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loren
 */
public class TituloFinanceiroDAO {
    
    public List<TituloFinanceiro> buscarTitulos(){
        Connection conn = new ConexaoBD().getConnection();
        List<TituloFinanceiro> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM FINANCEIRO";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codId = resultSet.getInt("id");
                Integer pessoaId = resultSet.getInt("pessoa_id");
                String dtaVencimento = resultSet.getString("data_vencimento");
                Double valorDevido = resultSet.getDouble("valor_devido");
                String dtaPagamento = resultSet.getString("data_pagamento");
                Double valorPago = resultSet.getDouble("valor_pago");
                TituloFinanceiro tit = new TituloFinanceiro(codId.longValue(), pessoaId.longValue(), dtaVencimento, valorDevido, dtaPagamento, valorPago);
                lista.add(tit);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return lista;
    }
    
    public void editarTitulo(TituloFinanceiro titulo){
        Connection conn = new ConexaoBD().getConnection();
        try {
            String sql = "UPDATE FINANCEIRO SET PESSOA_ID = ?, DATA_VENCIMENTO = ?, VALOR_DEVIDO = ?, "
                    + "DATA_PAGAMENTO = ?, VALOR_PAGO = ? WHERE ID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);            
            preparedStatement.setLong(1, titulo.getCodPessoa());
            preparedStatement.setString(2, titulo.getDtaVencimento());
            preparedStatement.setDouble(3, titulo.getValorDevido());
            preparedStatement.setString(4, titulo.getDtaPagamento());
            preparedStatement.setDouble(5, titulo.getValorPago());
            preparedStatement.setDouble(6, titulo.getId());
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void cadastrarTitulo(TituloFinanceiro titulo){
        try{
            Connection conn = new ConexaoBD().getConnection();
            String sql = "INSERT INTO FINANCEIRO (PESSOA_ID, DATA_VENCIMENTO, VALOR_DEVIDO, DATA_PAGAMENTO, VALOR_PAGO) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);            
            preparedStatement.setLong(1, titulo.getCodPessoa());
            preparedStatement.setString(2, titulo.getDtaVencimento());
            preparedStatement.setDouble(3, titulo.getValorDevido());
            preparedStatement.setString(4, titulo.getDtaPagamento());
            preparedStatement.setDouble(5, titulo.getValorPago());
            preparedStatement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void excluirTitulo(Long codId){
        Connection conn = new ConexaoBD().getConnection();
        try {
            String sql = "DELETE FROM FINANCEIRO WHERE ID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);            
            preparedStatement.setLong(1, codId);
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
                /*
    private Long id;
    private Long codPessoa;
    private String dtaVencimento;
    private Double valorDevido;
    private String dtaPagamento;
    private Double valorPago;
    */
    
    /*
    CREATE TABLE FINANCEIRO (
        ID SERIAL NOT NULL,
        PESSOA_ID INTEGER NOT NULL,
        DATA_VENCIMENTO DATE NOT NULL,
        VALOR_DEVIDO NUMERIC NOT NULL,
        DATA_PAGAMENTO DATE NOT NULL,
        VALOR_PAGO NUMERIC NOT NULL,
            PRIMARY KEY(ID)
    );

    */
    
}
