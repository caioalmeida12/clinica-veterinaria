package conexaoDB;

import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDB extends ConexaoDB {
    // Retorna todos os dados da tabela cliente de acordo com um filtro,
    // que pode ser vazio
    public List<Cliente> selectCliente() throws Exception {
        return this.selectCliente("");
    }

    public List<Cliente> selectCliente(String filtro) throws Exception {
        try {
            this.conectar();
            // Armazena todos os dados retornados
            List<Cliente> resultado = new ArrayList<Cliente>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM cliente " + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idCliente = (Integer) resultSet.getInt("idCliente");
                var nomeCliente = resultSet.getString("nomeCliente");
                var cpfCliente = resultSet.getString("cpfCliente");
                var nascimentoCliente = resultSet.getDate("nascimentoCliente");
                var emailCliente = resultSet.getString("emailCliente");
                var telefoneCliente = resultSet.getString("telefoneCliente");
                var enderecoCliente = resultSet.getString("enderecoCliente");

                // Instancia uma tupla da entidade Cliente
                Cliente cliente = new Cliente(idCliente, nomeCliente, cpfCliente, nascimentoCliente, emailCliente,
                        telefoneCliente, enderecoCliente);

                // Envia a entidade para o resultado
                resultado.add(cliente);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectCliente() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo cliente no banco de dados
    public void insertCliente(Cliente cliente) throws Exception {
        try {
            this.conectar();
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `cliente` (`nomeCliente`, `cpfCliente`, `nascimentoCliente`, `emailCliente`, `telefoneCliente`, `enderecoCliente`) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, cliente.getNomeCliente());
            preparedStatement.setString(2, cliente.getCpfCliente());
            preparedStatement.setDate(3, (java.sql.Date) cliente.getNascimentoCliente());
            preparedStatement.setString(4, cliente.getEmailCliente());
            preparedStatement.setString(5, cliente.getTelefoneCliente());
            preparedStatement.setString(6, cliente.getEnderecoCliente());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertCliente() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do cliente no banco de dados
    public void updateCliente(Cliente cliente) throws Exception {
        try {
            this.conectar();
            preparedStatement = connect.prepareStatement(
                    "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, nascimentoCliente = ?, emailCliente = ?, telefoneCliente = ?, enderecoCliente = ? WHERE idCliente = ? ");
            preparedStatement.setString(1, cliente.getNomeCliente());
            preparedStatement.setString(2, cliente.getCpfCliente());
            preparedStatement.setDate(3, (java.sql.Date) cliente.getNascimentoCliente());
            preparedStatement.setString(4, cliente.getEmailCliente());
            preparedStatement.setString(5, cliente.getTelefoneCliente());
            preparedStatement.setString(6, cliente.getEnderecoCliente());
            preparedStatement.setInt(7, cliente.getIdCliente());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateCliente() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do cliente no banco de dados
    public void deleteCliente(Integer idCliente) throws Exception {
        try {
            this.conectar();
            preparedStatement = connect.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            preparedStatement.setInt(1, idCliente);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteCliente() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }
}
