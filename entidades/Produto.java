package entidades;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
  Connection connection = null;
  Connection a;
  Conexao c = new Conexao();

  public void SalvarValores() throws SQLException{
    String sql = "Insert into produto(idProduto,nomeProduto,precoProduto) values(0,?,?)" ;
    try {
      a = c.getConexao();
      PreparedStatement stmt = a.prepareStatement(sql);
      stmt.setString(1, nomeProduto);
      stmt.setString(2, String.valueOf(precoProduto));



      stmt.execute();
      stmt.close();

      c.FechaConexao();
    } catch (SQLException ex) {
      System.out.println("Deu Erro!\n"+ex);
    }

  }
  }




