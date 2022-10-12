package entidades;

public class Animal {

  private String nome;
  private String raca;
  private byte idade;
  private String especie;
  private char  sexo;
  private String cor;

  public Animal(String nome, String raca, byte idade, String especie, char sexo, String cor) {
    this.nome = nome;
    this.raca = raca;
    this.idade = idade;
    this.especie = especie;
    this.sexo = sexo;
    this.cor = cor;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRaca() {
    return raca;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  public byte getIdade() {
    return idade;
  }

  public void setIdade(byte idade) {
    this.idade = idade;
  }

  public String getEspecie() {
    return especie;
  }

  public void setEspecie(String especie) {
    this.especie = especie;
  }

  public char getSexo() {
    return sexo;
  }

  public void setSexo(char sexo) {
    this.sexo = sexo;
  }

  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }
}
