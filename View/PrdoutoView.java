package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrdoutoView extends JFrame {
    private JButton texto;
    private JPanel main;
    private JTextField txtId;
    private JLabel label;


    public PrdoutoView() {


        //Configuração da tela mostrada
setContentPane(main);
        setTitle("Produto");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        texto.addActionListener(new ActionListener() {
            @Override

            // Evento do botão
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(txtId.getText());
                System.out.println("texto do botão");
                System.out.println(id);
            }
        });
    }

    public static void main(String[] args) {


        PrdoutoView pdView = new PrdoutoView();
    }
}
