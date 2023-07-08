/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.DAO;

import br.com.busolli.lorenzo.vendaslorenzo.apoio.ConexaoBD;
import br.com.busolli.lorenzo.vendaslorenzo.apoio.IDAOT;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Fornecedor;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author loren
 */
public class FornecedorDAO implements IDAOT<Fornecedor> {

    @Override
    public String salvar(Fornecedor o) {
        try{
            
            String sql = "INSERT INTO FORNECEDORES (NOME, EMAIL, TELEFONE, CNPJ) VALUES (?, ?, ?, ?)";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            
            pstm.setString(1,o.getNome());
            pstm.setString(2,o.getEmail());
            pstm.setString(3,o.getTelefone());
            pstm.setString(4,o.getCnpj());
            
            pstm.executeUpdate();
            
            System.out.println(sql);
            
            return null;
            
        } catch(Exception e){
            
            System.out.println("Erro ao inserir cidade: " + e);
            return e.toString();
            
        }
    }

    @Override
    public String atualizar(Fornecedor o) {
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update fornecedores "
                    + "set cnpj = '" + o.getCnpj() + "' "
                    + "where id = " + o.getId();
            
            String sql2 = "update fornecedores "
                    + "set email = '" + o.getEmail() + "' "
                    + "where id = " + o.getId();
            
            String sql3 = "update fornecedores "
                    + "set nome = '" + o.getNome() + "' "
                    + "where id = " + o.getId();
            
            String sql4 = "update fornecedores "
                    + "set telefone = '" + o.getTelefone() + "' "
                    + "where id = " + o.getId();

            System.out.println("SQL: " + sql);
            System.out.println("SQL: " + sql2);
            System.out.println("SQL: " + sql3);
            System.out.println("SQL: " + sql4);

            int retorno = st.executeUpdate(sql);
            int retorno2 = st.executeUpdate(sql2);
            int retorno3 = st.executeUpdate(sql3);
            int retorno4 = st.executeUpdate(sql4);

            return null;

        } catch (Exception e) {
            
            System.out.println("Erro ao atualizar Fornecedor: " + e);
            return e.toString();
            
        }
        
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from fornecedores "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            
            System.out.println("Erro ao excluir Fornecedor: " + e);
            return e.toString();
            
        }
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM FORNECEDORES ORDER BY NOME";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String cnpj = rs.getString("cnpj");
                Fornecedor fornecedor = new Fornecedor(id, nome, email, telefone, cnpj);
                
                fornecedores.add(fornecedor);
            }
            
            System.out.println(sql);
            
        } catch(Exception e){
            
            System.out.println("Erro ao consultar fornecedores: " + e);
        }
        
        return fornecedores;
        
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Fornecedor consultarId(int id) {
        
        Fornecedor fornecedor = null;
        
        try{
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from fornecedores "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Integer idForn = retorno.getInt("id");
                String nome = retorno.getString("nome");
                String email = retorno.getString("email");
                String telefone = retorno.getString("telefone");
                String cnpj = retorno.getString("cnpj");
                fornecedor = new Fornecedor(idForn, nome, email, telefone, cnpj);
            }
            
            System.out.println(fornecedor.getId());
            System.out.println(fornecedor.getNome());
            
        } catch (Exception e){
            
            return null;
            
        }
        
        return fornecedor;
        
    }
    
    public void popularTabelaNome(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;
        
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Email";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "Cnpj";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM fornecedores "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][cabecalho.length];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cidades: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM fornecedores "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                dadosTabela[lin][4] = resultadoQ.getString("cnpj");

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
    
    
    
    public void popularTabelaCnpj(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;
        
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Email";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "Cnpj";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM fornecedores "
                    + "WHERE "
                    + "CNPJ ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][cabecalho.length];

        } catch (Exception e) {
            System.out.println("Erro ao consultar cidades: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM fornecedores "
                    + "WHERE "
                    + "CNPJ ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                dadosTabela[lin][4] = resultadoQ.getString("cnpj");

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
