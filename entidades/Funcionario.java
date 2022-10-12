package entidades;

public class Funcionario {
  private Integer idFuncionario;
  private Integer cpfFuncionario;
  private String nomeFuncionario;
  private Integer telefoneFuncionario;
  private String emailFuncionario;
  private Integer salarioFuncionario;
  private String enderecoFuncionario;

  public Funcionario(Integer idFuncionario, Integer cpfFuncionario, String nomeFuncionario, Integer telefoneFuncionario,
      String emailFuncionario, Integer salarioFuncionario, String enderecoFuncionario) {
    this.idFuncionario = idFuncionario;
    this.cpfFuncionario = cpfFuncionario;
    this.nomeFuncionario = nomeFuncionario;
    this.telefoneFuncionario = telefoneFuncionario;
    this.emailFuncionario = emailFuncionario;
    this.salarioFuncionario = salarioFuncionario;
    this.enderecoFuncionario = enderecoFuncionario;
  }

  public Integer getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(Integer idFuncionario) {
    this.idFuncionario = idFuncionario;
  }

  public Integer getCpfFuncionario() {
    return cpfFuncionario;
  }

  public void setCpfFuncionario(Integer cpfFuncionario) {
    this.cpfFuncionario = cpfFuncionario;
  }

  public String getNomeFuncionario() {
    return nomeFuncionario;
  }

  public void setNomeFuncionario(String nomeFuncionario) {
    this.nomeFuncionario = nomeFuncionario;
  }

  public Integer getTelefoneFuncionario() {
    return telefoneFuncionario;
  }

  public void setTelefoneFuncionario(Integer telefoneFuncionario) {
    this.telefoneFuncionario = telefoneFuncionario;
  }

  public String getEmailFuncionario() {
    return emailFuncionario;
  }

  public void setEmailFuncionario(String emailFuncionario) {
    this.emailFuncionario = emailFuncionario;
  }

  public Integer getSalarioFuncionario() {
    return salarioFuncionario;
  }

  public void setSalarioFuncionario(Integer salarioFuncionario) {
    this.salarioFuncionario = salarioFuncionario;
  }

  public String getEnderecoFuncionario() {
    return enderecoFuncionario;
  }

  public void setEnderecoFuncionario(String enderecoFuncionario) {
    this.enderecoFuncionario = enderecoFuncionario;
  }
  
}