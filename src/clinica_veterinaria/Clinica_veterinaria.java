package clinica_veterinaria;

import conexaoDB.ConexaoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var resultado = mysql.selectAgendamento().get(0);
            resultado.setSituacaoAgendamento("realizado");
            mysql.conectar();
            mysql.updateAgendamento(resultado);
        } catch (Exception e) {
        }
    }

}
