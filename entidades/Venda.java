package entidades;

import conexaoDB.ConexaoDB;
import java.util.Date;

public class Venda {

    ConexaoDB mysql = new ConexaoDB();

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
            this.produtoVenda = mysql.getProduto("WHERE idProduto = " + idProduto).get(0);
            // this.clienteVenda = mysql.getCliente("WHERE idCliente = " +
            // idCliente).get(0);
            // this.funcionarioVenda = mysql.getFuncionario("WHERE idFuncionario = " +
            // idFuncionario).get(0);
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
