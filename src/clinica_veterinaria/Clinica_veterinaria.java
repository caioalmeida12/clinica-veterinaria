package clinica_veterinaria;

import conexaoDB.AnimalDB;
import conexaoDB.ClienteDB;
import conexaoDB.ConexaoDB;
import conexaoDB.FuncionarioDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new FuncionarioDB();
            var resultado = mysql.selectFuncionario().get(0);
            System.out.println(resultado.getNomeFuncionario());
        } catch (Exception e) {
        }
    }

}
