package entidades;

import java.util.Date;

public class Servico {

  private Integer idServico;
  private String tipoServico;
  private String descricaoServico;
  private Double valorServico;
  private Date dataServico;

  public Servico(Integer idServico, String tipoServico, String descricaoServico, Double valorServico, Date dataServico) {
    this.idServico = idServico;
    this.tipoServico = tipoServico;
    this.descricaoServico = descricaoServico;
    this.valorServico = valorServico;
    this.dataServico = dataServico;


  }

  public Servico(String tipoServico, Double valorServico) {
    this.tipoServico = tipoServico;
    this.valorServico = valorServico;
  }

  public Integer getIdServico() {
    return idServico;
  }

  public void setIdServico(Integer idServico) {
    this.idServico = idServico;
  }

  public String getTipoServico() {
    return tipoServico;
  }

  public void setTipoServico(String tipoServico) {
    this.tipoServico = tipoServico;
  }

  public String getDescricaoServico() {
    return descricaoServico;
  }

  public void setDescricaoServico(String descricaoServico) {
    this.descricaoServico = descricaoServico;
  }

  public Double getValorServico() {
    return valorServico;
  }

  public void setValorServico(Double valorServico) {
    this.valorServico = valorServico;
  }

  public Date getDataServico() {
    return dataServico;
  }

  public void setDataServico(Date dataServico) {
    this.dataServico = dataServico;
  }
}


