/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import connection.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Ordem;
import models.Produto;
import models.ProdutoOrdem;

/**
 *
 * @author Vinicius
 */
public class ProdutoOrdemController {
    
public boolean incluir(ProdutoOrdem objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO produtos_ordens(id_ordem, id_produto) VALUES(?,?)");
            stmt.setInt(1, objeto.getId_ordem());
            stmt.setInt(2, objeto.getId_produto());
            
            stmt.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con, stmt);
            return true;
        }
    }
    
    public void preencher(JTable jtbOrdemProduto, int id_ordem) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("#");
        cabecalhos.add("Produto");
        cabecalhos.add("E");
             
        ResultSet result = null;
        
        try {

            String wSql = "";
            wSql = " SELECT po.id_produto, p.nome ";
            wSql += " FROM produtos p INNER JOIN produtos_ordens po ON (po.id_produto = p.id)";
            wSql += " WHERE po.id_ordem= " + id_ordem;
            wSql += " ORDER BY po.id_produto ";
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela2...");
            System.out.println(e);
        }

        jtbOrdemProduto.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbOrdemProduto.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbOrdemProduto.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(20);
                    break;
                case 1:
                    column.setPreferredWidth(150);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        jtbOrdemProduto.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) 
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                
                return this;
            }
        });
        //return (true);
    }
    
    public Ordem buscar(String id)
    {
        Ordem objOrdem = new Ordem();
        
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSql = "";
            wSql = " SELECT id, data, descricao, valor, id_tecnico, id_pessoa, id_produto ";
            wSql += " FROM ordens ";
            wSql += " WHERE id = '" + id + "'";
            wSql += " AND COALESCE(excluido,false) is false ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSql);
                System.out.println("Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    objOrdem.setId(rs.getInt(1));
                    objOrdem.setData(rs.getString(2));
                    objOrdem.setDescricao(rs.getString(3));
                    objOrdem.setValor(rs.getFloat(4));
                    objOrdem.setId_tecnico(rs.getInt(5));
                    objOrdem.setId_pessoa(rs.getInt(6));
                    objOrdem.setId_produto(rs.getInt(7));        
                    
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar area com sucesso");
        return objOrdem;
    }
    public ProdutoOrdem buscarP(String id)
    {
        ProdutoOrdem objProdutoOrdem = new ProdutoOrdem();
        
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSql = "";
            wSql = " SELECT id, id_pessoa, id_produto ";
            wSql += " FROM ordens ";
            wSql += " WHERE id = '" + id + "'";
            wSql += " AND COALESCE(excluido,false) is false ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSql);
                System.out.println("Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    objProdutoOrdem.setId(rs.getInt(1));
                    objProdutoOrdem.setId_pessoa(rs.getInt(2));
                    objProdutoOrdem.setId_produto(rs.getInt(3));        
                    
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar area com sucesso");
        return objProdutoOrdem;
    }
    
    public boolean excluir(ProdutoOrdem objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
           // stmt = con.prepareStatement("UPDATE ordens SET excluido = true WHERE id=?");
            stmt = con.prepareStatement("DELETE FROM produtos_ordens WHERE id=?");
            stmt.setInt(1, objeto.getId());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    

    
}
