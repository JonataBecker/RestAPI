package br.com.becker.restapi.db;

import br.com.becker.restapi.utils.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe responsável pelo acesso a base de dados de entidades
 * 
 * @author Jonata Becker
 */
public class EntidadeDAO {

    /** Conexão com a base de dados */
    public final Connection conn;

    public EntidadeDAO(Connection conn) {
        this.conn = conn;
    }
    
    /**
     * Executa busca de registros na base de dados
     * 
     * @param sql
     * @return String
     * @throws SQLException Problema ao realizar busca de registros 
     */
    public String busca(SQLCreator sql) throws SQLException {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            JSONArray arr = new JSONArray();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql.createSelect());
            ResultSetMetaData resultSetMeta = resultSet.getMetaData();
            while (resultSet.next()) {
                int numColumns = resultSetMeta.getColumnCount();
                JSONObject obj = new JSONObject();
                for (int i = 1; i < numColumns + 1; i++) {
                    obj.put(resultSetMeta.getColumnName(i), resultSet.getObject(i));
                }
                arr.put(obj);
            }
            return arr.toString();
        } catch (SQLException e) {
            throw e;
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
    }
}
