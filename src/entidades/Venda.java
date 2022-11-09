package entidades;

import conexaoDB.ClienteDB;
import conexaoDB.ConexaoDB;
import conexaoDB.FuncionarioDB;
import conexaoDB.ProdutoDB;

import java.util.Date;

public class Venda {

    private ClienteDB clienteDB = new ClienteDB();
    private FuncionarioDB funcionarioDB = new FuncionarioDB();
    private ProdutoDB produtoDB = new ProdutoDB();
    private ConexaoDB mysql = new ConexaoDB();

    private Integer idVenda;
    private int idProduto, idCliente, idFuncionario;
    private Produto produtoVenda;
    private Cliente clienteVenda;
    private Funcionario funcionarioVenda;
    private Date dataVenda;
    private Integer quantidadeProduto;
    private Double valorVenda;

    public Venda(int idVenda, int idProduto, int idCliente, int idFuncionario, Date dataVenda,
            Integer quantidadeVenda) {

        this.idVenda = (Integer) idVenda;

        try {
            // popula o atributo clienteVenda
            this.clienteVenda = clienteDB.selectCliente("WHERE idCliente = " + idCliente).get(0);

            // popula o atributo produtoVenda
            this.produtoVenda = produtoDB.selectProduto("WHERE idProduto = " + idProduto).get(0);

            // popula o atributo funcionarioVenda
            this.funcionarioVenda = funcionarioDB.selectFuncionario("WHERE idFuncionario = " + idFuncionario).get(0);

            this.dataVenda = dataVenda;
            this.quantidadeProduto = quantidadeVenda;
            this.valorVenda = this.produtoVenda.getPrecoProduto() * this.quantidadeProduto;
        } catch (Exception e) {
            System.out.println("Erro no construtor da classe Venda -> " + e);
        }
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return (this.idProduto != 0) ? this.idProduto : this.getProdutoVenda().getIdProduto();
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
        this.getProdutoVenda().setIdProduto(idProduto);
    }

    public int getIdCliente() {
        return (this.idCliente != 0) ? this.idCliente : this.getClienteVenda().getIdCliente();
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        this.getClienteVenda().setIdCliente(idCliente);
    }

    public int getIdFuncionario() {
        return (this.idFuncionario != 0) ? this.idFuncionario : this.getFuncionarioVenda().getIdFuncionario();
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
        this.getFuncionarioVenda().setIdFuncionario(idFuncionario);
    }

    public Produto getProdutoVenda() {
        return produtoVenda;
    }

    public void setProdutoVenda(Produto produtoVenda) {
        this.produtoVenda = produtoVenda;
    }

    public Cliente getClienteVenda() {
        return clienteVenda;
    }

    public void setClienteVenda(Cliente clienteVenda) {
        this.clienteVenda = clienteVenda;
    }

    public Funcionario getFuncionarioVenda() {
        return funcionarioVenda;
    }

    public void setFuncionarioVenda(Funcionario funcionarioVenda) {
        this.funcionarioVenda = funcionarioVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

}
