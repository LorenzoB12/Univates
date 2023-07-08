/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.view;

import br.com.busolli.lorenzo.vendaslorenzo.DAO.FornecedorDAO;
import br.com.busolli.lorenzo.vendaslorenzo.DAO.ProdutoDAO;
import br.com.busolli.lorenzo.vendaslorenzo.tables.TableModelFornecedores;
import br.com.busolli.lorenzo.vendaslorenzo.tables.TableModelProdutos;

/**
 *
 * @author loren
 */
public class DlgLocalizarFornecedor extends javax.swing.JDialog {

    private TableModelFornecedores tableModel;
    private FornecedorDAO fornecedorDao = new FornecedorDAO();
    private IfrComprasPrincipal frame;
    
    public DlgLocalizarFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DlgLocalizarFornecedor(java.awt.Frame parent, boolean modal, IfrComprasPrincipal frame){
        super(parent, modal);
        initComponents();
        this.carregarTabela();
        this.frame = frame;
    }
    
    private void carregarTabela(){
        tableModel = new TableModelFornecedores(this.fornecedorDao.consultarTodos());
        jTableItensLocalizarProdutos.setModel(tableModel);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfdFiltroLocalizar = new javax.swing.JTextField();
        btnBuscarLocalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableItensLocalizarProdutos = new javax.swing.JTable();
        btnSelecionarFornecedorDlg = new javax.swing.JButton();
        btnFecharDlgFornecedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Descrição");

        tfdFiltroLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdFiltroLocalizarActionPerformed(evt);
            }
        });

        btnBuscarLocalizar.setText("Buscar");

        jTableItensLocalizarProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableItensLocalizarProdutos);

        btnSelecionarFornecedorDlg.setText("Selecionar");
        btnSelecionarFornecedorDlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarFornecedorDlgActionPerformed(evt);
            }
        });

        btnFecharDlgFornecedor.setText("Fechar");
        btnFecharDlgFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharDlgFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdFiltroLocalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelecionarFornecedorDlg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFecharDlgFornecedor)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdFiltroLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarFornecedorDlg)
                    .addComponent(btnFecharDlgFornecedor))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdFiltroLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdFiltroLocalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdFiltroLocalizarActionPerformed

    private void btnSelecionarFornecedorDlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarFornecedorDlgActionPerformed
        selecionarProduto();
    }//GEN-LAST:event_btnSelecionarFornecedorDlgActionPerformed

    private void btnFecharDlgFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharDlgFornecedorActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharDlgFornecedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgLocalizarFornecedor dialog = new DlgLocalizarFornecedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLocalizar;
    private javax.swing.JButton btnFecharDlgFornecedor;
    private javax.swing.JButton btnSelecionarFornecedorDlg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableItensLocalizarProdutos;
    private javax.swing.JTextField tfdFiltroLocalizar;
    // End of variables declaration//GEN-END:variables

    private void selecionarProduto(){
        String idFornecedor = (String) jTableItensLocalizarProdutos.getValueAt(jTableItensLocalizarProdutos.getSelectedRow(), 0).toString();
        String desFornecedor = (String) jTableItensLocalizarProdutos.getValueAt(jTableItensLocalizarProdutos.getSelectedRow(), 1).toString();
        
        frame.setTfdCodFornecedorOp(idFornecedor);
        frame.setTfdDesFornecedorOp(desFornecedor);
        
        this.dispose();
    }
}
