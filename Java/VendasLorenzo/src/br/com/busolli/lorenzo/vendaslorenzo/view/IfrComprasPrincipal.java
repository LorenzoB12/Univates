/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.busolli.lorenzo.vendaslorenzo.view;

import br.com.busolli.lorenzo.vendaslorenzo.DAO.CompraDAO;
import br.com.busolli.lorenzo.vendaslorenzo.DAO.FornecedorDAO;
import br.com.busolli.lorenzo.vendaslorenzo.DAO.ItemCompraDAO;
import br.com.busolli.lorenzo.vendaslorenzo.apoio.Formatacao;
import br.com.busolli.lorenzo.vendaslorenzo.entidades.ItemCompra;
import br.com.busolli.lorenzo.vendaslorenzo.tables.TableModelFornecedores;
import br.com.busolli.lorenzo.vendaslorenzo.tables.TableModelItensCompras;
import java.math.BigDecimal;
import javax.swing.JInternalFrame;

/**
 *
 * @author loren
 */
public class IfrComprasPrincipal extends javax.swing.JInternalFrame {

    private TableModelItensCompras tableModel;
    private ItemCompraDAO itemCompraDAO = new ItemCompraDAO();
    
    public IfrComprasPrincipal() {
        initComponents();
        tfdDataCompraOp.setText(Formatacao.getDataAtual());
        tfdCodFornecedorOp.setEditable(false);
        tfdDesFornecedorOp.setEditable(false);
        tfdCodItemOp.setEditable(false);
        tfdDesItemOp.setEditable(false);
        tfdPrecoItemOp.setEditable(false);
        tfdValorTotalCompraOp.setEditable(false);
        tfdIdCompra.setEditable(false);
        
        btnLocalizarItem.setEnabled(false);
        btnRemoverItem.setEnabled(false);
        btnInserirItem.setEnabled(false);
    }
    
    public void setTfdCodItemOp(String texto){
        tfdCodItemOp.setText(texto);
    }
    
    public void setTfdDesItemOp(String texto){
        tfdDesItemOp.setText(texto);
    }
    
    public void setTfdPrecoItemOp(String texto){
        tfdPrecoItemOp.setText(texto);
    }
    
    public void setTfdCodFornecedorOp(String texto){
        tfdCodFornecedorOp.setText(texto);
    }
    
    public void setTfdDesFornecedorOp(String texto){
        tfdDesFornecedorOp.setText(texto);
    }
    
