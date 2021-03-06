package br.com.becker.restapi.db;

/**
 * Classe responsável por controlar as condição para filtro de busca de informações
 * 
 * @author Jonata Becker
 */
public interface Condicao {

    /**
     * Retorna o valor de acordo com o operador
     * 
     * @param value
     * @return Object
     */
    public Object formatValue(Object value);    
    
    /**
     * Retorna o operador
     * 
     * @return String
     */
    public String getOperador();
    
}
