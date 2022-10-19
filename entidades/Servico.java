package entidades;

public class Servico {
    Integer idProduto;
    String tipoServico;
    String descricaoServico;
    Float precoServico;

    public Servico(Integer idProduto, String tipoServico, String descricaoServico, Float precoServico) {
        this.idProduto = idProduto;
        this.tipoServico = tipoServico;
        this.descricaoServico = descricaoServico;
        this.precoServico = precoServico;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
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

    public Float getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(Float precoServico) {
        this.precoServico = precoServico;
    }

}
