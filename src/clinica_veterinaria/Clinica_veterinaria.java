package clinica_veterinaria;

import View.AgendamentoView;
import View.AnimalView;
import View.ClienteView;
import View.FuncionarioView;
import View.PrincipalView;
import View.ProdutoView;
import View.ServicoView;
import conexaoDB.*;
import entidades.*;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        new PrincipalView().setVisible(true);
        try {
            var mysql = new AnimalDB();
            var resultado = mysql.selectAnimal().get(0);
            resultado.setCorAnimal("marrom");
            mysql.updateAnimal(resultado);
        } catch (Exception e) {
        }
    }

}
