package clinica_veterinaria;

import conexaoDB.*;
import entidades.*;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new AnimalDB();
            var resultado = mysql.selectAnimal().get(0);
            resultado.setCorAnimal("marrom");
            mysql.updateAnimal(resultado);
        } catch (Exception e) {
        }
    }

}
