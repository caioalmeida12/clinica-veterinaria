package View;

import conexaoDB.ConexaoDB;
import entidades.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoView extends JFrame {
    private JButton texto;
    private JPanel produtoView;
    private JButton cadastrarProdutoButton;
    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtId;


    public ProdutoView() {


        //Configuração da tela mostrada
setContentPane(produtoView);
        setTitle("Produto");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        //Ação realizada pelo botão de cadastrar
        cadastrarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String nome = txtNome.getText();
                Double preco = Double.valueOf(txtPreco.getText());
                Produto pd = new Produto(nome,preco);
                pd.setNomeProduto(nome);
                pd.setPrecoProduto(preco);
                ConexaoDB mysql = null;
                mysql = new ConexaoDB();

                try {
                    mysql.insertProduto(pd);
                } catch (Exception ex) {
                    System.out.println("erro no view para inserir produto");
                    throw new RuntimeException(ex);
                }


            }
            }
        );
    }

    //Deixar a tela executavel
    public static void main(String[] args) {

       new ProdutoView().setVisible(true);
    }


}
