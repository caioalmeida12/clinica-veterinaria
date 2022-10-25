package View;

import conexaoDB.ConexaoDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class Animal extends JFrame {
    private JButton cadastrarAnimalButton;
    private JTextField txtNome;
    private JTextField txtRaca;
    private JTextField txtEspecie;
    private JTextField txtCor;
    private JComboBox txtSexo;
    private JTextField txtNascimento;
    private JPanel animalView;
    private JButton voltarButton;

    public Animal() {

        //Configuração da tela mostrada

        setContentPane(animalView);
        setTitle("Animal");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Ação realizada pelo botão de cadastrar
        cadastrarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = txtNome.getText();
                String raca = txtRaca.getText();
                String especie = txtEspecie.getText();
                String sexo = (String) txtSexo.getSelectedItem();

                String cor = txtCor.getText();
                Date data = Date.valueOf(txtNascimento.getText());

                entidades.Animal an = new entidades.Animal(nome,raca,data,especie,sexo,cor);
                an.setNomeAnimal(nome);
                an.setRacaAnimal(raca);
                an.setNascimentoAnimal(data);
                an.setEspecieAnimal(especie);
                an.setSexoAnimal(sexo);
                an.setCorAnimal(cor);

                ConexaoDB mysql = null;
                mysql = new ConexaoDB();

                try {
                    mysql.insertAnimal(an);
                } catch (Exception ex) {
                    System.out.println("erro no view para inserir animal");
                    throw new RuntimeException(ex);
                }


            }
        });
        // Volta para a principal
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               dispose();

               new mainView().setVisible(true);


            }
        });
    }


}
