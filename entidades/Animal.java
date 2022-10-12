package entidades;
import java.util.Date;

public class Animal {
  private Integer idAnimal;
  private String nomeAnimal;
  private String racaAnimal;
  private Date nascimentoAnimal;
  private String especieAnimal;
  private char  sexoAnimal;
  private String corAnimal;
  
  public Animal(Integer idAnimal, String nomeAnimal, String racaAnimal, Date nascimentoAnimal, String especieAnimal,
      char sexoAnimal, String corAnimal) {
    this.idAnimal = idAnimal;
    this.nomeAnimal = nomeAnimal;
    this.racaAnimal = racaAnimal;
    this.nascimentoAnimal = nascimentoAnimal;
    this.especieAnimal = especieAnimal;
    this.sexoAnimal = sexoAnimal;
    this.corAnimal = corAnimal;
  }

  public Integer getIdAnimal() {
    return idAnimal;
  }
  public void setIdAnimal(Integer idAnimal) {
    this.idAnimal = idAnimal;
  }
  public String getNomeAnimal() {
    return nomeAnimal;
  }
  public void setNomeAnimal(String nomeAnimal) {
    this.nomeAnimal = nomeAnimal;
  }
  public String getRacaAnimal() {
    return racaAnimal;
  }
  public void setRacaAnimal(String racaAnimal) {
    this.racaAnimal = racaAnimal;
  }
  public Date getNascimentoAnimal() {
    return nascimentoAnimal;
  }
  public void setNascimentoAnimal(Date nascimentoAnimal) {
    this.nascimentoAnimal = nascimentoAnimal;
  }
  public String getEspecieAnimal() {
    return especieAnimal;
  }
  public void setEspecieAnimal(String especieAnimal) {
    this.especieAnimal = especieAnimal;
  }
  public char getSexoAnimal() {
    return sexoAnimal;
  }
  public void setSexoAnimal(char sexoAnimal) {
    this.sexoAnimal = sexoAnimal;
  }
  public String getCorAnimal() {
    return corAnimal;
  }
  public void setCorAnimal(String corAnimal) {
    this.corAnimal = corAnimal;
  }
  
}
