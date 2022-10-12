package entidades;
import java.util.Date;

public class Cliente {

  private Integer idCliente;
  private String cpfCliente;
  private String nomeCliente;
  private Date nascimentoCliente;
  private String emailCliente;
  private Integer telefoneCliente;
  private Integer enderecoCliente;
  
  public Cliente(Integer idCliente, String cpfCliente, String nomeCliente, Date nascimentoCliente, String emailCliente,
      Integer telefoneCliente, Integer enderecoCliente) {
    this.idCliente = idCliente;
    this.cpfCliente = cpfCliente;
    this.nomeCliente = nomeCliente;
    this.nascimentoCliente = nascimentoCliente;
    this.emailCliente = emailCliente;
    this.telefoneCliente = telefoneCliente;
    this.enderecoCliente = enderecoCliente;
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

  public Integer getTelefoneCliente() {
    return telefoneCliente;
  }

  public void setTelefoneCliente(Integer telefoneCliente) {
    this.telefoneCliente = telefoneCliente;
  }

  public Integer getEnderecoCliente() {
    return enderecoCliente;
  }

  public void setEnderecoCliente(Integer enderecoCliente) {
    this.enderecoCliente = enderecoCliente;
  }
}
