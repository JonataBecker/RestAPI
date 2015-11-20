package br.com.becker.restapi.servlet;

import br.com.becker.restapi.ParameterURL;
import br.com.becker.restapi.db.ConexaoFactory;
import br.com.becker.restapi.db.EntidadeDAO;
import br.com.becker.restapi.db.Filtro;
import br.com.becker.restapi.db.FiltroFactory;
import br.com.becker.restapi.db.SQLCreator;
import br.com.becker.restapi.db.Tabela;
import br.com.becker.restapi.utils.DBUtils;
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

    /**
     * Adiciona header JSON
     * 
     * @param resp 
     */
    private void addHeaderJSON(HttpServletResponse resp) {
        resp.setHeader("Content-Type", "application/json");
    }
    
    /**
     * Metodo responsável pela busca de informações da base de dados
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = ConexaoFactory.getConnection();
            ParameterURL parameterURL = new ParameterURL(req);
            Tabela tabela = new Tabela(parameterURL.getEntidade());
            Filtro filtro = FiltroFactory.create(req.getParameterMap());
            EntidadeDAO dao = new EntidadeDAO(connection);
            resp.getWriter().println(dao.busca(new SQLCreator(tabela, filtro)));
            addHeaderJSON(resp);
        } catch (SQLException e) {
            resp.getWriter().println(e.getMessage());
            resp.setStatus(405);
        } finally {
            DBUtils.close(connection);
        }
    }

}
