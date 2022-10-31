package clinica_veterinaria;

import conexaoDB.ConexaoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var produto = new Produto("testeInsert", 69d);
            mysql.insertProduto(produto);
        } catch (Exception e) {
        }
    }

}
