/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.DAO;

import br.com.busolli.lorenzo.vendaslorenzo.apoio.ConexaoBD;
import br.com.busolli.lorenzo.vendaslorenzo.apoio.IDAOT;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Compra;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Fornecedor;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author loren
 */
public class CompraDAO implements IDAOT<Compra>{

    @Override
    public String salvar(Compra o) {
        try{
            
            String sql = "INSERT INTO COMPRAS (DATA, ID_FORNECEDOR) VALUES (?, ?)";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            
            pstm.setString(1, o.getData());
            pstm.setLong(2, o.getForncedorId());
            
            pstm.executeUpdate();
            
            System.out.println(sql);
            
            return null;
            
        } catch(Exception e){
            
            System.out.println("Erro ao inserir Compra: " + e);
            return e.toString();
            
        }
    }
    
    public Integer iniciarCompra() {
        try{
            String sql = "INSERT INTO COMPRAS (DATA, ID_FORNECEDOR) VALUES (null, null) RETURNING ID";
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            Integer idCompra = null;
            
            while(rs.next()){
                idCompra = rs.getInt("ID");
            }
            
            return idCompra;
        } catch(Exception e){
            System.out.println("Erro ao inserir Compra: " + e);
            return null;
        }
    }

    @Override
    public String atualizar(Compra o) {
        
                try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE COMPRAS "
                    + "SET DATA = '" + o.getData() + "' "
                    + "WHERE ID = " + o.getId();
            
            String sql2 = "UPDATE COMPRAS "
                    + "SET ID_FORNECEDOR = '" + o.getForncedorId() + "' "
                    + "WHERE ID = " + o.getId();

            System.out.println("SQL: " + sql);
            System.out.println("SQL: " + sql2);

            int retorno = st.executeUpdate(sql);
            int retorno2 = st.executeUpdate(sql2);

            return null;

        } catch (Exception e) {
            
            System.out.println("Erro ao atualizar Compra: " + e);
            return e.toString();
            
        }
        
    }

    @Override
    public String excluir(int id) {
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM COMPRAS "
                    + "WHERE ID = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            
            System.out.println("Erro ao excluir Compra: " + e);
            return e.toString();
            
        }
        
    }

    @Override
    public ArrayList<Compra> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Compra> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Compra consultarId(int id) {
        
        Compra compra = null;
        
        try{
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from compras "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Integer idCompra = retorno.getInt("id");
                String data = retorno.getString("data");
                Integer idFornecedor = retorno.getInt("id_fornecedor");
                Long idLong = idFornecedor.longValue();
                
                compra = new Compra(data, idLong);
                compra.setId(idCompra.longValue());
            }
            
        } catch (Exception e){
            
            return null;
            
        }
        
        return compra;
        
    }
    
    public void popularTabelaData(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;
        
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Data";
        cabecalho[2] = "Id_Fornecedor";
        cabecalho[3] = "Fornecedor";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM COMPRAS "
                    + "WHERE "
                    + "DATA ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][cabecalho.length];

        } catch (Exception e) {
            System.out.println("Erro ao consultar Compra: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT C.ID, C.DATA, C.ID_FORNECEDOR, F.NOME "
                    + "FROM COMPRAS C, FORNECEDORES F "
                    + "WHERE C.ID_FORNECEDOR = F.ID AND "
                    + "DATA ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("ID");
                dadosTabela[lin][1] = resultadoQ.getString("DATA");
                dadosTabela[lin][2] = resultadoQ.getInt("ID_FORNECEDOR");
                dadosTabela[lin][3] = resultadoQ.getString("NOME");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite selecao de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
    }
    
    public void popularTabelaFornecedor(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;
        
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Data";
        cabecalho[2] = "Id_Fornecedor";
        cabecalho[3] = "Fornecedor";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM COMPRAS C, FORNECEDORES F "
                    + "WHERE C.ID_FORNECEDOR = F.ID "
                    + "AND F.NOME ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][cabecalho.length];

        } catch (Exception e) {
            System.out.println("Erro ao consultar Compra: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT C.ID, C.DATA, C.ID_FORNECEDOR, F.NOME "
                    + "FROM COMPRAS C, FORNECEDORES F "
                    + "WHERE C.ID_FORNECEDOR = F.ID AND "
                    + "F.NOME ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("ID");
                dadosTabela[lin][1] = resultadoQ.getString("DATA");
                dadosTabela[lin][2] = resultadoQ.getInt("ID_FORNECEDOR");
                dadosTabela[lin][3] = resultadoQ.getString("NOME");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite selecao de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
    }
    
}
