package clinica_veterinaria;

import conexaoDB.ConexaoDB;

public class Clinica_veterinaria {

    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var cliente = mysql.selectCliente().get(0);
            mysql = new ConexaoDB();
            cliente.setNomeCliente("testeUpdate");
            mysql.updateCliente(cliente);
        } catch (Exception e) {
        }
    }

}
