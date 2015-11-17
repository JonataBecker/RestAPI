package br.com.becker.restapi.db;

/**
 * Classe responsável pela representação de tabelas
 *
 * @author Jonata Becker
 */
public class Tabela implements Entidade {

    /** Nome da tabela */
    private final String nome;

    public Tabela(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome da tabela
     *
     * @return
     */
    @Override
    public String getNome() {
        return nome;
    }

}
