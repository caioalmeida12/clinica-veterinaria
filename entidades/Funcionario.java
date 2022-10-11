package entidades;

public class Funcionario {
  private Integer cpf;
  private String nome;
  private Integer telefone;
  private String email;
  private Integer salario;

  public Funcionario(Integer cpf, String nome, Integer telefone, String email, Integer salario) {
    this.cpf = cpf;
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.salario = salario;
  }

  public Integer getCpf() {
    return cpf;
  }

  public void setCpf(Integer cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getTelefone() {
    return telefone;
  }

  public void setTelefone(Integer telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getSalario() {
    return salario;
  }

  public void setSalario(Integer salario) {
    this.salario = salario;
  }
}