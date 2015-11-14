package br.com.becker.restapi.servlet;

import br.com.becker.restapi.db.ConexaoFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsável pelo controle de requisições da API
 *
 * @author Jonata Becker
 */
public class RestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = ConexaoFactory.getConnection();
            resp.getWriter().println("Ups");
        } catch (Exception e) {
            resp.getWriter().println(e.getMessage());
            resp.setStatus(405);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

}
