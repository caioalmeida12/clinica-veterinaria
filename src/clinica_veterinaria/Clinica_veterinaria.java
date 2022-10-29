package clinica_veterinaria;

import conexaoDB.ConexaoDB;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var resultado = mysql.selectFuncionario().get(0);
            mysql = new ConexaoDB();
            resultado.setNomeFuncionario("testeUpdate");
            mysql.updateFuncionario(resultado);
        } catch (Exception e) {
        }
    }

}
