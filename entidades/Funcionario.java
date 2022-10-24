package entidades;

import java.util.Date;

public class Funcionario {
  private Integer idFuncionario;
  private String nomeFuncionario;
  private Integer cpfFuncionario;
  private Date nascimentoFuncionario;
  private String emailFuncionario;
  private Float salarioFuncionario;
  private String telefoneFuncionario;
  private String enderecoFuncionario;

  public Funcionario(Integer idFuncionario, String nomeFuncionario, Integer cpfFuncionario, Date nascimentoFuncionario,
      String emailFuncionario, Float salarioFuncionario, String telefoneFuncionario, String enderecoFuncionario) {
    this.idFuncionario = idFuncionario;
    this.nomeFuncionario = nomeFuncionario;
    this.cpfFuncionario = cpfFuncionario;
    this.nascimentoFuncionario = nascimentoFuncionario;
    this.emailFuncionario = emailFuncionario;
    this.salarioFuncionario = salarioFuncionario;
    this.telefoneFuncionario = telefoneFuncionario;
    this.enderecoFuncionario = enderecoFuncionario;
  }

  public Funcionario(String nomeFuncionario, Integer cpfFuncionario, Date nascimentoFuncionario, String emailFuncionario, Float salarioFuncionario, String telefoneFuncionario, String enderecoFuncionario) {
    this.nomeFuncionario = nomeFuncionario;
    this.cpfFuncionario = cpfFuncionario;
    this.nascimentoFuncionario = nascimentoFuncionario;
    this.emailFuncionario = emailFuncionario;
    this.salarioFuncionario = salarioFuncionario;
    this.telefoneFuncionario = telefoneFuncionario;
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

  public Date getNascimentoFuncionario() {
    return nascimentoFuncionario;
  }

  public void setNascimentoFuncionario(Date nascimentoFuncionario) {
    this.nascimentoFuncionario = nascimentoFuncionario;
  }

  public String getEmailFuncionario() {
    return emailFuncionario;
  }

  public void setEmailFuncionario(String emailFuncionario) {
    this.emailFuncionario = emailFuncionario;
  }

  public Float getSalarioFuncionario() {
    return salarioFuncionario;
  }

  public void setSalarioFuncionario(Float salarioFuncionario) {
    this.salarioFuncionario = salarioFuncionario;
  }

  public String getEnderecoFuncionario() {
    return enderecoFuncionario;
  }

  public void setEnderecoFuncionario(String enderecoFuncionario) {
    this.enderecoFuncionario = enderecoFuncionario;
  }

  public String getTelefoneFuncionario() {
    return telefoneFuncionario;
  }

  public void setTelefoneFuncionario(String telefoneFuncionario) {
    this.telefoneFuncionario = telefoneFuncionario;
  }

}