package controllers;

import connection.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Usuario;

public class UsuarioController {

public Usuario validarLogin(String login, String senha){
    
                Usuario objUsuario;
    
        try {
            
           
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT * ";
            SQL += " FROM usuarios ";
            SQL += " WHERE login = '" + login + "'";
            SQL += " AND senha = md5 ('" + senha + "')";

            try{
                System.out.println(" Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println(" Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    objUsuario = new Usuario();
                    objUsuario.setId(rs.getInt("id"));
                    objUsuario.setLogin(rs.getString("login"));
                    objUsuario.setNome(rs.getString("nome"));
                    
                    return objUsuario;
                }
            }

            catch (SQLException ex )
            {
                System.out.println(" ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println(" ERRO: " + e.getMessage().toString());
            return null;
        }
        
        return null;
    }

     public boolean incluir(Usuario objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO usuarios(nome, login, senha) VALUES(?,?, MD5(?))");
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getLogin());
            stmt.setString(3, objeto.getSenha());
            
            stmt.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con,stmt);
            return true;
            
       }
    }
    
    public boolean alterar(Usuario objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET nome=?, login= ?, senha = MD5(?) WHERE id=?");
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getLogin());
            stmt.setString(3, objeto.getSenha());
            stmt.setInt(4, objeto.getId());

            stmt.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con,stmt);
            return true;
            
       }
        
    }
    
    public void preencher(JTable jtbUsuarios) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("ID");
        cabecalhos.add("Nome");
        cabecalhos.add("Login");
        
        cabecalhos.add("Excluir");
             
        ResultSet result = null;
        
        try {

            String wSql = "";
            wSql = " SELECT id, nome, login";
            wSql += " FROM usuarios ";
            wSql += "WHERE COALESCE(excluido,false) is false";
            wSql += " ORDER BY id ";
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println(" problemas para popular tabela...");
            System.out.println(e);
        }

        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbUsuarios.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i >= 5; i++) {
            column = jtbUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(30);
                    break;
                case 1:
                    column.setPreferredWidth(100);
                    break;
                case 2:
                    column.setPreferredWidth(100);
                    break;
                case 3:
                    column.setPreferredWidth(100);
                    break;
//                case 4:
  //                  column.setPreferredWidth(60);
    //                break;
               // case 4:
                //    column.setPreferredWidth(30);
                 //   break;
            }
        }
        
        jtbUsuarios.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
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
    
    public Usuario buscar(String id){
        Usuario objUsuario = new Usuario();
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSQL = "";
            wSQL = " SELECT id, nome, login";
            wSQL += " FROM usuarios ";
            wSQL += " WHERE id = '" + id + "'";
            wSQL += "AND COALESCE(excluido,false) is false";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSQL);
                System.out.println("Executou Conexão em buscar");


                if(rs.next() == true)
                {
                    objUsuario.setId(rs.getInt(1));
                    objUsuario.setNome(rs.getString(2));
                    objUsuario.setLogin(rs.getString(3));

                    
            
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
        return objUsuario;
    }
    
    public boolean excluir(Usuario objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET excluido = true WHERE id = ?");
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
