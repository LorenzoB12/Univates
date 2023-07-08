/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.tables;

import br.com.busolli.lorenzo.vendaslorenzo.DAO.ItemCompraDAO;
import br.com.busolli.lorenzo.vendaslorenzo.DAO.ProdutoDAO;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Fornecedor;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.ItemCompra;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Produto;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author loren
 */
public class TableModelItensCompras extends AbstractTableModel {
    
    private ArrayList<ItemCompra> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Qtde", "Desc Produto", "Valor"};
    
    public static final int COL_ID = 0;
    public static final int COL_QTDE = 1;
    public static final int COL_DESC_PRODUTO = 2;
    public static final int COL_VALOR = 3;
    
    
    public TableModelItensCompras(ArrayList<ItemCompra> dados) {
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
            ItemCompra itemCompra = (ItemCompra) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = itemCompra.getId();
                    break;
                
                case COL_QTDE:
                    retorno = itemCompra.getQtde();
                    break;
                
                case COL_DESC_PRODUTO:
                    Produto produto = new ProdutoDAO().consultarId(itemCompra.getProdutoId().intValue());
                    retorno = produto.getDescricao();
                    break;
                
                case COL_VALOR:
                    retorno = itemCompra.getValor();
                    break;
                
                default:
                    retorno = itemCompra;
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
