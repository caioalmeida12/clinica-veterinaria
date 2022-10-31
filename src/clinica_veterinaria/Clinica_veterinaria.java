package clinica_veterinaria;

import conexaoDB.ConexaoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var resultado = mysql.selectProduto().get(0);
            resultado.setNomeProduto("testeUpdateProduto");
            mysql.conectar();
            mysql.updateProduto(resultado);
        } catch (Exception e) {
        }
    }

}
