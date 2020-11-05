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
import models.Produto;
/**
 *
 * @author Vinicius
 */
public class ProdutoController {
    
    //Candidato objCandidato;
    //JTable jtbCandidatos = null;
    
    //public CandidatoController(Candidato objCandidato, JTable jtbCandidatos) {
      //  this.objCandidato = objCandidato;
        //this.jtbCandidatos = jtbCandidatos;
    //}
    
    public boolean incluir(Produto objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO produtos(nome, data_compra, vl_compra, vl_venda, qtde, id_pessoa) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, objeto.getNome());
            Date data_compra = Date.valueOf(objeto.getData_compra());  
            stmt.setDate(2, data_compra);
            stmt.setFloat(3, objeto.getVl_compra());
            stmt.setFloat(4, objeto.getVl_venda());
            stmt.setFloat(5, objeto.getQtde());
            stmt.setInt(6, objeto.getId_pessoa());
            
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
    
    public boolean alterar(Produto objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produtos SET nome=?, data_compra=?, vl_compra=?, vl_venda=?, qtde=?, id_pessoa=?  WHERE id=?");
            stmt.setString(1, objeto.getNome());
            Date data_compra = Date.valueOf(objeto.getData_compra());  
            stmt.setDate(2, data_compra);
            stmt.setFloat(3, objeto.getVl_compra());
            stmt.setFloat(4, objeto.getVl_venda());
            stmt.setFloat(5, objeto.getQtde());
            stmt.setInt(6, objeto.getId_pessoa());
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
            

       }
        
    }
    
    public void preencher(JTable jtbProdutos) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("#");
        cabecalhos.add("Nome");
        cabecalhos.add("Valor");
        cabecalhos.add("Data Compra");
        cabecalhos.add("Qtde");
        cabecalhos.add("Excluir");
             
        ResultSet result = null;
        
        try {

            String wSql = "";
            wSql = " SELECT id, nome, vl_venda, TO_CHAR (data_compra, 'dd/mm/yyyy') as data_formatada, qtde ";
            wSql += " FROM produtos ";
            wSql += "WHERE COALESCE(excluido,false) is false";
            wSql += " ORDER BY id ";
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getFloat(3));
                linha.add(result.getString(4));
                linha.add(result.getFloat(5));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println(" problemas para popular tabela...");
            System.out.println(e);
        }

        jtbProdutos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbProdutos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 4; i++) {
            column = jtbProdutos.getColumnModel().getColumn(i);
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
                case 4:
                    column.setPreferredWidth(60);
                    break;
  //            case 4:
  //                column.setPreferredWidth(30);
  //                break;
            }
        }
        
        jtbProdutos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
    
    public Produto buscar(String id){
        Produto objProduto = new Produto();
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String wSQL = "";
            wSQL = " SELECT id, nome, data_compra, vl_compra, vl_venda, qtde, id_pessoa";
            wSQL += " FROM produtos ";
            wSQL += " WHERE id = '" + id + "'";
            wSQL += "AND COALESCE(excluido,false) is false";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSQL);
                System.out.println("Executou Conexão em buscar");


                if(rs.next() == true)
                {
                    objProduto.setId(rs.getInt(1));
                    objProduto.setNome(rs.getString(2));
                    objProduto.setData_compra(rs.getString(3));
                    objProduto.setVl_compra(rs.getFloat(4));
                    objProduto.setVl_venda(rs.getFloat(5));
                    objProduto.setQtde(rs.getFloat(6));
                    objProduto.setId_pessoa(rs.getInt(7));
                    
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
        return objProduto;
    }
    
    public boolean excluir(Produto objeto){
        
        Conexao.abreConexao();
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produtos SET excluido = true WHERE id = ?");
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
