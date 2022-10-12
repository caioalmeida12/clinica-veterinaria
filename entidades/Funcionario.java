package entidades;
import java.util.Date;

public class Funcionario {
  private Integer idFuncionario;
  private Integer cpfFuncionario;
  private String nomeFuncionario;
  private Date nascimentoFuncionario;
  private String emailFuncionario;
  private Integer salarioFuncionario;
  private String enderecoFuncionario;
  private Integer telefoneFuncionario;
  
  public Funcionario(Integer idFuncionario, Integer cpfFuncionario, String nomeFuncionario, Date nascimentoFuncionario,
      String emailFuncionario, Integer salarioFuncionario, String enderecoFuncionario, Integer telefoneFuncionario) {
    this.idFuncionario = idFuncionario;
    this.cpfFuncionario = cpfFuncionario;
    this.nomeFuncionario = nomeFuncionario;
    this.nascimentoFuncionario = nascimentoFuncionario;
    this.emailFuncionario = emailFuncionario;
    this.salarioFuncionario = salarioFuncionario;
    this.enderecoFuncionario = enderecoFuncionario;
    this.telefoneFuncionario = telefoneFuncionario;
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

  public Date getnascimentoFuncionario() {
    return nascimentoFuncionario;
  }

  public void setnascimentoFuncionario(Date nascimentoFuncionario) {
    this.nascimentoFuncionario = nascimentoFuncionario;
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

  public Integer getTelefoneFuncionario() {
    return telefoneFuncionario;
  }

  public void setTelefoneFuncionario(Integer telefoneFuncionario) {
    this.telefoneFuncionario = telefoneFuncionario;
  }

  
}