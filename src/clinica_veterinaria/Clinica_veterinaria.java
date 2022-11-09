package clinica_veterinaria;

import View.FuncionarioView;
import View.ProdutoView;
import conexaoDB.*;
import entidades.*;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        new FuncionarioView().setVisible(true);
        try {
            var mysql = new AnimalDB();
            var resultado = mysql.selectAnimal().get(0);
            resultado.setCorAnimal("marrom");
            mysql.updateAnimal(resultado);
        } catch (Exception e) {
        }
    }

}
