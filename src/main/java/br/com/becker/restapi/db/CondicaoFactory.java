package br.com.becker.restapi.db;

import br.com.becker.restapi.utils.ReflectionUtils;

/**
 * Classe reponsável pela criação de condições
 * 
 * @author Jonata Becker
 */
public class CondicaoFactory {

    /**
     * Cria condição
     * 
     * @param condicao Nome da condição
     * @return Condicao
     */
    public static Condicao create(String condicao) {
        try {
            Class c = Class.forName("br.com.becker.restapi.db.Condicao" + ReflectionUtils.captalize(condicao));
            return (Condicao) c.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

}
