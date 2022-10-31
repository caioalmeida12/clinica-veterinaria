package entidades;

public class Servico {
    Integer idServico;
    String tipoServico;
    String descricaoServico;
    Double precoServico;

    public Servico(Integer idServico, String tipoServico, String descricaoServico, Double precoServico) {
        this.idServico = idServico;
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.precoServico = precoServico;
    }

    public Servico(String tipoServico, String descricaoServico, Double precoServico) {
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.precoServico = precoServico;
    }

    public Integer getidServico() {
        return idServico;
    }

    public void setidServico(Integer idServico) {
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

    public Double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(Double precoServico) {
        this.precoServico = precoServico;
    }

}
