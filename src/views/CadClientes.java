/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import connection.Conexao;
import controllers.ClienteController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;
import tools.CaixaDeDialogo;
import tools.Combos;
import tools.Formatacao;
import tools.Validacao;

/**
 *
 * @author User
 */
public class CadClientes extends javax.swing.JFrame {

    Cliente objCliente;
    ClienteController objClienteControle;
    Combos cbCidade;
    
    public CadClientes() throws SQLException {
        initComponents();
        
        //prencher Combos
        
        cbCidade = new Combos(jcbCidade);
        cbCidade.preencheCombo("SELECT id, nome FROM cidades ORDER BY nome");

   
        limparTela();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtDataCad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbCidade = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbClientes = new javax.swing.JTable();
        txtLimpar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtDocumento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTES E FORNECEDORES");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 300, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Razão Social");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Endereço");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 59, -1));
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 300, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Cidade");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 59, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 59, -1));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 300, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("E-mail");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 59, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Documento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 80, -1));

        lblId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));
        getContentPane().add(txtDataCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 150, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Data cadastro");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 250, -1));

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar16.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 270, 90, -1));

        jtbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 670, 360));

        txtLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/limpar-16.png"))); // NOI18N
        txtLimpar.setText("Novo / Limpar");
        txtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimparActionPerformed(evt);
            }
        });
        getContentPane().add(txtLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 150, -1));

        try {
            txtDocumento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 180, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    try{
            boolean retorno;
            retorno = validarDados();
            
            if(retorno) {
                
                objCliente = new Cliente();
                objCliente.setNome(txtNome.getText());
                String data = Formatacao.ajustaDataAMD(txtDataCad.getText());
                objCliente.setData_cad(data);
                objCliente.setEmail(txtEmail.getText());
                objCliente.setCpf_cnpj(txtDocumento.getText());
                objCliente.setEndereco(txtEndereco.getText());
                String telefone = Formatacao.retornaApenasNumeros(txtTelefone.getText());
                objCliente.setTelefone(telefone);
                
                Combos objCombo = (Combos) jcbCidade.getSelectedItem();
                String id_cidade = objCombo.getCodigo();
                objCliente.setId_cidade(Integer.parseInt(id_cidade));
                
                ClienteController objCliController = new ClienteController();
                
             if (lblId.getText().equals("ID")){
                retorno = objCliController.incluir(objCliente);
            }else {
                    objCliente.setId(Integer.parseInt(lblId.getText()));
                    retorno = objCliController.alterar(objCliente);
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

    private void jtbClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbClientesMousePressed
        try{

            int linhaSelecionada = jtbClientes.getSelectedRow();//pega a linha selecionada
            String codigo = jtbClientes.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 2 = EXCLUIR
            //buscar no banco de dados o registro e preencher nos campos da tela
             ClienteController cliController = new ClienteController();
             Cliente objeto = cliController.buscar(codigo);
             
            if(jtbClientes.isColumnSelected(4)){
                try{
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        //exclusão do registro selecionado
                        ClienteController objController = new ClienteController();
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
    }//GEN-LAST:event_jtbClientesMousePressed

    private void txtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimparActionPerformed
            limparTela();
    }//GEN-LAST:event_txtLimparActionPerformed

        private void limparTela(){
        try{
            jcbCidade.setSelectedItem(null);
            lblId.setText("ID");
            txtNome.setText("");
            txtDataCad.setText("");
            txtEndereco.setText("");
            txtDocumento.setText("");
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
        if(!Validacao.validarData(txtDataCad.getText())){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma data corretamente", 'a');
                return false;
        }        
        if(txtEmail.getText().equals("")) {
            if (!Validacao.validarEmail(txtEmail.getText()));{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um email valido", 'a');
                return false;
            }
        }
        if (txtDocumento.getText().trim().length() == 0) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um CPF ou CNPJ corretamente", 'a');
            return false;
             }
        if (txtTelefone.getText().trim().length() == 0) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe o telefone corretamente", 'a');
            return false;
             }
        if (txtEndereco.getText().trim().length() == 0) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um nome corretamente", 'a');
            return false;
             }
        
  
        return true;
    }
    
    private void preencherCampos(Cliente objeto){
        try{
            lblId.setText(String.valueOf(objeto.getId()));
            txtNome.setText(objeto.getNome());
            String data_dma = Formatacao.ajustaDataDMA(objeto.getData_cad());
            txtDataCad.setText(data_dma);
            txtEmail.setText(objeto.getEmail());
            txtEndereco.setText(objeto.getEndereco());
            txtDocumento.setText(objeto.getCpf_cnpj());
            txtTelefone.setText(objeto.getTelefone());
            cbCidade.setaComboBox(String.valueOf(objeto.getId_cidade()));
                       
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Preencher campos. Erro: " + ex.getMessage());
        }
    }   
    
    private void atualizarTabela(){
        try{
            
            objClienteControle = new ClienteController();
            objClienteControle.preencher(jtbClientes);
            
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
            java.util.logging.Logger.getLogger(CadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadClientes().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JTable jtbClientes;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtDataCad;
    private javax.swing.JFormattedTextField txtDocumento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JButton txtLimpar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
