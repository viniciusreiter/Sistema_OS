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
import models.Tecnico;
/**
 *
 * @author Vinicius
 */
public class TecnicoController {
    
    
    public boolean incluir(Tecnico objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO tecnicos(nome) VALUES(?)");
            stmt.setString(1, objeto.getNome());
            
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
    
    public boolean alterar(Tecnico objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tecnicos SET nome=? WHERE id=?");
            stmt.setString(1, objeto.getNome());
            stmt.setInt(2, objeto.getId());

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
    
    public void preencher(JTable jtbTecnicos) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("ID");
        cabecalhos.add("Nome");
        cabecalhos.add("Excluir");
             
        ResultSet result = null;
        
        try {

            String wSql = "";
            wSql = " SELECT id, nome";
            wSql += " FROM tecnicos ";
            wSql += "WHERE COALESCE(excluido,false) is false";
            wSql += " ORDER BY id ";
            
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
            System.out.println(" problemas para popular tabela...");
            System.out.println(e);
        }

        jtbTecnicos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbTecnicos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i >= 3; i++) {
            column = jtbTecnicos.getColumnModel().getColumn(i);
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
               // case 3:
                //    column.setPreferredWidth(150);
                  //  break;
//                case 4:
  //                  column.setPreferredWidth(60);
    //                break;
               // case 4:
                //    column.setPreferredWidth(30);
                 //   break;
            }
        }
        
        jtbTecnicos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
    
    public Tecnico buscar(String id){
        Tecnico objTecnico = new Tecnico();
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSQL = "";
            wSQL = " SELECT id, nome";
            wSQL += " FROM tecnicos ";
            wSQL += " WHERE id = '" + id + "'";
            wSQL += "AND COALESCE(excluido,false) is false";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSQL);
                System.out.println("Executou Conexão em buscar");


                if(rs.next() == true)
                {
                    objTecnico.setId(rs.getInt(1));
                    objTecnico.setNome(rs.getString(2));

                    
            
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
        return objTecnico;
    }
    
    public boolean excluir(Tecnico objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tecnicos SET excluido = true WHERE id = ?");
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
