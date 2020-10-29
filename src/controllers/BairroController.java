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
import models.Bairro;
import models.Candidato;
/**
 *
 * @author Vinicius
 */
public class BairroController {
    
    
    public boolean incluir(Bairro objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO bairros(nome, id_cidade) VALUES(?,?)");
            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getId_cidade());
            
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
    
    public boolean alterar(Bairro objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE bairros SET nome=?, id_cidade=?  WHERE id=?");
            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getId_cidade());
            stmt.setInt(3, objeto.getId());

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
    
    public void preencher(JTable jtbBairros) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("ID");
        cabecalhos.add("Nome");
        cabecalhos.add("ID Cidade");
        cabecalhos.add("Excluir");
             
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, nome, id_cidade";
            SQL += " FROM bairros ";
            SQL += " ORDER BY id ";
            
            result = Conexao.stmt.executeQuery(SQL);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getInt(3));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println(" problemas para popular tabela...");
            System.out.println(e);
        }

        jtbBairros.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbBairros.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i >= 4; i++) {
            column = jtbBairros.getColumnModel().getColumn(i);
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
               // case 4:
                //    column.setPreferredWidth(30);
                 //   break;
            }
        }
        
        jtbBairros.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
    
    public Bairro buscar(String id){
        Bairro objBairro = new Bairro();
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSQL = "";
            wSQL = " SELECT id, nome, id_cidade";
            wSQL += " FROM bairros ";
            wSQL += " WHERE id = '" + id + "'";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSQL);
                System.out.println("Executou Conexão em buscar");


                if(rs.next() == true)
                {
                    objBairro.setId(rs.getInt(1));
                    objBairro.setNome(rs.getString(2));
                    objBairro.setId_cidade(rs.getInt(3));

                    
                    
            
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
        return objBairro;
    }
    
   /* public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("???");
            stmt.setInt(1, objCandidato.getId());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }*/
    
}
