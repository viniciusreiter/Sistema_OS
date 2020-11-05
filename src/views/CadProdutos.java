/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.ProdutoController;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Produto;
import tools.CaixaDeDialogo;
import tools.Combos;
import tools.Formatacao;
import tools.Validacao;

/**
 *
 * @author Vinicius
 */
public class CadProdutos extends javax.swing.JFrame {

    Produto objProduto;
    ProdutoController objProdutoControle;
    Combos cbFornecedor;
    
    static DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
    
    public CadProdutos() throws SQLException {
        initComponents();
        
        cbFornecedor = new Combos(jcbFornecedor);
        cbFornecedor.preencheCombo("SELECT id, nome FROM pessoas ORDER BY nome");
        
        limparTela();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jcbFornecedor = new javax.swing.JComboBox<>();
        txtEstoque = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProdutos = new javax.swing.JTable();
        txtDataCompra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtValorCompra = new javax.swing.JFormattedTextField();
        txtValorVenda = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblId.setText("ID");

        jcbFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Valor Compra");

        jLabel2.setText("Valor venda");

        jLabel3.setText("Qtde Estoque");

        jLabel4.setText("Nome do Produto");

        jLabel5.setText("Fornecedor");

        jtbProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbProdutosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbProdutos);

        jLabel6.setText("Data de Compra");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtValorCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        txtValorVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(btnSalvar))
                                .addGap(51, 51, 51)
                                .addComponent(btnLimpar))
                            .addComponent(lblId)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jcbFornecedor, javax.swing.GroupLayout.Alignment.LEADING, 0, 297, Short.MAX_VALUE)
                                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblId)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
try{
            boolean retorno;
            retorno = validarDados();
            
            if(retorno) {
                
                objProduto = new Produto();
                objProduto.setNome(txtNome.getText());
                String data = Formatacao.ajustaDataAMD(txtDataCompra.getText());
                objProduto.setData_compra(data);
                objProduto.setVl_compra(Float.parseFloat(txtValorCompra.getText()));
                objProduto.setVl_venda(Float.parseFloat(txtValorVenda.getText()));
                objProduto.setQtde(Float.parseFloat(txtEstoque.getText()));
                //String telefone = Formatacao.retornaApenasNumeros(txtTelefone.getText());
                //objProduto.setTelefone(telefone);
                
                Combos objCombo = (Combos) jcbFornecedor.getSelectedItem();
                String id_pessoa = objCombo.getCodigo();
                objProduto.setId_pessoa(Integer.parseInt(id_pessoa));
                
                ProdutoController objProdController = new ProdutoController();
                
             if (lblId.getText().equals("ID")){
                retorno = objProdController.incluir(objProduto);
            }else {
                    objProduto.setId(Integer.parseInt(lblId.getText()));
                    retorno = objProdController.alterar(objProduto);
                }
             
             if (retorno == false){
                 CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir");
             } else {
                 limparTela();
             }
                
            }

            atualizarTabela();

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtbProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProdutosMousePressed
        try{

            int linhaSelecionada = jtbProdutos.getSelectedRow();//pega a linha selecionada
            String codigo = jtbProdutos.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 2 = EXCLUIR
            //buscar no banco de dados o registro e preencher nos campos da tela
             ProdutoController prodController = new ProdutoController();
             Produto objeto = prodController.buscar(codigo);
             
            if(jtbProdutos.isColumnSelected(5)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        //exclusão do registro selecionado
                        ProdutoController objController = new ProdutoController();
                        boolean retorno = objController.excluir(objeto);
                        if(retorno){
                         CaixaDeDialogo.obterinstancia().exibirMensagem("Registro excluido com sucesso");   
                        }else{
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir ");
                        }
                    }

                    atualizarTabela();

                }catch(Exception ex){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            }else{
 //buscar no banco de dados o registro e preencher nos campos da tela

             if(objeto !=null){
                 preencherCampos(objeto);
             }
            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbProdutosMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
    limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(CadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadProdutos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    
    
        private void limparTela(){
        try{
            jcbFornecedor.setSelectedItem(null);
            lblId.setText("ID");
            txtNome.setText("");
            txtDataCompra.setText("");
            txtValorCompra.setText("");
            txtValorVenda.setText("");
            txtEstoque.setText("");
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }   
    
    private boolean validarDados(){
        
        if (txtNome.getText().trim().length() == 0) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um nome corretamente", 'a');
            return false;
             }
        if(!Validacao.validarData(txtDataCompra.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma data corretamente", 'a');
                return false;
        }        
        if(txtValorCompra.getText().equals("")) {
            if (!Validacao.validarEmail(txtValorCompra.getText()));{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um valor valido", 'a');
                return false;
            }
        }
  
        return true;
    }
    
    private void preencherCampos(Produto objeto){
        try{
            lblId.setText(String.valueOf(objeto.getId()));
            txtNome.setText(objeto.getNome());
            String data_dma = Formatacao.ajustaDataDMA(objeto.getData_compra());
            txtDataCompra.setText(data_dma);
        //  txtValorCompra.setText(Float.toString(objeto.getVl_compra()));
        //  txtValorVenda.setText(Float.toString(objeto.getVl_venda()));
        //  txtEstoque.setText(Float.toString(objeto.getVl_venda()));
            txtValorCompra.setText(String.valueOf(objeto.getVl_compra()));
            txtValorVenda.setText(String.valueOf(objeto.getVl_venda()));
            txtEstoque.setText(String.valueOf(objeto.getQtde()));
            cbFornecedor.setaComboBox(String.valueOf(objeto.getId_pessoa()));
                       
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Preencher campos. Erro: " + ex.getMessage());
        }
    }   
    
    private void atualizarTabela(){
        try{
            
            objProdutoControle = new ProdutoController();
            objProdutoControle.preencher(jtbProdutos);
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbFornecedor;
    private javax.swing.JTable jtbProdutos;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtDataCompra;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtValorCompra;
    private javax.swing.JFormattedTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables
}
