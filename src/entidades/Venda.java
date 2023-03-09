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

    
    private Produto produtoVenda;
    private Cliente clienteVenda;
    private Funcionario funcionarioVenda;
    private Integer idVenda;
    private int idProduto, idCliente, idFuncionario;
    private Date dataVenda;
    private Integer quantidadeProduto;
    private String nomeFuncionario;
    private String nomeCliente;
    private String nomeProduto;
    private Double valorVenda;

    public Venda(int idVenda, int idProduto, int idCliente, int idFuncionario, Date dataVenda,
            Integer quantidadeVenda, Double valorVenda) {

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

    public Venda(Integer idVenda, int idProduto, int idCliente, int idFuncionario, Date dataVenda, Integer quantidadeProduto) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.dataVenda = dataVenda;
        this.quantidadeProduto = quantidadeProduto;
       
    }

    public Venda(Integer idVenda, Date dataVenda, Integer quantidadeProduto, String nomeFuncionario, String nomeCliente, String nomeProduto) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.quantidadeProduto = quantidadeProduto;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        
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

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

   

}
