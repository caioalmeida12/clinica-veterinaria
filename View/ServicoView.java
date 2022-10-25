package View;

import conexaoDB.ConexaoDB;
import entidades.Servico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicoView extends JFrame {
    private JButton cadastrarServicoButton;
    private JTextField txtTipo;
    private JTextField txtDescricao;
    private JTextField txtPreco;
    private JPanel servicoView;
    private JButton voltarButton;

    public ServicoView() {

        //Configuração da tela mostrada

        setContentPane(servicoView);
        setTitle("Servico");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Ação realizada pelo botão de cadastrar
        cadastrarServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = txtDescricao.getText();
                String tipo = txtTipo.getText();
                double preco = Double.parseDouble(txtPreco.getText());

                Servico sv = new Servico(tipo,descricao,preco);

                sv.setDescricaoServico(descricao);
                sv.setTipoServico(tipo);
                sv.setPrecoServico(preco);

                ConexaoDB mysql = null;
                mysql = new ConexaoDB();


                try {
                    mysql.insertServico(sv);
                } catch (Exception ex) {
                    System.out.println("erro no view para inserir servico");
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
