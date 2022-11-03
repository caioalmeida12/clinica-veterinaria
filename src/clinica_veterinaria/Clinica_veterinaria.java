package clinica_veterinaria;

import conexaoDB.AnimalDB;
import conexaoDB.ClienteDB;
import conexaoDB.ConexaoDB;
import conexaoDB.FuncionarioDB;
import conexaoDB.ProdutoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ProdutoDB();
            var resultado = mysql.selectProduto().get(0);
            System.out.println(resultado.getNomeProduto());
        } catch (Exception e) {
        }
    }

}
