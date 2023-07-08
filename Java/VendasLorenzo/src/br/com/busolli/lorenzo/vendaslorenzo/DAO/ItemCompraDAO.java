/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.DAO;

import br.com.busolli.lorenzo.vendaslorenzo.apoio.ConexaoBD;
import br.com.busolli.lorenzo.vendaslorenzo.apoio.IDAOT;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Fornecedor;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.ItemCompra;
import br.com.busolli.lorenzo.vendaslorenzo.util.BigDecimalOrDefault;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author loren
 */
public class ItemCompraDAO implements IDAOT<ItemCompra>{

    @Override
    public String salvar(ItemCompra o) {
        try{
            String sql = "INSERT INTO ITENS_COMPRAS (QTDE, VALOR, COMPRA_ID, PRODUTO_ID) VALUES (?, ?, ?, ?)";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            pstm.setBigDecimal(1, o.getQtde());
            pstm.setBigDecimal(2, o.getValor());
            pstm.setLong(3, o.getCompraId());
            pstm.setLong(4, o.getProdutoId());
            pstm.executeUpdate();
            
            System.out.println(sql);
            
            return null;
            
        } catch(Exception e){
            
            System.out.println("Erro ao inserir Compra: " + e);
            return e.toString();
            
        }
    }

    @Override
    public String atualizar(ItemCompra o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String excluir(int id) {
        try{
            System.out.println();
            String sql = "DELETE FROM ITENS_COMPRAS WHERE ID = ?";
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return null;
        } catch(Exception e){
            return e.toString();
        }
    }

    @Override
    public ArrayList<ItemCompra> consultarTodos() {
        ArrayList<ItemCompra> itensCompra = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM ITENS_COMPRAS ORDER BY ID";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Long id = rs.getLong("ID");
                BigDecimal qtde = rs.getBigDecimal("QTDE");
                BigDecimal valor = rs.getBigDecimal("VALOR");
                Long compraId = rs.getLong("COMPRA_ID");
                Long produtoId = rs.getLong("PRODUTO_ID");
                ItemCompra itemCompra = new ItemCompra(id, compraId, produtoId, qtde, valor);
                
                itensCompra.add(itemCompra);
            }
            
            System.out.println(sql);
            
        } catch(Exception e){
            
            System.out.println("Erro ao consultar Itens Compra: " + e);
        }
        
        return itensCompra;
    }
    
    public ArrayList<ItemCompra> consultarPorCompra(Long idCompra){
        ArrayList<ItemCompra> itensCompra = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM ITENS_COMPRAS WHERE COMPRA_ID = " + idCompra + " ORDER BY ID ASC";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Long id = rs.getLong("ID");
                BigDecimal qtde = rs.getBigDecimal("QTDE");
                BigDecimal valor = rs.getBigDecimal("VALOR");
                Long compraId = rs.getLong("COMPRA_ID");
                Long produtoId = rs.getLong("PRODUTO_ID");
                ItemCompra itemCompra = new ItemCompra(id, compraId, produtoId, qtde, valor);
                
                itensCompra.add(itemCompra);
            }
            
            System.out.println(sql);
            
        } catch(Exception e){
            
            System.out.println("Erro ao consultar Itens Compra: " + e);
        }
        
        return itensCompra;
    }

    @Override
    public ArrayList<ItemCompra> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemCompra consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    public BigDecimal valorTotalCompra(Long idCompra){
        try{
            String sql = "SELECT SUM(VALOR * QTDE) FROM ITENS_COMPRAS WHERE COMPRA_ID = " + idCompra;
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            
            String valorTotal = null;
            while(rs.next()){
                valorTotal = rs.getBigDecimal(1).toString();
                return BigDecimalOrDefault.parse(valorTotal);
            }
            
            return BigDecimal.ZERO;
        } catch(Exception e){
            System.out.println("Erro ao consultar Itens Compra: " + e);
            return BigDecimal.ZERO;
        }
    }
}
