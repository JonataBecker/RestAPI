package br.com.becker.restapi.db;

import br.com.becker.restapi.FindImplementarionException;
import br.com.becker.restapi.FindImplementation;
import br.com.becker.restapi.RestAPIConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

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
     * @throws SQLException Problema ao buscar conexão
     */
    public synchronized static Connection getConnection() throws SQLException {
        try {
            return FindImplementation.get(RestAPIConnectionFactory.class).getConnection();
        } catch (FindImplementarionException e) {
            throw new RuntimeException(e);
        }
    }

}
