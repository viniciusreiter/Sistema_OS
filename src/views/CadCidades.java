/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CidadeController;
import controllers.CandidatoController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cidade;
import tools.CaixaDeDialogo;
import tools.Combos;
import tools.Formatacao;
import tools.Validacao;

/**
 *
 * @author Vinicius
 */
public class CadCidades extends javax.swing.JFrame {

    Cidade objCidade;
    CidadeController objCidadeControle;
    Combos cbEstado;
    
    public CadCidades() throws SQLException {
        initComponents();
        
        //prencher Combos
        
        cbEstado = new Combos(jcbEstado);
        cbEstado.preencheCombo("SELECT id, nome FROM estados ORDER BY nome");

   
        limparTela();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCidade = new javax.swing.JTable();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CIDADES");

        lblNome.setText("Nome*");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

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

        jtbCidade.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCidadeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCidadeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCidade);

        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Estado");

        jLabel1.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNome))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(jLabel1)))
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;
            retorno = validarDados();
            
            if(retorno) {
                
                objCidade = new Cidade();
                objCidade.setNome(txtNome.getText());
                Combos objCombo = (Combos) jcbEstado.getSelectedItem();
                String id_estado = objCombo.getCodigo();
                objCidade.setId_estado(Integer.parseInt(id_estado));
                CidadeController objCidadeController = new CidadeController();
                
             if (lblId.getText().equals("ID")){
                retorno = objCidadeController.incluir(objCidade);
            }else {
                    objCidade.setId(Integer.parseInt(lblId.getText()));
                    retorno = objCidadeController.alterar(objCidade);
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

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed

        //   Combos c = (Combos) jcbCidade.getSelectedItem();
        //  String codigoCiade = c.getCodigo();
        // obj.setId_bairro(Integer.parseInt(codigoCidade));
    }//GEN-LAST:event_jcbEstadoActionPerformed

    private void jtbCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCidadeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbCidadeMouseClicked

    private void jtbCidadeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCidadeMousePressed
       try{

            int linhaSelecionada = jtbCidade.getSelectedRow();//pega a linha selecionada
            String codigo = jtbCidade.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 2 = EXCLUIR
            if(jtbCidade.isColumnSelected(2)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        //exclusão do registro selecionado
                    }

                    atualizarTabela();

                }catch(Exception ex){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            }else{
            
        //buscar no banco de dados o registro e preencher nos campos da tela

             CidadeController bairroController = new CidadeController();
             Cidade objeto = bairroController.buscar(codigo);
             if(objeto !=null){
                 preencherCampos(objeto);
             }
            }

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }

    
    }//GEN-LAST:event_jtbCidadeMousePressed
    
    private void limparTela(){
        try{
            jcbEstado.setSelectedItem(null);
            lblId.setText("ID");
            txtNome.setText("");
            
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
//        if(!Validacao.validarData(txtDataNasc.getText())){
//                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma data corretamente", 'a');
//                return false;
//        }        
//        if(txtEmail.getText().equals("")) {
//            if (!Validacao.validarEmail(txtEmail.getText()));{
//                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um email valido", 'a');
//                return false;
//            }
//        }
  
        return true;
    }
    
    
    private void preencherCampos(Cidade objeto){
        try{
            lblId.setText(String.valueOf(objeto.getId()));
            txtNome.setText(objeto.getNome());
            cbEstado.setaComboBox(String.valueOf(objeto.getId_estado()));
                       
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Preencher campos. Erro: " + ex.getMessage());
        }
    }   
    
    private void atualizarTabela(){
        try{
            
            objCidadeControle = new CidadeController();
            objCidadeControle.preencher(jtbCidade);
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO ATUALIZAR TABELA: " + ex.getMessage());
        }
    }
    
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
            java.util.logging.Logger.getLogger(CadCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadCidades().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadCidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTable jtbCidade;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
