package View;

import conexaoDB.ConexaoDB;
import entidades.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    public FuncionarioView() {

        setContentPane(funcionarioView);
        setTitle("Funcionario");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
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
    }

    public static void main(String[] args) {

        new FuncionarioView().setVisible(true);
    }

}
