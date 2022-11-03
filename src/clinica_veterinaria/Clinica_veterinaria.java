package clinica_veterinaria;

import conexaoDB.AnimalDB;
import conexaoDB.ClienteDB;
import conexaoDB.ConexaoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ClienteDB();
            var resultado = mysql.selectCliente().get(0);
            System.out.println(resultado.getNomeCliente());
        } catch (Exception e) {
        }
    }

}
