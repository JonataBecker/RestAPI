package br.com.becker.restapi.db;

/**
 * Classe responsável por operadores de condições
 * 
 * @author Jonata Becker
 */
public enum Operador implements FiltroComponente {

    AND("AND"),
    OR("OR");

    /** SQL do operador */
    private final String op;

    private Operador(String op) {
        this.op = op;
    }

    /**
     * Retorna o SQL do operador
     * 
     * @return String
     */
    @Override
    public String getSql() {
        return op;
    }
}
