/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.view;

import br.com.busolli.lorenzo.vendaslorenzo.DAO.ProdutoDAO;
import br.com.busolli.lorenzo.vendaslorenzo.tables.TableModelProdutos;

/**
 *
 * @author loren
 */
public class DlgLocalizarProduto extends javax.swing.JDialog {

    private TableModelProdutos tableModel;
    private ProdutoDAO produtoDao = new ProdutoDAO();
    private IfrComprasPrincipal frame;
    
    public DlgLocalizarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public DlgLocalizarProduto(java.awt.Frame parent, boolean modal, IfrComprasPrincipal frame){
        super(parent, modal);
        initComponents();
        this.frame = frame;
        this.carregarTabela();
    }
    
    private void carregarTabela(){
        tableModel = new TableModelProdutos(this.produtoDao.consultarTodos());
        jTableProdutosLocalizar.setModel(tableModel);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfdFiltroLocalizar = new javax.swing.JTextField();
        btnBuscarLocalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdutosLocalizar = new javax.swing.JTable();
        btnSelecionarDlgProdutos = new javax.swing.JButton();
        btnFecharDlgProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Descrição");

        tfdFiltroLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdFiltroLocalizarActionPerformed(evt);
            }
        });

        btnBuscarLocalizar.setText("Buscar");

        jTableProdutosLocalizar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProdutosLocalizar);

        btnSelecionarDlgProdutos.setText("Selecionar");
        btnSelecionarDlgProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarDlgProdutosActionPerformed(evt);
            }
        });

        btnFecharDlgProdutos.setText("Fechar");
        btnFecharDlgProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharDlgProdutosActionPerformed(evt);
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
                        .addComponent(btnSelecionarDlgProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFecharDlgProdutos)))
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
                    .addComponent(btnSelecionarDlgProdutos)
                    .addComponent(btnFecharDlgProdutos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdFiltroLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdFiltroLocalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdFiltroLocalizarActionPerformed

    private void btnSelecionarDlgProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarDlgProdutosActionPerformed
        selecionarProduto();
    }//GEN-LAST:event_btnSelecionarDlgProdutosActionPerformed

    private void btnFecharDlgProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharDlgProdutosActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharDlgProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(DlgLocalizarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgLocalizarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgLocalizarProduto dialog = new DlgLocalizarProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFecharDlgProdutos;
    private javax.swing.JButton btnSelecionarDlgProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProdutosLocalizar;
    private javax.swing.JTextField tfdFiltroLocalizar;
    // End of variables declaration//GEN-END:variables

    private void selecionarProduto(){
        String idProdutoSelecionado = (String) jTableProdutosLocalizar.getValueAt(jTableProdutosLocalizar.getSelectedRow(), 0).toString();
        String nomeProdutoSelecionado = (String) jTableProdutosLocalizar.getValueAt(jTableProdutosLocalizar.getSelectedRow(), 1).toString();
        String valorProdutoSelecionado = (String) jTableProdutosLocalizar.getValueAt(jTableProdutosLocalizar.getSelectedRow(), 2).toString();
        
        frame.setTfdCodItemOp(idProdutoSelecionado);
        frame.setTfdDesItemOp(nomeProdutoSelecionado);
        frame.setTfdPrecoItemOp(valorProdutoSelecionado);
        
        this.dispose();
    }

}
