/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinica_veterinaria;

import View.FuncionarioView;
import View.ProdutoView;
import conexaoDB.ConexaoDB;

/**
 *
 * @author luanf
 */
public class Clinica_veterinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // new ProdutoView().setVisible(true);
        try {
            var mysql = new ConexaoDB();
            var animal = mysql.selectAnimal().get(0);
            mysql = new ConexaoDB();
            animal.setCorAnimal("testeUpdate2");
            mysql.updateAnimal(animal);
        } catch (Exception e) {
        }
    }

}
