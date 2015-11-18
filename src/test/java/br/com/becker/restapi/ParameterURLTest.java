package br.com.becker.restapi;

import br.com.becker.restapi.mock.MockHttpServletRequest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testes da classe responsável por parâmetros de requisições
 * 
 * @author Jonata Becker
 */
public class ParameterURLTest {
    
    /**
     * Retorna objeto de informações da requisição
     * 
     * @return MockHttpServletRequest
     */
    private MockHttpServletRequest getRequest() {
        MockHttpServletRequest mock = new MockHttpServletRequest();
        mock.add("contextPath", "/WebServiceRestAPI");
        mock.add("servletPath", "/api");
        return mock;
    }
    
    /**
     * Retorna o nome da entidade
     */
    @Test
    public void getEntidade() {
        MockHttpServletRequest http = getRequest();
        http.add("requestURI", "/WebServiceRestAPI/api/cliente");
        Assert.assertEquals("cliente", new ParameterURL(http).getEntidade());
    }
    
}
