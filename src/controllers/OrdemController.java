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
/**
 *
 * @author Jonas Dhein
 */
public class OrdemController {
    
    //Candidato objCandidato;
    //JTable jtbCandidatos = null;
    
    //public CandidatoController(Candidato objCandidato, JTable jtbCandidatos) {
      //  this.objCandidato = objCandidato;
        //this.jtbCandidatos = jtbCandidatos;
    //}
    
    public boolean incluir(Ordem objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO ordens( data, descricao, valor, id_tecnico, id_pessoa, id_produto) VALUES(?,?,?,?,?,?)");
            Date data = Date.valueOf(objeto.getData());  
            stmt.setDate(1, data);
            stmt.setString(2, objeto.getDescricao());
            stmt.setFloat(3, objeto.getValor());
            stmt.setInt(4, objeto.getId_tecnico());
            stmt.setInt(5, objeto.getId_pessoa());
            stmt.setInt(6, objeto.getId_produto());
            
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
    
    public boolean alterar(Ordem objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE ordens SET  data=?, descricao=?, valor=?, id_tecnico=?, id_pessoa=?, id_produto=?  WHERE id=?");
            Date data = Date.valueOf(objeto.getData());  
            stmt.setDate(1, data);
            stmt.setString(2, objeto.getDescricao());
            stmt.setFloat(3, objeto.getValor());
            stmt.setInt(4, objeto.getId_tecnico());
            stmt.setInt(5, objeto.getId_pessoa());
            stmt.setInt(6, objeto.getId_produto());
            stmt.setInt(7, objeto.getId());
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
    
    public void preencher(JTable jtbOrdem) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("#");
        cabecalhos.add("NomeCliente");
        cabecalhos.add("Data");
        cabecalhos.add("Valor");
        cabecalhos.add("Excluir");
             
        ResultSet result = null;
        
        try {

            String wSql = "";
            wSql = " SELECT o.id, p.nome, TO_CHAR (o.data, 'dd/mm/yyyy') as data_formatada, o.valor ";
            wSql += " FROM ordens o INNER JOIN pessoas p ON (o.id_pessoa = p.id)";
            wSql += " WHERE COALESCE(o.excluido,false) is false";
            wSql += " ORDER BY id ";
            
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add(result.getFloat(4));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println(" problemas para popular tabela...");
            System.out.println(e);
        }

        jtbOrdem.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbOrdem.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i >= 5; i++) {
            column = jtbOrdem.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(10);
                    break;
                case 1:
                    column.setPreferredWidth(50);
                    break;
                case 2:
                    column.setPreferredWidth(10);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
                case 4:
                    column.setPreferredWidth(10);
                    break;                
                case 5:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        jtbOrdem.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
    
    public Ordem buscar(String id){
        Ordem objOrdem = new Ordem();
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSQL = "";
            wSQL = " SELECT id, data, descricao, valor, id_tecnico, id_pessoa, id_produto";
            wSQL += " FROM ordens ";
            wSQL += " WHERE id = '" + id + "'";
            wSQL += "AND COALESCE(excluido,false) is false";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSQL);
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
    
    public boolean excluir(Ordem objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE ordens SET excluido = true WHERE id = ?");
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
