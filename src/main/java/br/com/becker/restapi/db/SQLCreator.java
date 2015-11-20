package br.com.becker.restapi.db;

/**
 * Classe responsável pela criação de comandos SQL
 * 
 * @author Jonata Becker
 */
public class SQLCreator {
    
    /** Dados da entidade */
    private final Entidade entidade;
    /** Dados de filtros */
    private final Filtro filtro;

    public SQLCreator(Entidade entidade) {
        this(entidade, new Filtro());
    }

    public SQLCreator(Entidade entidade, Filtro filtro) {
        this.entidade = entidade;
        this.filtro = filtro;
    }

    /**
     * Executa crição de comandos SELECT
     * 
     * @return String
     */
    public String createSelect() {
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
