package br.com.becker.restapi.db;

/**
 *
 * @author Jonata Becker
 */
public class CondicaoIgual implements Condicao {

    @Override
    public Object formatValue(Object value) {
        return value;
    }

    @Override
    public String getOperador() {
        return "=";
    }
}
