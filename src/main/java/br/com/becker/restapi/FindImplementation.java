package br.com.becker.restapi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;

/**
 * Classe responsável por buscar implementações
 *
 * @author Jonata Becker
 */
public class FindImplementation {

    /** Objeto responsável por armazenar implementações */
    private static final Map<Class, Object> implementations = new HashMap<>();

    /**
     * Retorna objeto instânciado a partir de interface
     * 
     * @param <T>
     * @param cla
     * @return T
     * @throws FindImplementarionException Problema ao instânciar classe
     */
    public synchronized static <T> T get(Class<T> cla) throws FindImplementarionException {
        try {
            T obj = (T) implementations.get(cla);
            if (obj != null) {
                return obj;
            }
            Class classImp = find(cla);
            Object objImp = classImp.newInstance();
            implementations.put(cla, objImp);
            return (T) objImp;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new FindImplementarionException(cla, "Não foi possível instânciar classe!", e);
        }
    }

    /**
     * Busca classe concreta a partir da interface
     * 
     * @param cla
     * @return Class
     * @throws FindImplementarionException Problema ao busca classe
     */
    public synchronized static Class find(Class cla) throws FindImplementarionException {
        Reflections reflections = new Reflections();
        Set<Class> classes = reflections.getSubTypesOf(cla);
        // Se não encontrou implementação
        if (classes.isEmpty()) {
            throw new FindImplementarionException(cla, "Não foi possível encontrar implementação.");
        }
        return classes.iterator().next();
    }

}
