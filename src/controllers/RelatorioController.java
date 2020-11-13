package controllers;

import connection.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jonasdhein
 */
public class RelatorioController {
        
    public ResultSet buscarRelatorio(String wSelect)
    {
        ResultSet rs = null;
        try {
            Conexao.abreConexao();
            
            String wSql = "";
            wSql = wSelect;

            System.out.println("Vai Executar Conexão em buscar");
            rs = Conexao.stmt.executeQuery(wSql);

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return rs;
        }
        
        System.out.println ("Executou buscar com sucesso");
        return rs;
    }
    
    
    
}
