package br.com.becker.restapi.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo filtro de acesso a dados
 *
 * @author Jonata Becker
 */
public class Filtro {

    /** Lista de filtro */
    private final List<FiltroComponente> filtros;
    /** Lista de ordenação */
    private final List<FiltroComponente> orderBy;

    public Filtro() {
        this.filtros = new ArrayList<>();
        this.orderBy = new ArrayList<>();
    }

    /**
     * Retorna o último indice de filtro
     *
     * @return int
     */
    private int getIndexLast() {
        return filtros.size() - 1;
    }

    /**
     * Retorna o último componente de filtro
     *
     * @return FiltroCompenente
     */
    private FiltroComponente getLast() {
        int lastElement = getIndexLast();
        if (lastElement <= 0) {
            return null;
        }
        return filtros.get(lastElement);
    }

    /**
     * Retorna verdadeiro se o último componente é um operador
     *
     * @return boolean
     */
    private boolean isLastOperator() {
        FiltroComponente last = getLast();
        if (last == null) {
            return false;
        }
        return last instanceof Operador;
    }

    /**
     * Adiciona filtro
     *
     * @param campo Nome do campo
     * @param condicao Condição
     * @param valor Valor
     */
    public void addFiltro(String campo, Condicao condicao, Object valor) {
        if (!filtros.isEmpty() && !isLastOperator()) {
            filtros.add(Operador.AND);
        }
        filtros.add(new FiltroItem(campo, condicao, valor));
    }

    /**
     * Adiciona operador
     *
     * @param operador Operador
     */
    public void addOperador(Operador operador) {
        if (filtros.isEmpty()) {
            return;
        }
        if (isLastOperator()) {
            filtros.set(getIndexLast(), operador);
            return;
        }
        filtros.add(operador);
    }

    /**
     * Retorna SQL de filtro
     *
     * @return String
     */
    public String getSql() {
        StringBuilder sb = new StringBuilder();
        for (FiltroComponente item : filtros) {
            sb.append(item.getSql()).append(" ");
        }
        return sb.toString();
    }

    /**
     * Retorna verdadeiro se possuir filtro
     *
     * @return boolean
     */
    public boolean isPossuiFiltro() {
        return !filtros.isEmpty();
    }

    /**
     * Adiciona ordenação
     *
     * @param campo Nome do campo
     * @param ordem Tipo de ordenação
     */
    public void addOrderBy(String campo, String ordem) {
        orderBy.add(new Ordem(campo, ordem));
    }

    /**
     * Retorna verdadeiro se possuir ordenação
     *
     * @return boolean
     */
    public boolean isPossuiOrderBy() {
        return !orderBy.isEmpty();
    }

    /**
     * Retorna SQL de ordenação
     *
     * @return String
     */
    public String getSqlOrder() {
        StringBuilder sb = new StringBuilder();
        for (FiltroComponente item : orderBy) {
            if (orderBy.indexOf(item) > 0) {
                sb.append(", ");
            }
            sb.append(item.getSql());
        }
        return sb.toString();
    }
}
