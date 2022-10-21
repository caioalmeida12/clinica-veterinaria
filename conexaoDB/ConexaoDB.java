package conexaoDB;

import java.sql.*;
import entidades.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ConexaoDB {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ConexaoDB() {
        try {
            conectar();
        } catch (Exception e) {
            System.out.println("Não foi possível conectar ao BD");
        }
    }

    public void conectar() throws Exception {
        try {
            // Tenta conectar o DB
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/clinica-veterinaria?"
                            + "user=root&password=");
            // .getConnection("jdbc:mysql://localhost/clinica_veterinaria?"
            // + "user=root&password=");

            statement = connect.createStatement();
        } catch (Exception e) {
            System.out.println("Erro na função conectar() da classe ConexaoDB");
            throw e;
        }
    }

    // Retorna todos os dados da tabela animal de acordo com um filtro,
    // que pode ser vazio
    public List<Animal> selectAnimal(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Animal> resultado = new ArrayList<Animal>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM animal " + filtro);
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
            System.out.println("Erro na função selectAnimal() da classe ConexaoDB");
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo Animal no banco de dados
    public void insertAnimal(Animal animal) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `animal` (`nomeAnimal`, `racaAnimal`, `nascimentoAnimal`, `especieAnimal`, `sexoAnimal`, `corAnimal`) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, animal.getNomeAnimal());
            preparedStatement.setString(2, animal.getRacaAnimal());
            preparedStatement.setDate(3, (java.sql.Date) animal.getNascimentoAnimal());
            preparedStatement.setString(4, animal.getEspecieAnimal());
            preparedStatement.setString(5, Character.toString(animal.getSexoAnimal()));
            preparedStatement.setString(6, animal.getCorAnimal());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertAnimal() da classe ConexaoDB");
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela cliente de acordo com um filtro,
    // que pode ser vazio
    public List<Cliente> selectCliente(String filtro) throws Exception {
        try {
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
                Cliente temporario = new Cliente(idCliente, nomeCliente, cpfCliente, nascimentoCliente, emailCliente,
                        telefoneCliente, enderecoCliente);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectCliente() da classe ConexaoDB");
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo CLiente no banco de dados
    public void insertCliente(Cliente cliente) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `cliente` (`nomeCliente`, `cpfCliente`, `nascimentoCliente`, `emailCliente`, `telefoneCliente`, `enderecoCliente`) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, null);
        } catch (Exception e) {
            System.out.println("Erro na função insertCliente() da classe ConexaoDB");
            throw e;
        } finally {

        }
    }

    // Retorna todos os dados da tabela funcionario de acordo com um filtro,
    // que pode ser vazio
    public List<Funcionario> selectFuncionario(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Funcionario> resultado = new ArrayList<Funcionario>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM funcionario " + filtro);

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
                        nascimentoFuncionario, emailFuncionario, salarioFuncionario, telefoneFuncionario,
                        enderecoFuncionario);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectFuncionario() da classe ConexaoDB");
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela Produto de acordo com um filtro,
    // que pode ser vazio
    public List<Produto> selectProduto(String filtro) throws Exception {
        try {
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
                Produto temporario = new Produto(idProduto, nomeProduto, precoProduto);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectProduto() da classe ConexaoDB");
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela Servico de acordo com um filtro,
    // que pode ser vazio
    public List<Servico> selectServico(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Servico> resultado = new ArrayList<Servico>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM Servico " + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idServico = (Integer) resultSet.getInt("idServico");
                var tipoServico = resultSet.getString("tipoServico");
                var descricaoServico = resultSet.getString("descricaoServico");
                var precoServico = (Float) resultSet.getFloat("precoServico");

                // Instancia uma tupla da entidade Servico
                Servico temporario = new Servico(idServico, tipoServico, descricaoServico, precoServico);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectServico() da classe ConexaoDB");
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela Venda de acordo com um filtro,
    // que pode ser vazio
    public List<Venda> selectVenda(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Venda> resultado = new ArrayList<Venda>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM venda " + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idVenda = (Integer) resultSet.getInt("idVenda");
                var idProduto = (Integer) resultSet.getInt("idProduto");
                var idCliente = (Integer) resultSet.getInt("idCliente");
                var idFuncionario = (Integer) resultSet.getInt("idFuncionario");
                var dataVenda = resultSet.getDate("dataVenda");
                var quantidadeVenda = (Integer) resultSet.getInt("quantidadeProduto");

                // Instancia uma tupla da entidade Venda
                Venda temporario = new Venda(idVenda, idProduto, idCliente, idFuncionario, dataVenda, quantidadeVenda);

                // Envia a entidade para o resultado
                resultado.add(temporario);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectVenda() da classe ConexaoDB");
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
            System.out.println("Erro na função close() da classe ConexaoDB \n" + e);
        }
    }

}
