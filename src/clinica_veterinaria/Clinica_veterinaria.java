package clinica_veterinaria;

import conexaoDB.*;
import entidades.*;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new AgendamentoDB();
            var resultado = mysql.selectAgendamento().get(0);
            System.out.println(resultado.getIdAnimal());
        } catch (Exception e) {
        }
    }

}
