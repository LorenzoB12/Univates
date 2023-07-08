/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.ProdutoValidade;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author pretto
 */
public class ProdutoValidadeDAO implements IDAOT<ProdutoValidade> {

    @Override
    public String salvar(ProdutoValidade pv) {
        // exemplo de insercao
        try {
            String sql = "insert into PRODUTO_VALIDADE values (default, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            pstm.setString(1, pv.getDataHoraCadastro());
            pstm.setString(2, pv.getDataHoraCompra());
            pstm.setString(3, pv.getNome());
            pstm.setString(4, pv.getDataHoraFabricacao());
            pstm.setString(5, pv.getDataVencimento());
            pstm.setString(6, pv.getObservacao());
                    
            System.out.println("SQL: " + sql);

            pstm.executeUpdate();

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir Produto: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(ProdutoValidade pv) {
        try {
            String sql = "update PRODUTO_VALIDADE set DATA_HORA_CADASTRO = ?, DATA_HORA_COMPRA = ?, NOME_PRODUTO = ?, "
                       + "DATA_HORA_FABRICACAO = ?, DATA_VENCIMENTO = ?, OBSERVACAO = ? where ID = ?";
            
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            pstm.setString(1, pv.getDataHoraCadastro());
            pstm.setString(2, pv.getDataHoraCompra());
            pstm.setString(3, pv.getNome());
            pstm.setString(4, pv.getDataHoraFabricacao());
            pstm.setString(5, pv.getDataVencimento());
            pstm.setString(6, pv.getObservacao());
            pstm.setLong(7, pv.getId());
            
            System.out.println("SQL: " + sql);

            pstm.executeUpdate();

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Produto: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from PRODUTO_VALIDADE "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Produto: " + e);
            return e.toString();
        }

    }

    @Override
    public ArrayList<ProdutoValidade> consultarTodos() {

        ArrayList<ProdutoValidade> produtos = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM PRODUTO_VALIDADE "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                ProdutoValidade produto = new ProdutoValidade();

                produto.setId(retorno.getLong("ID"));
                produto.setDataHoraCadastro(retorno.getString("DATA_HORA_CADASTRO"));
                produto.setDataHoraCompra(retorno.getString("DATA_HORA_COMPRA"));
                produto.setNome(retorno.getString("NOME_PRODUTO"));
                produto.setDataHoraFabricacao(retorno.getString("DATA_HORA_FABRICACAO"));
                produto.setDataVencimento(retorno.getString("DATA_VENCIMENTO"));
                produto.setObservacao(retorno.getString("OBSERVACAO"));

                produtos.add(produto);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Produto: " + e);
        }

        return produtos;
    }

    @Override
    public ArrayList<ProdutoValidade> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProdutoValidade consultarId(int id) {

        ProdutoValidade produtoValidade = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM PRODUTO_VALIDADE "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                produtoValidade = new ProdutoValidade();
                
                produtoValidade.setId(retorno.getLong("ID"));
                produtoValidade.setDataHoraCadastro(retorno.getString("DATA_HORA_CADASTRO"));
                produtoValidade.setDataHoraCompra(retorno.getString("DATA_HORA_COMPRA"));
                produtoValidade.setNome(retorno.getString("NOME_PRODUTO"));
                produtoValidade.setDataHoraFabricacao(retorno.getString("DATA_HORA_FABRICACAO"));
                produtoValidade.setDataVencimento(retorno.getString("DATA_VENCIMENTO"));
                produtoValidade.setObservacao(retorno.getString("OBSERVACAO"));
                
                System.out.println(produtoValidade.getId());
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Produto: " + e);
        }

        return produtoValidade;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Dth Cadastro";
        cabecalho[3] = "Dth Compra";
        cabecalho[4] = "Dth Fabricacao";
        cabecalho[5] = "Dta Vencimento";
        cabecalho[6] = "Observação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM PRODUTO_VALIDADE "
                    + "WHERE "
                    + "NOME_PRODUTO ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM PRODUTO_VALIDADE "
                    + "WHERE "
                    + "NOME_PRODUTO ILIKE '%" + criterio + "%' "
                    + "ORDER BY ID");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("ID");
                dadosTabela[lin][1] = resultadoQ.getString("NOME_PRODUTO");
                dadosTabela[lin][2] = resultadoQ.getString("DATA_HORA_CADASTRO");
                dadosTabela[lin][3] = resultadoQ.getString("DATA_HORA_COMPRA");
                dadosTabela[lin][4] = resultadoQ.getString("DATA_HORA_FABRICACAO");
                dadosTabela[lin][5] = resultadoQ.getString("DATA_VENCIMENTO");
                dadosTabela[lin][6] = resultadoQ.getString("OBSERVACAO");

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
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }

}
