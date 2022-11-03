package clinica_veterinaria;

import conexaoDB.ConexaoDB;
import entidades.Produto;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var resultado = mysql.selectVenda().get(0);
            resultado.setIdCliente(2);
            // System.out.println(resultado.getIdCliente());
            // System.out.println(resultado.getIdVenda());
            mysql.conectar();
            mysql.updateVenda(resultado);
        } catch (Exception e) {
        }
    }

}
