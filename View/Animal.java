package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animal {
    private JButton cadastrarAnimalButton;
    private JTextField txtNome;
    private JTextField txtRaca;
    private JTextField txtEspecie;
    private JTextField txtCor;
    private JComboBox txtSexo;
    private JTextField txtNascimento;

    public Animal() {
        cadastrarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
    }
}
