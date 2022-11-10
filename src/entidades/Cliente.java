package entidades;

import java.util.Date;

public class Cliente {

  private Integer idCliente;
  private String cpfCliente;
  private String nomeCliente;
  private Date nascimentoCliente;
  private String emailCliente;
  private String telefoneCliente;
  private String enderecoCliente;

  public Cliente(Integer idCliente, String nomeCliente, String cpfCliente, Date nascimentoCliente, String emailCliente,
      String telefoneCliente, String enderecoCliente) {
    this.idCliente = idCliente;
    this.nomeCliente = nomeCliente;
    this.cpfCliente = cpfCliente;
    this.nascimentoCliente = nascimentoCliente;
    this.emailCliente = emailCliente;
    this.telefoneCliente = telefoneCliente;
    this.enderecoCliente = enderecoCliente;
  }

  public Cliente(String cpfCliente, String nomeCliente, Date nascimentoCliente, String emailCliente, String telefoneCliente, String enderecoCliente) {
    this.cpfCliente = cpfCliente;
    this.nomeCliente = nomeCliente;
    this.nascimentoCliente = nascimentoCliente;
    this.emailCliente = emailCliente;
    this.telefoneCliente = telefoneCliente;
    this.enderecoCliente = enderecoCliente;
  }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
  
  

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public String getCpfCliente() {
    return cpfCliente;
  }

  public void setCpfCliente(String cpfCliente) {
    this.cpfCliente = cpfCliente;
  }

  public String getNomeCliente() {
    return nomeCliente;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }

  public Date getNascimentoCliente() {
    return nascimentoCliente;
  }

  public void setNascimentoCliente(Date nascimentoCliente) {
    this.nascimentoCliente = nascimentoCliente;
  }

  public String getEmailCliente() {
    return emailCliente;
  }

  public void setEmailCliente(String emailCliente) {
    this.emailCliente = emailCliente;
  }

  public String getTelefoneCliente() {
    return telefoneCliente;
  }

  public void setTelefoneCliente(String telefoneCliente) {
    this.telefoneCliente = telefoneCliente;
  }

  public String getEnderecoCliente() {
    return enderecoCliente;
  }

  public void setEnderecoCliente(String enderecoCliente) {
    this.enderecoCliente = enderecoCliente;
  }
}
