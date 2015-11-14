package br.com.becker.restapi.db;

/**
 * Classe responsável por controlar as condição para filtro de busca de informações
 * 
 * @author Jonata Becker
 */
public interface Condicao {

    /**
     * Retorna o operador
     * 
     * @return String
     */
    public String getOperador();

    /**
     * Retorna o valor de acordo com o operador
     * 
     * @param object
     * @return Objecy
     */
    public Object formatValue(Object object);
    
}
