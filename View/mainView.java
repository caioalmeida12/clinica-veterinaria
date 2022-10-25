package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainView extends JFrame {
    private JPanel principalView;
    private JButton animalButton;
    private JButton clienteButton;
    private JButton funcionarioButton;
    private JButton produtoButton;
    private JButton servicoButton;

    public mainView() {

        setContentPane(principalView);
        setTitle("Principal");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        animalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Animal().setVisible(true);

            }
        });

        //Fecha a janela e abri a janela correspondente
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ClienteView().setVisible(true);

            }
        });
        funcionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FuncionarioView().setVisible(true);

            }
        });
        produtoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ProdutoView().setVisible(true);

            }
        });
        servicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ProdutoView().setVisible(true);

            }
        });
    }
//Deixa o form executavel
    public static void main(String[] args) {

        new mainView().setVisible(true);

    }
}
