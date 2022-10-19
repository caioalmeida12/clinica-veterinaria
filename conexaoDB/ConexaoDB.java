package conexaoDB;

import java.sql.*;
import entidades.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoDB {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void conectar() throws Exception {
        try {
            // Tenta conectar o DB
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/clinica-veterinaria?"
                            + "user=root&password=");

            statement = connect.createStatement();
        } catch (Exception e) {
            throw e;
        }
    }

    // Retorna todos os dados da tabela animal de acordo com um filtro,
    // que pode ser vazio
    public List<Animal> getAnimal(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Animal> resultado = new ArrayList<Animal>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM animal" + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idAnimal = (Integer) resultSet.getInt("idAnimal");
                var nomeAnimal = resultSet.getString("nomeAnimal");
                var racaAnimal = resultSet.getString("racaAnimal");
                var nascimentoAnimal = resultSet.getDate("nascimentoAnimal");
                var especieAnimal = resultSet.getString("especieAnimal");
                var sexoAnimal = resultSet.getString("sexoAnimal").charAt(0);
                var corAnimal = resultSet.getString("corAnimal");

                // Instancia uma tupla da entidade Animal
                Animal temporario = new Animal(idAnimal, nomeAnimal, racaAnimal, nascimentoAnimal, especieAnimal,
                        sexoAnimal, corAnimal);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela cliente de acordo com um filtro,
    // que pode ser vazio
    public List<Cliente> getCliente(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Cliente> resultado = new ArrayList<Cliente>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM cliente" + filtro);
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
                Cliente temporario = new Cliente(idCliente, nomeCliente, cpfCliente, nascimentoCliente, emailCliente,
                        telefoneCliente, enderecoCliente);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela funcionario de acordo com um filtro,
    // que pode ser vazio
    public List<Funcionario> getFuncionario(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Funcionario> resultado = new ArrayList<Funcionario>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM funcionario" + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idFuncionario = (Integer) resultSet.getInt("idFuncionario");
                var nomeFuncionario = resultSet.getString("nomeFuncionario");
                var cpfFuncionario = (Integer) resultSet.getInt("cpfFuncionario");
                var nascimentoFuncionario = resultSet.getDate("nascimentoFuncionario");
                var emailFuncionario = resultSet.getString("emailFuncionario");
                var salarioFuncionario = (Float) resultSet.getFloat("salarioFuncionario");
                var telefoneFuncionario = resultSet.getString("telefoneFuncionario");
                var enderecoFuncionario = resultSet.getString("enderecoFuncionario");

                // Instancia uma tupla da entidade Funcionario
                Funcionario temporario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario,
                        nascimentoFuncionario, emailFuncionario, salarioFuncionario, telefoneFuncionario, enderecoFuncionario);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
