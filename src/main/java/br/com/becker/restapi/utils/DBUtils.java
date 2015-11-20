package br.com.becker.restapi.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por funções utilitárias de acesso a base de dados
 *  
 * @author Jonata Becker
 */
public class DBUtils {
    
    /**
     * Executa fechamaneto de conexão com a base de dados
     * 
     * @param conn Conexão
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Executa fechamaneto de result set de conexão com a base de dados
     * 
     * @param rs Result set
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Executa fechamaneto de result set de conexão com a base de dados
     * 
     * @param stmt Statement
     */
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
