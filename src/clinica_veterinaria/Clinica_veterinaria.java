package clinica_veterinaria;

import conexaoDB.AnimalDB;
import conexaoDB.ConexaoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new AnimalDB();
            var resultado = mysql.selectAnimal().get(0);
            System.out.println(resultado.getNomeAnimal());
        } catch (Exception e) {
        }
    }

}
