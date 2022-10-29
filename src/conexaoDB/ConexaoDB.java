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

            statement = connect.createStatement();
        } catch (Exception e) {
            System.out.println("Erro na função conectar() da classe ConexaoDB -> " + e);
            throw e;
        }
    }

    // Converte o parametro em um formato datetime legivel para o mysql
    public String dateToDatetime(Date date) throws Exception {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String currentTime = sdf.format(date);

            return currentTime;
        } catch (Exception e) {
            System.out.println("Erro na função dateToDatetime() da classe ConexaoDB -> " + e);
            throw e;
        }
    }

    // Retorna todos os dados da tabela animal de acordo com um filtro,
    // que pode ser vazio
    public List<Animal> selectAnimal() throws Exception {
        return this.selectAnimal("");
    }

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
                var sexoAnimal = resultSet.getString("sexoAnimal");
                var corAnimal = resultSet.getString("corAnimal");

                // Instancia uma tupla da entidade Animal
                Animal animal = new Animal(idAnimal, nomeAnimal, racaAnimal, nascimentoAnimal, especieAnimal,
                        sexoAnimal, corAnimal);

                // Envia a entidade para o resultado
                resultado.add(animal);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectAnimal() da classe ConexaoDB -> " + e);
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
            preparedStatement.setString(5, animal.getSexoAnimal());
            preparedStatement.setString(6, animal.getCorAnimal());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertAnimal() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do Animal no banco de dados
    public void updateAnimal(Animal animal) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "UPDATE animal SET nomeAnimal = ?, racaAnimal = ?, nascimentoAnimal = ?, especieAnimal = ?, sexoAnimal = ?, corAnimal = ? WHERE idAnimal = ? ");
            preparedStatement.setString(1, animal.getNomeAnimal());
            preparedStatement.setString(2, animal.getRacaAnimal());
            preparedStatement.setDate(3, (java.sql.Date) animal.getNascimentoAnimal());
            preparedStatement.setString(4, animal.getEspecieAnimal());
            preparedStatement.setString(5, animal.getSexoAnimal());
            preparedStatement.setString(6, animal.getCorAnimal());
            preparedStatement.setInt(7, animal.getIdAnimal());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateAnimal() da classe ConexaoDB -> " + e);
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
                Cliente cliente = new Cliente(idCliente, nomeCliente, cpfCliente, nascimentoCliente, emailCliente,
                        telefoneCliente, enderecoCliente);

                // Envia a entidade para o resultado
                resultado.add(cliente);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectCliente() da classe ConexaoDB -> " + e);
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
            preparedStatement.setString(1, cliente.getNomeCliente());
            preparedStatement.setString(2, cliente.getCpfCliente());
            preparedStatement.setDate(3, (java.sql.Date) cliente.getNascimentoCliente());
            preparedStatement.setString(4, cliente.getEmailCliente());
            preparedStatement.setString(5, cliente.getTelefoneCliente());
            preparedStatement.setString(6, cliente.getEnderecoCliente());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertCliente() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
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
                Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario,
                        nascimentoFuncionario, emailFuncionario, salarioFuncionario, telefoneFuncionario,
                        enderecoFuncionario);

                // Envia a entidade para o resultado
                resultado.add(funcionario);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectFuncionario() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo Funcionario no banco de dados
    public void insertFuncionario(Funcionario funcionario) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `funcionario` (`cpfFuncionario`, `nomeFuncionario`, `nascimentoFuncionario`, `emailFuncionario`, `salarioFuncionario`, `enderecoFuncionario`, `telefoneFuncionario`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, funcionario.getCpfFuncionario());
            preparedStatement.setString(2, funcionario.getNomeFuncionario());
            preparedStatement.setDate(3, (java.sql.Date) funcionario.getNascimentoFuncionario());
            preparedStatement.setString(4, funcionario.getEmailFuncionario());
            preparedStatement.setFloat(5, funcionario.getSalarioFuncionario());
            preparedStatement.setString(6, funcionario.getEnderecoFuncionario());
            preparedStatement.setString(7, funcionario.getTelefoneFuncionario());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertFuncionario() da classe ConexaoDB -> " + e);
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
                Produto produto = new Produto(idProduto, nomeProduto, precoProduto);

                // Envia a entidade para o resultado
                resultado.add(produto);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectProduto() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo Produto no banco de dados
    public void insertProduto(Produto produto) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `produto` (`idProduto`,`nomeProduto`, `precoProduto`) VALUES (0,?,?)");
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setDouble(2, produto.getPrecoProduto());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertProduto() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do Produto no banco de dados
    public void updateProduto(Produto produto) throws Exception {
        try {
            preparedStatement = connect
                    .prepareStatement("UPDATE produto SET nomeProduto = ?, precoProduto = ? WHERE idProduto = ? ");
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setDouble(2, produto.getPrecoProduto());
            preparedStatement.setInt(3, produto.getIdProduto());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateProduto() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do Produto no banco de dados
    public void deleteProduto(Produto produto) throws Exception {
        try {
            preparedStatement = connect.prepareStatement("delete from produto where idProduto = ?");
            preparedStatement.setInt(1, produto.getIdProduto());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteProduto() da classe ConexaoDB -> " + e);
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
                var precoServico = (Double) resultSet.getDouble("precoServico");

                // Instancia uma tupla da entidade Servico
                Servico servico = new Servico(idServico, tipoServico, descricaoServico, precoServico);

                // Envia a entidade para o resultado
                resultado.add(servico);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectServico() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo Servico no banco de dados
    public void insertServico(Servico servico) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `servico` (`idServico`,`tipoServico`, `descricaoServico`, `precoServico`) VALUES (0,?, ?, ?)");
            preparedStatement.setString(1, servico.getTipoServico());
            preparedStatement.setString(2, servico.getDescricaoServico());
            preparedStatement.setDouble(3, servico.getPrecoServico());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertServico() da classe ConexaoDB -> " + e);
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
                Venda venda = new Venda(idVenda, idProduto, idCliente, idFuncionario, dataVenda, quantidadeVenda);

                // Envia a entidade para o resultado
                resultado.add(venda);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectVenda() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo Venda no banco de dados
    public void insertVenda(Venda venda) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `venda` (`idProduto`, `idCliente`, `idFuncionario`, `dataVenda`, `quantidadeProduto`) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, venda.getProdutoVenda().getIdProduto());
            preparedStatement.setInt(2, venda.getClienteVenda().getIdCliente());
            preparedStatement.setInt(3, venda.getFuncionarioVenda().getIdFuncionario());
            preparedStatement.setString(4, dateToDatetime(new Date()));
            preparedStatement.setInt(5, venda.getQuantidadeProduto());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertVenda() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela animal-cliente de acordo com um filtro,
    // que pode ser vazio
    public List<AnimalCliente> selectAnimalCliente(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<AnimalCliente> resultado = new ArrayList<AnimalCliente>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM animal-cliente " + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idAnimalCliente = resultSet.getInt("idAnimalCliente");
                var idAnimal = resultSet.getInt("idAnimal");
                var idCliente = resultSet.getInt("idCliente");

                // Instancia uma tupla da entidade AnimalCliente
                AnimalCliente animalCliente = new AnimalCliente(idAnimalCliente, idAnimal, idCliente);

                // Envia a entidade para o resultado
                resultado.add(animalCliente);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectAnimalCliente() da classe ConexaoDB -> " + e);
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada na tabela animal-cliente
    public void insertAnimalCliente(int idAnimal, int idCliente) throws Exception {
        try {
            preparedStatement = connect
                    .prepareStatement("INSERT INTO `animal-cliente` (`idAnimal`, `idCliente`) VALUES (?, ?)");
            preparedStatement.setInt(1, idAnimal);
            preparedStatement.setInt(2, idCliente);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertAnimalCliente() da classe ConexaoDB -> " + e);
            throw e;
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
