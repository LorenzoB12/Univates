/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.view;

import br.com.busolli.lorenzo.vendaslorenzo.DAO.FornecedorDAO;
import br.com.busolli.lorenzo.vendaslorenzo.apoio.Formatacao;
import br.com.busolli.lorenzo.vendaslorenzo.apoio.Validacao;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.Fornecedor;
import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author loren
 */
public class IfrFornecedores extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrCidade
     */
    public IfrFornecedores() {
        initComponents();

        new FornecedorDAO().popularTabelaNome(tblFornecedores, "");
        
        Formatacao.formatarCnpj(tfdBuscaFornecedorCnpj);
        Formatacao.formatarCnpj(tfdCNPJFornecedor);
        Formatacao.formatarTelefone(tfdTelefoneFornecedor);
    }

    int idFornecedor = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFecharManutCidades = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedores = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfdBuscaFornecedor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tfdBuscaFornecedorCnpj = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdNomeFornecedor = new javax.swing.JTextField();
        tfdEmailFornecedor = new javax.swing.JTextField();
        btnSalvarFornecedor = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        tfdCNPJFornecedor = new javax.swing.JFormattedTextField();
        tfdTelefoneFornecedor = new javax.swing.JFormattedTextField();

        setTitle("Cadastro: Fornecedores");

        btnFecharManutCidades.setText("Fechar");
        btnFecharManutCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharManutCidadesActionPerformed(evt);
            }
        });

        tblFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblFornecedores);

        jLabel5.setText("Busca pelo Nome");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Busca pelo CNPJ");

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tfdBuscaFornecedorCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdBuscaFornecedorCnpjFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfdBuscaFornecedorCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfdBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tfdBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3)
                    .addComponent(tfdBuscaFornecedorCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jLabel1.setText("Nome");

        jLabel2.setText("Email");

        jLabel3.setText("Telefone");

        jLabel4.setText("CNPJ");

        btnSalvarFornecedor.setText("Salvar");
        btnSalvarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarFornecedorActionPerformed(evt);
            }
        });

        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tfdCNPJFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdCNPJFornecedorFocusLost(evt);
            }
        });

        tfdTelefoneFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdTelefoneFornecedorFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdNomeFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                            .addComponent(tfdEmailFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                            .addComponent(tfdCNPJFornecedor)
                            .addComponent(tfdTelefoneFornecedor))))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdEmailFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdTelefoneFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdCNPJFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarFornecedor)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFecharManutCidades)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFecharManutCidades)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharManutCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharManutCidadesActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharManutCidadesActionPerformed

    private void btnSalvarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarFornecedorActionPerformed
        //CADASTRAR

        String nome = tfdNomeFornecedor.getText();
        String email = tfdEmailFornecedor.getText();
        String telefone = tfdTelefoneFornecedor.getText();
        String cnpj = tfdCNPJFornecedor.getText();

        Fornecedor fornecedor = new Fornecedor(nome, email, telefone, cnpj);

        FornecedorDAO fornecedorDao = new FornecedorDAO();

        if (idFornecedor == 0) {

            if (fornecedorDao.salvar(fornecedor) == null) {
                tfdNomeFornecedor.setText("");
                tfdEmailFornecedor.setText("");
                tfdTelefoneFornecedor.setText("");
                tfdCNPJFornecedor.setText("");

                JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");

                tfdNomeFornecedor.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao salvar registro!");
            }

        //EDITAR    
            
        } else{
            fornecedor.setId(idFornecedor);
            
            if(fornecedorDao.atualizar(fornecedor) == null){
                
                tfdNomeFornecedor.setText("");
                tfdEmailFornecedor.setText("");
                tfdTelefoneFornecedor.setText("");
                tfdCNPJFornecedor.setText("");
                
                JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso!");
                
                tfdNomeFornecedor.requestFocus();
                
            } else{
                
                JOptionPane.showMessageDialog(this, "Problemas ao atualizar registro!");
                
            }
            
        }

        fornecedorDao.popularTabelaNome(tblFornecedores, "");
        
        idFornecedor = 0;
        
    }//GEN-LAST:event_btnSalvarFornecedorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String criterio = tfdBuscaFornecedor.getText();
        new FornecedorDAO().popularTabelaNome(tblFornecedores, criterio);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String criterio = tfdBuscaFornecedorCnpj.getText();
        new FornecedorDAO().popularTabelaCnpj(tblFornecedores, criterio);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String idTabela = String.valueOf(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 0));
        String nome = String.valueOf(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 1));
        String email = String.valueOf(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 2));
        String telefone = String.valueOf(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 3));
        String cnpj = String.valueOf(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 4));

        idFornecedor = Integer.parseInt(idTabela);

        Fornecedor fornecedor = new FornecedorDAO().consultarId(idFornecedor);

        if (fornecedor != null) {
            jTabbedPane1.setSelectedIndex(1);

            tfdNomeFornecedor.setText(fornecedor.getNome());
            tfdCNPJFornecedor.setText(fornecedor.getCnpj());
            tfdEmailFornecedor.setText(fornecedor.getEmail());
            tfdTelefoneFornecedor.setText(fornecedor.getTelefone());

            tfdNomeFornecedor.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Id do fornecedor não encontrado!");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String idTabela = String.valueOf(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 0));
        idFornecedor = Integer.parseInt(idTabela);
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        
        try{
            
            fornecedorDAO.excluir(idFornecedor);
            
        } catch (Exception e){
            
            JOptionPane.showMessageDialog(this, "Id do fornecedor não encontrado!");
            
        }
        
        fornecedorDAO.popularTabelaNome(tblFornecedores, "");
        
        idFornecedor = 0;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tfdBuscaFornecedorCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdBuscaFornecedorCnpjFocusLost
        if (!tfdBuscaFornecedorCnpj.getText().contains(" ")) {

            if (!Validacao.validarCNPJ(tfdBuscaFornecedorCnpj.getText().replaceAll("[^0-9]", ""))) {

                tfdBuscaFornecedorCnpj.setBackground(Color.YELLOW);

            } else {

                tfdBuscaFornecedorCnpj.setBackground(Color.WHITE);

            }

        } else {

            tfdCNPJFornecedor.setText("");
            tfdBuscaFornecedorCnpj.setBackground(Color.YELLOW);

        }
    }//GEN-LAST:event_tfdBuscaFornecedorCnpjFocusLost

    private void tfdCNPJFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdCNPJFornecedorFocusLost
        if (!tfdCNPJFornecedor.getText().contains(" ")) {

            if (!Validacao.validarCNPJ(tfdCNPJFornecedor.getText().replaceAll("[^0-9]", ""))) {

                tfdCNPJFornecedor.setBackground(Color.YELLOW);

            } else {

                tfdCNPJFornecedor.setBackground(Color.WHITE);

            }

        } else {

            tfdCNPJFornecedor.setText("");
            tfdCNPJFornecedor.setBackground(Color.YELLOW);

        }
    }//GEN-LAST:event_tfdCNPJFornecedorFocusLost

    private void tfdTelefoneFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfdTelefoneFornecedorFocusLost

        System.out.println(tfdTelefoneFornecedor.getText().length());
        
        if (tfdTelefoneFornecedor.getText().trim().length() == 16) {

            if (!Validacao.validarTelefone(tfdTelefoneFornecedor)) {

                tfdTelefoneFornecedor.setBackground(Color.YELLOW);

            } else {

                tfdTelefoneFornecedor.setBackground(Color.WHITE);

            }

        } else {

            tfdTelefoneFornecedor.setText("");
            tfdTelefoneFornecedor.setBackground(Color.YELLOW);

        }
        
    }//GEN-LAST:event_tfdTelefoneFornecedorFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFecharManutCidades;
    private javax.swing.JButton btnSalvarFornecedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblFornecedores;
    private javax.swing.JTextField tfdBuscaFornecedor;
    private javax.swing.JFormattedTextField tfdBuscaFornecedorCnpj;
    private javax.swing.JFormattedTextField tfdCNPJFornecedor;
    private javax.swing.JTextField tfdEmailFornecedor;
    private javax.swing.JTextField tfdNomeFornecedor;
    private javax.swing.JFormattedTextField tfdTelefoneFornecedor;
    // End of variables declaration//GEN-END:variables
}