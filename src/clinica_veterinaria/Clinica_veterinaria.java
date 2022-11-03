package clinica_veterinaria;

import conexaoDB.AnimalDB;
import conexaoDB.ClienteDB;
import conexaoDB.ConexaoDB;
import conexaoDB.FuncionarioDB;
import conexaoDB.ProdutoDB;
import conexaoDB.ServicoDB;
import conexaoDB.VendaDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new VendaDB();
            var resultado = mysql.selectVenda().get(0);
            System.out.println(resultado.getIdProduto());
        } catch (Exception e) {
        }
    }

}
