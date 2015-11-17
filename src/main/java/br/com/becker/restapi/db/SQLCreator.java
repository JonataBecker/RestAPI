package br.com.becker.restapi.db;

/**
 *
 * @author Jonata Becker
 */
public class SQLCreator {

    private final Entidade entidade;
    private final Filtro filtro;

    public SQLCreator(Entidade entidade) {
        this(entidade, new Filtro());
    }

    public SQLCreator(Entidade entidade, Filtro filtro) {
        this.entidade = entidade;
        this.filtro = filtro;
    }

    public String create() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ").append(entidade.getNome());
        if (filtro.isPossuiFiltro()) {
            sql.append(" WHERE ").append(filtro.getSql());
        }
        if (filtro.isPossuiOrderBy()) {
            sql.append(" ORDER BY ").append(filtro.getSqlOrder());
        }
        return sql.toString();
    }

}
