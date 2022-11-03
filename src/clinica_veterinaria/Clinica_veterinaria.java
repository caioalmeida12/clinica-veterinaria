package clinica_veterinaria;

import conexaoDB.ConexaoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var resultado = mysql.selectAgendamento().get(0);
            resultado.setIdAgendamento(7);
            resultado.setSituacaoAgendamento("adiado");
            mysql.conectar();
            mysql.insertAgendamento(resultado);
        } catch (Exception e) {
        }
    }

}
