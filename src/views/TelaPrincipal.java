/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;

/**
 *
 * @author Vinicius
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
        public static Usuario usuarioLogado;
        
    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(TelaPrincipal.MAXIMIZED_BOTH);
        
        lblNomeUsuario.setText("Bem-Vindo " + usuarioLogado.getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        lblNomeUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnMenu = new javax.swing.JMenu();
        mnCadastros = new javax.swing.JMenu();
        mnCliente = new javax.swing.JMenuItem();
        mnProdutos = new javax.swing.JMenuItem();
        mnTecnicos = new javax.swing.JMenuItem();
        mnCidades = new javax.swing.JMenuItem();
        mnOs = new javax.swing.JMenuItem();
        mnRelatorios = new javax.swing.JMenu();
        mnRelatoriosClientes = new javax.swing.JMenuItem();
        mnRelatoriosProdutos = new javax.swing.JMenuItem();
        mnRelatoriosOs = new javax.swing.JMenuItem();
        mnAdministrativo = new javax.swing.JMenu();
        mnUsuarios = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        mnSobre = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenu();
        mnSair2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISTEMA OS");

        mnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menu.png"))); // NOI18N
        mnMenu.setText("Menu");

        mnCadastros.setText("Cadastro");

        mnCliente.setText("Cliente/Fornecedores");
        mnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClienteActionPerformed(evt);
            }
        });
        mnCadastros.add(mnCliente);

        mnProdutos.setText("Produtos");
        mnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProdutosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnProdutos);

        mnTecnicos.setText("Técnicos");
        mnTecnicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnTecnicosMouseClicked(evt);
            }
        });
        mnTecnicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTecnicosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnTecnicos);

        mnCidades.setText("Cidades");
        mnCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCidadesActionPerformed(evt);
            }
        });
        mnCadastros.add(mnCidades);

        mnMenu.add(mnCadastros);

        mnOs.setText("Ordem de serviço");
        mnOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOsActionPerformed(evt);
            }
        });
        mnMenu.add(mnOs);

        jMenuBar1.add(mnMenu);

        mnRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relatorio.png"))); // NOI18N
        mnRelatorios.setText("Relatórios");

        mnRelatoriosClientes.setText("Relatórios de Clientes");
        mnRelatorios.add(mnRelatoriosClientes);

        mnRelatoriosProdutos.setText("Relatório de Produtos");
        mnRelatorios.add(mnRelatoriosProdutos);

        mnRelatoriosOs.setText("Relatorios de OS");
        mnRelatoriosOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRelatoriosOsActionPerformed(evt);
            }
        });
        mnRelatorios.add(mnRelatoriosOs);

        jMenuBar1.add(mnRelatorios);

        mnAdministrativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrativo.png"))); // NOI18N
        mnAdministrativo.setText("Administrativo");

        mnUsuarios.setText("Cad. Usuários");
        mnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsuariosActionPerformed(evt);
            }
        });
        mnAdministrativo.add(mnUsuarios);

        jMenuItem8.setText("Impressoras");
        mnAdministrativo.add(jMenuItem8);

        jMenuBar1.add(mnAdministrativo);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/suporte.png"))); // NOI18N
        jMenu6.setText("Suporte");

        jMenuItem9.setText("Suporte Remoto");
        jMenu6.add(jMenuItem9);

        mnSobre.setText("Sobre");
        mnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSobreActionPerformed(evt);
            }
        });
        jMenu6.add(mnSobre);

        jMenuBar1.add(jMenu6);

        mnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sair.png"))); // NOI18N
        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });

        mnSair2.setText("Sair do Sistema");
        mnSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSair2ActionPerformed(evt);
            }
        });
        mnSair.add(mnSair2);

        jMenuBar1.add(mnSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(355, Short.MAX_VALUE)
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnTecnicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnTecnicosMouseClicked

    }//GEN-LAST:event_mnTecnicosMouseClicked

    private void mnTecnicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTecnicosActionPerformed
       CadTecnicos tela_tecnicos = new CadTecnicos();
        tela_tecnicos.setVisible(true);
    }//GEN-LAST:event_mnTecnicosActionPerformed

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
    }//GEN-LAST:event_mnSairActionPerformed

    private void mnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProdutosActionPerformed
       CadProdutos tela_produtos = null;
            try {
                tela_produtos = new CadProdutos();
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        tela_produtos.setVisible(true);
    }//GEN-LAST:event_mnProdutosActionPerformed

    private void mnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUsuariosActionPerformed
       CadUsuarios tela_usuarios = new CadUsuarios();
        tela_usuarios.setVisible(true);
    }//GEN-LAST:event_mnUsuariosActionPerformed

    private void mnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSobreActionPerformed
       TelaSobre tela_sobre = new TelaSobre();
        tela_sobre.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_mnSobreActionPerformed

    private void mnSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSair2ActionPerformed
        //System.exit(0);
     this.fechar();
    } 
 
    private void fechar(){
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Fechar?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){
            this.dispose();
        }
    
    }//GEN-LAST:event_mnSair2ActionPerformed

    private void mnOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOsActionPerformed
        CadOrdens tela_os = new CadOrdens();
        tela_os.setVisible(true);
    }//GEN-LAST:event_mnOsActionPerformed

    private void mnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnClienteActionPerformed
            try {
                CadClientes tela_cliente = new CadClientes();
                tela_cliente.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_mnClienteActionPerformed

    private void mnCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCidadesActionPerformed
        CadCidades cad_cidade = null;
            try {
                cad_cidade = new CadCidades();
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        cad_cidade.setVisible(true);
    }//GEN-LAST:event_mnCidadesActionPerformed

    private void mnRelatoriosOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRelatoriosOsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnRelatoriosOsActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JMenu mnAdministrativo;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenuItem mnCidades;
    private javax.swing.JMenuItem mnCliente;
    private javax.swing.JMenu mnMenu;
    private javax.swing.JMenuItem mnOs;
    private javax.swing.JMenuItem mnProdutos;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JMenuItem mnRelatoriosClientes;
    private javax.swing.JMenuItem mnRelatoriosOs;
    private javax.swing.JMenuItem mnRelatoriosProdutos;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenuItem mnSair2;
    private javax.swing.JMenuItem mnSobre;
    private javax.swing.JMenuItem mnTecnicos;
    private javax.swing.JMenuItem mnUsuarios;
    // End of variables declaration//GEN-END:variables
}
