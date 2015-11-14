package br.com.becker.restapi;

/**
 * Problema a busca implementação de classe
 * 
 * @author Jonata Becker
 */
public class FindImplementarionException extends Exception {
    
    /** Classe buscada */
    private final Class classe;

    public FindImplementarionException(Class classe, String message) {
        super(message);
        this.classe = classe;
    }

    public FindImplementarionException(Class classe, String message, Throwable e) {
        super(message, e);
        this.classe = classe;
    }

    /**
     * Retorna classe buscada
     * 
     * @return Class
     */
    public Class getClasse() {
        return classe;
    }
    
}
