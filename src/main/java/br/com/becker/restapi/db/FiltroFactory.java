package br.com.becker.restapi.db;

import java.util.Map;

/**
 * Classe responsável pela crição de filtros
 * 
 * @author Jonata Becker
 */
public class FiltroFactory {

    private static final String CAMPO = "filtro.campo";
    private static final String CONDICAO = "filtro.condicao";
    private static final String VALOR = "filtro.valor";
    private static final String OPERADOR = "filtro.operador";
    private static final String ORDER_CAMPO = "order.campo";
    private static final String ORDER_TIPO = "order.tipo";

    public static Filtro create(Map<String, String[]> parameter) {
        return new Montador(parameter).montaFiltro();
    }

    private static class Montador {

        private final String[] campos;
        private final String[] condicao;
        private final String[] valor;
        private final String[] operador;
        private final String[] orderCampo;
        private final String[] orderTipo;

        public Montador(Map<String, String[]> parameter) {
            this.campos = parameter.get(CAMPO);
            this.condicao = parameter.get(CONDICAO);
            this.valor = parameter.get(VALOR);
            this.operador = parameter.get(OPERADOR);
            this.orderCampo = parameter.get(ORDER_CAMPO);
            this.orderTipo = parameter.get(ORDER_TIPO);
        }

        private boolean isPossuiFiltro() {
            return campos != null && condicao != null && valor != null;
        }

        private boolean isAtributoDivergente() {
            return campos.length != condicao.length
                    || campos.length != valor.length
                    || condicao.length != valor.length;
        }

        private boolean isPossuiOperador(int i) {
            return operador != null
                    && operador.length == (campos.length - 1)
                    && operador.length > i;
        }

        private boolean isPossuiOrder() {
            return orderCampo != null && orderTipo != null && orderCampo.length == orderTipo.length;
        }

        private Filtro montaFiltro() {
            Filtro filtro = new Filtro();
            if (isPossuiFiltro() && !isAtributoDivergente()) {
                for (int i = 0; i < campos.length; i++) {
                    filtro.addFiltro(campos[i], CondicaoFactory.create(condicao[i]), valor[i]);
                    if (isPossuiOperador(i)) {
                        Operador op = Operador.valueOf(operador[i]);
                        if (op != null) {
                            filtro.addOperador(op);
                        }
                    }
                }
            }
            if (isPossuiOrder()) {
                for (int i = 0; i < orderCampo.length; i++) {
                    filtro.addOrderBy(orderCampo[i], orderTipo[i]);
                }
            }
            return filtro;
        }
    }

}
