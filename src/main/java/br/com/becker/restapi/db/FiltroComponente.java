package br.com.becker.restapi.db;

/**
 * Classe responsável por componentes de filtro
 * 
 * @author Jonata Becker
 */
public interface FiltroComponente {

    /**
     * Retorna o SQL do componente
     * 
     * @return String
     */
    public String getSql();

}
