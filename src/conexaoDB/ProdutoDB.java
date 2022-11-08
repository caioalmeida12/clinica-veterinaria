package conexaoDB;

import entidades.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDB extends ConexaoDB {
    // Retorna todos os dados da tabela Produto de acordo com um filtro,
    // que pode ser vazio
    public List<Produto> selectProduto() throws Exception {
        return this.selectProduto("");
    }

    public List<Produto> selectProduto(String filtro) throws Exception {
        try {
            this.conectar();
            // Armazena todos os dados retornados
            List<Produto> resultado = new ArrayList<Produto>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM produto " + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idProduto = (Integer) resultSet.getInt("idProduto");
                var nomeProduto = resultSet.getString("nomeProduto");
                var precoProduto = resultSet.getDouble("precoProduto");

                // Instancia uma tupla da entidade Funcionario
                Produto produto = new Produto(idProduto, nomeProduto, precoProduto);

                // Envia a entidade para o resultado
                resultado.add(produto);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectProduto() filtro da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo Produto no banco de dados
    public void insertProduto(Produto produto) throws Exception {
        try {
            this.conectar();
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `produto` (`nomeProduto`, `precoProduto`) VALUES (?,?)");
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setDouble(2, produto.getPrecoProduto());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertProduto() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do produto no banco de dados
    public void updateProduto(Produto produto) throws Exception {
        try {
            this.conectar();
            preparedStatement = connect
                    .prepareStatement("UPDATE produto SET nomeProduto = ?, precoProduto = ? WHERE idProduto = ? ");
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setDouble(2, produto.getPrecoProduto());
            preparedStatement.setInt(3, produto.getIdProduto());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateProduto() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do Produto no banco de dados
    public void deleteProduto(Produto produto) throws Exception {
        try {
            this.conectar();
            preparedStatement = connect.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            preparedStatement.setInt(1, produto.getIdProduto());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteProduto() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

}
