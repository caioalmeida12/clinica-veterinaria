package clinica_veterinaria;

import conexaoDB.AnimalClienteDB;
import conexaoDB.AnimalDB;
import conexaoDB.ClienteDB;
import conexaoDB.ConexaoDB;
import conexaoDB.FuncionarioDB;
import conexaoDB.ProdutoDB;
import conexaoDB.ServicoDB;
import conexaoDB.VendaDB;
import entidades.AnimalCliente;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new AnimalClienteDB();
            var resultado = mysql.selectAnimalCliente().get(0);
            System.out.println(resultado.getIdAnimal());
        } catch (Exception e) {
        }
    }

}
