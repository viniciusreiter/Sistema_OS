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
import models.Cliente;
/**
 *
 * @author Jonas Dhein
 */
public class ClienteController {
    
    //Cliente objCliente;
    //JTable jtbClientes = null;
    
    //public ClienteController(Cliente objCliente, JTable jtbClientes) {
      //  this.objCliente = objCliente;
        //this.jtbClientes = jtbClientes;
    //}
    
    public boolean incluir(Cliente objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO pessoas(nome, id_cidade, data_cad, endereco, telefone, email, cpf_cnpj) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getId_cidade());
            Date data_cad = Date.valueOf(objeto.getData_cad());  
            stmt.setDate(3, data_cad);
            stmt.setString(4, objeto.getEndereco());
            stmt.setString(5, objeto.getTelefone());
            stmt.setString(6, objeto.getEmail());
            stmt.setString(7, objeto.getCpf_cnpj());
            
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
            
//        }catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            return false;
//        }catch (Exception ex){
//            System.out.println(ex.getMessage());
//            return false;
//        }finally{
//            Conexao.closeConnection(con, stmt);
       }
    }
    
    public boolean alterar(Cliente objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pessoas SET nome=?, id_cidade=?, data_cad=?, endereco=?, telefone=?, email=? cpf_cnpj=?  WHERE id=?");
            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getId_cidade());
            Date data_cad = Date.valueOf(objeto.getData_cad());  
            stmt.setDate(3, data_cad);
            stmt.setString(4, objeto.getEndereco());
            stmt.setString(5, objeto.getTelefone());
            stmt.setString(6, objeto.getEmail());
            stmt.setString(7, objeto.getCpf_cnpj());
            stmt.setInt(8, objeto.getId());
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
            

            
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            return false;
//        }finally{
//            Conexao.closeConnection(con, stmt);
//            return true;
       }
        
    }
    
    public void preencher(JTable jtbClientes) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("#");
        cabecalhos.add("Nome");
        cabecalhos.add("Data Cadastro");
        cabecalhos.add("Email");
       // cabecalhos.add("Bairro");
        cabecalhos.add("Excluir");
             
        ResultSet result = null;
        
        try {

            String wSql = "";
            wSql = " SELECT id, nome, TO_CHAR (data_cad, 'dd/mm/yyyy') as data_formatada, email ";
            wSql += " FROM pessoas ";
            wSql += "WHERE COALESCE(excluido,false) is false";
            wSql += " ORDER BY id ";
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
 //               linha.add(result.getInt(5));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println(" problemas para popular tabela...");
            System.out.println(e);
        }

        jtbClientes.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbClientes.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 4; i++) {
            column = jtbClientes.getColumnModel().getColumn(i);
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
                    column.setPreferredWidth(150);
                    break;
//                case 4:
  //                  column.setPreferredWidth(60);
    //                break;
                case 4:
                    column.setPreferredWidth(30);
                    break;
            }
        }
        
        jtbClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
    
    public Cliente buscar(String id){
        Cliente objCliente = new Cliente();
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSQL = "";
            wSQL = " SELECT id, nome, id_cidade, data_cad, endereco, telefone, email, cpf_cnpj";
            wSQL += " FROM pessoas ";
            wSQL += " WHERE id = '" + id + "'";
            wSQL += "AND COALESCE(excluido,false) is false";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSQL);
                System.out.println("Executou Conexão em buscar");


                if(rs.next() == true)
                {
                    objCliente.setId(rs.getInt(1));
                    objCliente.setNome(rs.getString(2));
                    objCliente.setId_cidade(rs.getInt(3));
                    objCliente.setData_cad(rs.getString(4));
                    objCliente.setEndereco(rs.getString(5));
                    objCliente.setTelefone(rs.getString(6));
                    objCliente.setEmail(rs.getString(7));
                    objCliente.setCpf_cnpj(rs.getString(8));
                    
                    
                    
                    //FALTA OS DEMAIS CAMPOS!!!
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
        return objCliente;
    }
    
    public boolean excluir(Cliente objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pessoas SET excluido = true WHERE id = ?");
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
