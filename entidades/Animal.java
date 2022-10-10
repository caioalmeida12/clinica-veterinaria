package entidades;

public class Animal {
  private String nome;
  private String raca;
  private byte idade;
  private String especie;
  private char  sexo;
  private String cor;

  public String getNome(){
    return this.nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }
}