package entidades;

import conexaoDB.ConexaoDB;
import java.util.Date;

public class Venda {

    ConexaoDB mysql = null;

    Integer idVenda;
    int idProduto, idCliente, idFuncionario;
    Produto produtoVenda;
    Cliente clienteVenda;
    Funcionario funcionarioVenda;
    Date dataVenda;
    Integer quantidadeProduto;
    Double valorVenda;

    public Venda(int idVenda, int idProduto, int idCliente, int idFuncionario, Date dataVenda,
            Integer quantidadeVenda) {

        this.idVenda = (Integer) idVenda;

        try {
            mysql = new ConexaoDB();
            this.produtoVenda = mysql.selectProduto("WHERE idProduto = " + idProduto).get(0);
            mysql = new ConexaoDB();
            this.clienteVenda = mysql.selectCliente("WHERE idCliente = " + idCliente).get(0);
            mysql = new ConexaoDB();
            this.funcionarioVenda = mysql.selectFuncionario("WHERE idFuncionario = " + idFuncionario).get(0);
            this.dataVenda = dataVenda;
            this.quantidadeProduto = quantidadeVenda;
            this.valorVenda = this.produtoVenda.getPrecoProduto();
        } catch (Exception e) {
            System.out.println("erro aqui");

            System.out.println(e);
        }
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public Produto getProdutoVenda() {
        return produtoVenda;
    }

    public Cliente getClienteVenda() {
        return clienteVenda;
    }

    public Funcionario getFuncionarioVenda() {
        return funcionarioVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

}
