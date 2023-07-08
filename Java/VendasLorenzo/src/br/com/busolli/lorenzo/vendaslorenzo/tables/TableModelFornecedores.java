/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.tables;

import br.com.busolli.lorenzo.vendaslorenzo.entidades.Fornecedor;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Produto;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author loren
 */
public class TableModelFornecedores extends AbstractTableModel {
    
    private ArrayList<Fornecedor> dados = new ArrayList<>();
    private final String[] colunas = {"ID", "Nome", "E-mail", "Telefone", "Cnpj"};
    
    public static final int COL_ID = 0;
    public static final int COL_NOME = 1;
    public static final int COL_EMAIL = 2;
    public static final int COL_TELEFONE = 3;
    public static final int COL_CNPJ = 4;
    
    public TableModelFornecedores(ArrayList<Fornecedor> dados) {
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
            Fornecedor fornecedor = (Fornecedor) this.dados.get(rowIndex);
            Object retorno = "";
            switch (columnIndex) {
                case COL_ID:
                    retorno = fornecedor.getId();
                    break;
                
                case COL_NOME:
                    retorno = fornecedor.getNome();
                    break;
                
                case COL_EMAIL:
                    retorno = fornecedor.getEmail();
                    break;
                
                case COL_TELEFONE:
                    retorno = fornecedor.getTelefone();
                    break;
                    
                case COL_CNPJ:
                    retorno = fornecedor.getCnpj();
                    break;
                
                default:
                    retorno = fornecedor;
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
