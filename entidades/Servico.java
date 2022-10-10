package entidades;

import java.util.Date;

public class Servico {

  private String tipo;
  private String descricao;
  private Double valor;
  private Date dataServico;

  public Servico() {
  }

  public Servico(String tipo, String descricao, Double valor, Date dataServico) {
    this.tipo = tipo;
    this.descricao = descricao;
    this.valor = valor;
    this.dataServico = dataServico;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Date getDataServico() {
    return dataServico;
  }

  public void setDataServico(Date dataServico) {
    this.dataServico = dataServico;
  }

}
