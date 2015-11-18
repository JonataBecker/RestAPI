package br.com.becker.restapi;

import javax.servlet.http.HttpServletRequest;

/**
 * Classe responsável por parâmetros de requisição
 * 
 * @author Jonata Becker
 */
public class ParameterURL {
    
    /** Objeto responsável pela requisição HTTP */
    private final HttpServletRequest request;
    /** Parametros */
    private final String[] parametros;

    public ParameterURL(HttpServletRequest request) {
        this.request = request;
        this.parametros = montaParametros();
    }
    
    /**
     * Executa montagem de parâmetros da URL
     * 
     * @return String[]
     */
    private String[] montaParametros() {
        String context = request.getContextPath() + request.getServletPath() + "/";
        String parametro = request.getRequestURI().replace(context, "");
        return parametro.split("/");
    }
    
    /**
     * Retorna a entidade
     * 
     * @return String
     */
    public String getEntidade() {
        return parametros[0];
    }
}
