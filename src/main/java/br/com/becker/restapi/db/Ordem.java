package br.com.becker.restapi.db;

/**
 * Classe responsável pela ordenação de colunas
 * 
 * @author Jonata Becker
 */
public class Ordem implements FiltroComponente {

    /** Coluna */
    private final String campo;
    /** Tipo de ordem */
    private final String ordem;

    public Ordem(String campo, String ordem) {
        this.campo = campo;
        this.ordem = ordem;
    }

    /**
     * Retorna o SQL de ordenação
     * 
     * @return 
     */
    @Override
    public String getSql() {
        return campo + " " + ordem;
    }
}
