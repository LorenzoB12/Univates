/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.tables;

import br.com.busolli.lorenzo.vendaslorenzo.entidades.Produto;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author loren
 */
public class TableModelProdutos extends AbstractTableModel {
    
    private ArrayList<Produto> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Descricao", "Valor Unitario", "Qtde Estoque"};
    
    public static final int COL_ID = 0;
    public static final int COL_DESCRICAO = 1;
    public static final int COL_VLR_UNITARIO = 2;
    public static final int COL_QTDE_ESTOQUE = 3;
    
    public TableModelProdutos(ArrayList<Produto> dados) {
        this.dados = dados;
    }
    
    @Override
    public int getRowCount() {
        return this.dados.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Produto produto = (Produto) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = produto.getId();
                    break;
                
                case COL_DESCRICAO:
                    retorno = produto.getDescricao();
                    break;
                
                case COL_VLR_UNITARIO:
                    retorno = produto.getVlrUnitario();
                    break;
                
                case COL_QTDE_ESTOQUE:
                    retorno = produto.getQtdeEstoque();
                    break;
                
                default:
                    retorno = produto;
                    break;
            }
            
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void addTableModelListener(TableModelListener l) {
        return;
    }
    
    @Override
    public void removeTableModelListener(TableModelListener l) {
        return;
    }
    
}
