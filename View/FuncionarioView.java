package View;

import conexaoDB.ConexaoDB;
import entidades.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class FuncionarioView extends JFrame {
    private JButton cadastrarFuncionarioButton;
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtEmail;
    private JTextField txtSalario;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JFormattedTextField txtNascimento;
    private JPanel funcionarioView;
    private JButton voltarButton;

    public FuncionarioView() {
//Configuração da tela mostrada
        setContentPane(funcionarioView);
        setTitle("Funcionario");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Ação realizada pelo botão de cadastrar
        cadastrarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = txtNome.getText();
                Integer cpf = Integer.valueOf(txtCPF.getText());
                String email = txtEmail.getText();
                float salario = Float.parseFloat(txtSalario.getText());
                Date data = Date.valueOf(txtNascimento.getText());
                String telefone = txtTelefone.getText();
                String endereco = txtEndereco.getText();

                Funcionario fn = new Funcionario(nome,cpf,data,email,salario,telefone,endereco);
                fn.setNomeFuncionario(nome);
                fn.setCpfFuncionario(cpf);
                fn.setNascimentoFuncionario(data);
                fn.setEmailFuncionario(email);
                fn.setSalarioFuncionario(salario);
                fn.setTelefoneFuncionario(telefone);
                fn.setEnderecoFuncionario(endereco);

                ConexaoDB mysql = null;
                mysql = new ConexaoDB();

                try {
                    mysql.insertFuncionario(fn);
                } catch (Exception ex) {
                    System.out.println("erro no view para inserir funcionario");
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
