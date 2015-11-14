package br.com.becker.restapi;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe responsável pela criação de conexões com a base de dados
 * 
 * @author Jonata Becker
 */
public interface RestAPIConnectionFactory {
    
    /**
     * Retorna conexão com base de dados
     * 
     * @return Connection
     * @throws SQLException Problema ao buscar conexão com a base de dados
     */
    public Connection getConnection() throws SQLException;
    
}