    public void habilitarBotoes(){
        btnLocalizarItem.setEnabled(true);
        btnRemoverItem.setEnabled(true);
        btnInserirItem.setEnabled(true);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfdDataCompraOp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdCodFornecedorOp = new javax.swing.JTextField();
        tfdDesFornecedorOp = new javax.swing.JTextField();
        btnLocalizarFornecedor = new javax.swing.JButton();
        btnCriarCompraOp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfdCodItemOp = new javax.swing.JTextField();
        tfdDesItemOp = new javax.swing.JTextField();
        btnLocalizarItem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfdQtdItemOp = new javax.swing.JTextField();
        tfdPrecoItemOp = new javax.swing.JTextField();
        btnRemoverItem = new javax.swing.JButton();
        btnInserirItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableItensCompra = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfdValorTotalCompraOp = new javax.swing.JTextField();
        tfdIdCompra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Ordens de Compra");

        jLabel1.setText("Data");

        jLabel2.setText("Fornecedor");

        tfdCodFornecedorOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdCodFornecedorOpActionPerformed(evt);
            }
        });

        btnLocalizarFornecedor.setText("Localizar");
        btnLocalizarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarFornecedorActionPerformed(evt);
            }
        });

        btnCriarCompraOp.setText("Criar Compra");
        btnCriarCompraOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarCompraOpActionPerformed(evt);
            }
        });

        jLabel3.setText("Item");

        tfdCodItemOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdCodItemOpActionPerformed(evt);
            }
        });

        btnLocalizarItem.setText("Localizar");
        btnLocalizarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarItemActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade");

        tfdQtdItemOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdQtdItemOpActionPerformed(evt);
            }
        });

        btnRemoverItem.setText("Remover");
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        btnInserirItem.setText("Inserir");
        btnInserirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirItemActionPerformed(evt);
            }
        });

        jTableItensCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableItensCompra);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("TOTAL");

        jLabel6.setText("Id Compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfdCodFornecedorOp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdDesFornecedorOp, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfdDataCompraOp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdIdCompra)
                            .addComponent(btnLocalizarFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                    .addComponent(btnCriarCompraOp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdValorTotalCompraOp, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfdCodItemOp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdDesItemOp, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfdQtdItemOp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInserirItem, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(tfdPrecoItemOp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoverItem, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLocalizarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDataCompraOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdCodFornecedorOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdDesFornecedorOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarFornecedor))
                .addGap(18, 18, 18)
                .addComponent(btnCriarCompraOp)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdCodItemOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdDesItemOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarItem)
                    .addComponent(tfdPrecoItemOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfdQtdItemOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemoverItem)
                            .addComponent(btnInserirItem))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel5)
                    .addComponent(tfdValorTotalCompraOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdCodFornecedorOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCodFornecedorOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCodFornecedorOpActionPerformed

    private void tfdCodItemOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdCodItemOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdCodItemOpActionPerformed

    private void tfdQtdItemOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdQtdItemOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdQtdItemOpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLocalizarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarFornecedorActionPerformed
        new DlgLocalizarFornecedor(null, true, this).setVisible(true);
    }//GEN-LAST:event_btnLocalizarFornecedorActionPerformed

    private void btnLocalizarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarItemActionPerformed
        new DlgLocalizarProduto(null, true, this).setVisible(true);
    }//GEN-LAST:event_btnLocalizarItemActionPerformed

    private void btnCriarCompraOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarCompraOpActionPerformed
        this.criarCompra();
    }//GEN-LAST:event_btnCriarCompraOpActionPerformed

    private void btnInserirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirItemActionPerformed
        this.adicionarItemCompra();
    }//GEN-LAST:event_btnInserirItemActionPerformed

    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
        this.excluirItem();
    }//GEN-LAST:event_btnRemoverItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarCompraOp;
    private javax.swing.JButton btnInserirItem;
    private javax.swing.JButton btnLocalizarFornecedor;
    private javax.swing.JButton btnLocalizarItem;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableItensCompra;
    private javax.swing.JTextField tfdCodFornecedorOp;
    private javax.swing.JTextField tfdCodItemOp;
    private javax.swing.JTextField tfdDataCompraOp;
    private javax.swing.JTextField tfdDesFornecedorOp;
    private javax.swing.JTextField tfdDesItemOp;
    private javax.swing.JTextField tfdIdCompra;
    private javax.swing.JTextField tfdPrecoItemOp;
    private javax.swing.JTextField tfdQtdItemOp;
    private javax.swing.JTextField tfdValorTotalCompraOp;
    // End of variables declaration//GEN-END:variables

    private void carregarTabela(Long idCompra){
        tableModel = new TableModelItensCompras(this.itemCompraDAO.consultarPorCompra(idCompra));
        jTableItensCompra.setModel(tableModel);
    }
    
    private void criarCompra(){
        Integer resultado = new CompraDAO().iniciarCompra();
        tfdIdCompra.setText(resultado.toString());
        btnCriarCompraOp.setEnabled(false);
        habilitarBotoes();
    }
    
    private void adicionarItemCompra(){
        Long codItem = Long.parseLong(tfdCodItemOp.getText());
        Long idCompra = Long.parseLong(tfdIdCompra.getText());
        BigDecimal vlrItem = new BigDecimal(tfdPrecoItemOp.getText());
        BigDecimal qtdItem = new BigDecimal(tfdQtdItemOp.getText());
        new ItemCompraDAO().salvar(new ItemCompra(idCompra, codItem, qtdItem, vlrItem));
        setarValorTotalCompra();
        carregarTabela(idCompra);
    }
    
    private void setarValorTotalCompra(){
        Long idCompra = Long.parseLong(tfdIdCompra.getText());
        BigDecimal valorTotalCompra = new ItemCompraDAO().valorTotalCompra(idCompra);
        tfdValorTotalCompraOp.setText(valorTotalCompra.toString());
    }
    
    private void excluirItem(){
        Long numSeqItem = (Long) jTableItensCompra.getValueAt(jTableItensCompra.getSelectedRow(), 0);
        new ItemCompraDAO().excluir(numSeqItem.intValue());
        Long idCompra = Long.parseLong(tfdIdCompra.getText());
        carregarTabela(idCompra);
        setarValorTotalCompra();
    }
}
