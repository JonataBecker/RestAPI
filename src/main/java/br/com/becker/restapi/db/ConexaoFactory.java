package br.com.becker.restapi.db;

import java.sql.Connection;

/**
 * Classe responsável pela criação de conexão com a base de dados
 * 
 * @author Jonata Becker
 */
public class ConexaoFactory {
    
    /**
     * Retorna nova conexão com a base de dados
     * 
     * @return Connection
     */
    public synchronized static Connection getConnection() {
        return null;
    }
    
}
