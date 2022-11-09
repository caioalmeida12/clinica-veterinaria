package entidades;

import java.util.Date;

public class Funcionario {
  public Integer idFuncionario;
  public String nomeFuncionario;
  public String cpfFuncionario;
  public Date nascimentoFuncionario;
  public String emailFuncionario;
  public Float salarioFuncionario;
  public String telefoneFuncionario;
  public String enderecoFuncionario;

  public Funcionario(Integer idFuncionario, String nomeFuncionario, String cpfFuncionario, Date nascimentoFuncionario,
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

  public Funcionario(String nomeFuncionario, String cpfFuncionario, Date nascimentoFuncionario, String emailFuncionario,
      Float salarioFuncionario, String telefoneFuncionario, String enderecoFuncionario) {
    this.nomeFuncionario = nomeFuncionario;
    this.cpfFuncionario = cpfFuncionario;
    this.nascimentoFuncionario = nascimentoFuncionario;
    this.emailFuncionario = emailFuncionario;
    this.salarioFuncionario = salarioFuncionario;
    this.telefoneFuncionario = telefoneFuncionario;
    this.enderecoFuncionario = enderecoFuncionario;
  }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
  
  

  public Integer getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(Integer idFuncionario) {
    this.idFuncionario = idFuncionario;
  }

  public String getCpfFuncionario() {
    return cpfFuncionario;
  }

  public void setCpfFuncionario(String cpfFuncionario) {
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