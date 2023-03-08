package entidades;

public class Produto {

  private Integer idProduto;
  private String nomeProduto;
  private Double precoProduto;

  public Produto(Integer idProduto, String nomeProduto, Double precoProduto) {
    this.idProduto = idProduto;
    this.nomeProduto = nomeProduto;
    this.precoProduto = precoProduto;
  }

  public Produto(String nomeProduto, Double precoProduto) {
    this.nomeProduto = nomeProduto;
    this.precoProduto = precoProduto;
  }

   public Produto(Integer idProduto) {
    this.idProduto = idProduto;
    
  }
    

  public Integer getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(Integer idProduto) {
    this.idProduto = idProduto;
  }

  public String getNomeProduto() {
    return nomeProduto;
  }

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }

  public Double getPrecoProduto() {
    return precoProduto;
  }

  public void setPrecoProduto(Double precoProduto) {
    this.precoProduto = precoProduto;
  }

}
