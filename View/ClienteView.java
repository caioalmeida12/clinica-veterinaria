package View;

import conexaoDB.ConexaoDB;
import entidades.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ClienteView extends JFrame{
    private JButton cadastrarClienteButton;
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtEmail;
    private JTextField txtNascimento;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JPanel clienteView;

    public ClienteView() {

        setContentPane(clienteView);
        setTitle("Cliente");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cpf = txtCPF.getText();
                String email = txtEmail.getText();
                Date data = Date.valueOf(txtNascimento.getText());
                String telefone = txtTelefone.getText();
                String endereco = txtEndereco.getText();

                Cliente cl = new Cliente(cpf,nome,data,email,telefone,endereco);
               cl.setCpfCliente(cpf);
               cl.setNomeCliente(nome);
               cl.setNascimentoCliente(data);
               cl.setEmailCliente(email);
               cl.setTelefoneCliente(telefone);
               cl.setEnderecoCliente(endereco);

                ConexaoDB mysql = null;
                mysql = new ConexaoDB();

                try {
                    mysql.insertCliente(cl);
                } catch (Exception ex) {
                    System.out.println("erro no view para inserir Cliente");
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {

        new ClienteView().setVisible(true);
    }
}
