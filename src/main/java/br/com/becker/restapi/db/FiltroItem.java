package br.com.becker.restapi.db;

/**
 * Classe responsável por itens de condições de filtros
 *
 * @author Jonata Becker
 */
public class FiltroItem implements FiltroComponente {

    /** Nome do campo */
    private final String campo;
    /** Condição */
    private final Condicao condicao;
    /** Valor do filtro */
    private final Object valor;

    public FiltroItem(String campo, Condicao condicao, Object valor) {
        this.campo = campo;
        this.condicao = condicao;
        this.valor = valor;
    }

    /**
     * Retorna nome do campo
     *
     * @return String
     */
    public String getCampo() {
        return campo;
    }

    /**
     * Retorna a condição
     *
     * @return Condição
     */
    public Condicao getCondicao() {
        return condicao;
    }

    /**
     * Retorna o valor do filtro
     *
     * @return Object
     */
    public Object getValor() {
        return valor;
    }

    /**
     * Retorna SQL do filtro
     *
     * @return String
     */
    @Override
    public String getSql() {
        StringBuilder sb = new StringBuilder();
        sb.append(campo);
        sb.append(" ").append(condicao.getOperador()).append(" ");
        sb.append("'").append(condicao.formatValue(valor)).append("'");
        return sb.toString();
    }

}
