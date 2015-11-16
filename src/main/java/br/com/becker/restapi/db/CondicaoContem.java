package br.com.becker.restapi.db;

/**
 * Classe responsável por condições para filtro
 *
 * @author Jonata Becker
 */
public class CondicaoContem implements Condicao {

    /**
     * Retorna o valor de acordo com o operador
     *
     * @param value
     * @return Object
     */
    @Override
    public Object formatValue(Object value) {
        return "%" + value + "%";
    }

    /**
     * Retorna o operador
     *
     * @return String
     */
    @Override
    public String getOperador() {
        return "LIKE";
    }
}
