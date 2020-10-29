package views;

import connection.Conexao;
import controllers.CandidatoController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Candidato;
import tools.CaixaDeDialogo;
import tools.Combos;
import tools.Formatacao;
import tools.Validacao;

/**
 *
 * @author Vinicius
 */
public class CadCandidatos extends javax.swing.JFrame {

    Candidato objCandidato;
    CandidatoController objCandidatoControle;
    Combos cbBairro;
    
    
    public CadCandidatos() throws SQLException {
        initComponents();
        
        //prencher Combos
        
        cbBairro = new Combos(jcbBairro);
        cbBairro.preencheCombo("SELECT id, nome FROM bairros ORDER BY nome");

   
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

        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCandidatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDataNasc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbBairro = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jtbCandidatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCandidatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCandidatos);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Campos com * são obrigatórios");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cadastro de Candidatos");

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome *");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data Nasc. *");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Telefone");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Bairro *");

        jcbBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBairroActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("E-mail ");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar))
                            .addComponent(jLabel7)
                            .addComponent(lblId)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jcbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(5, 5, 5)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(3, 3, 3)
                        .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(287, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            boolean retorno;
            retorno = validarDados();
            
            if(retorno) {
                
                objCandidato = new Candidato();
                objCandidato.setNome(txtNome.getText());
                String data = Formatacao.ajustaDataAMD(txtDataNasc.getText());
                objCandidato.setData_nascimento(data);
                objCandidato.setEmail(txtEmail.getText());
                String telefone = Formatacao.retornaApenasNumeros(txtTelefone.getText());
                objCandidato.setTelefone(telefone);
                
                Combos objCombo = (Combos) jcbBairro.getSelectedItem();
                String id_bairro = objCombo.getCodigo();
                objCandidato.setId_bairro(Integer.parseInt(id_bairro));
                
                CandidatoController objCandController = new CandidatoController();
                
             if (lblId.getText().equals("ID")){
                retorno = objCandController.incluir(objCandidato);
            }else {
                    objCandidato.setId(Integer.parseInt(lblId.getText()));
                    retorno = objCandController.alterar(objCandidato);
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

    private void jtbCandidatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCandidatosMousePressed
        try{

            int linhaSelecionada = jtbCandidatos.getSelectedRow();//pega a linha selecionada
            String codigo = jtbCandidatos.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 2 = EXCLUIR
            //buscar no banco de dados o registro e preencher nos campos da tela
             CandidatoController candController = new CandidatoController();
             Candidato objeto = candController.buscar(codigo);
             
            if(jtbCandidatos.isColumnSelected(4)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        //exclusão do registro selecionado
                        CandidatoController objController = new CandidatoController();
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

    }//GEN-LAST:event_jtbCandidatosMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jcbBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBairroActionPerformed
        
     //   Combos c = (Combos) jcbBairro.getSelectedItem();
      //  String codigoBairro = c.getCodigo();
       // obj.setId_bairro(Integer.parseInt(codigoBairro));
    }//GEN-LAST:event_jcbBairroActionPerformed

    private void txtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    
    private void limparTela(){
        try{
            jcbBairro.setSelectedItem(null);
            lblId.setText("ID");
            txtNome.setText("");
            txtDataNasc.setText("");
            txtEmail.setText("");
            txtTelefone.setText("");
            
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
        if(!Validacao.validarData(txtDataNasc.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma data corretamente", 'a');
                return false;
        }        
        if(txtEmail.getText().equals("")) {
            if (!Validacao.validarEmail(txtEmail.getText()));{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um email valido", 'a');
                return false;
            }
        }
  
        return true;
    }
    
    private void preencherCampos(Candidato objeto){
        try{
            lblId.setText(String.valueOf(objeto.getId()));
            txtNome.setText(objeto.getNome());
            String data_dma = Formatacao.ajustaDataDMA(objeto.getData_nascimento());
            txtDataNasc.setText(data_dma);
            txtEmail.setText(objeto.getEmail());
            txtTelefone.setText(objeto.getTelefone());
            cbBairro.setaComboBox(String.valueOf(objeto.getId_bairro()));
                       
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Preencher campos. Erro: " + ex.getMessage());
        }
    }   
    
    private void atualizarTabela(){
        try{
            
            objCandidatoControle = new CandidatoController();
            objCandidatoControle.preencher(jtbCandidatos);
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(CadCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCandidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadCandidatos().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadCandidatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbBairro;
    private javax.swing.JTable jtbCandidatos;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
