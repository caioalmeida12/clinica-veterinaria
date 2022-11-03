package conexaoDB;

import java.sql.*;
import entidades.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ConexaoDB {
    protected Connection connect = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

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
            System.out.println("Erro na função conectar() da classe ConexaoDB -> " + e.getMessage());
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
            System.out.println("Erro na função dateToDatetime() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        }
    }

    // Retorna todos os dados da tabela Servico de acordo com um filtro,
    // que pode ser vazio
    public List<Servico> selectServico() throws Exception {
        return this.selectServico("");
    }

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
            System.out.println("Erro na função selectServico() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo Servico no banco de dados
    public void insertServico(Servico servico) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "INSERT INTO `servico` (`tipoServico`, `descricaoServico`, `precoServico`) VALUES (0,?, ?, ?)");
            preparedStatement.setString(1, servico.getTipoServico());
            preparedStatement.setString(2, servico.getDescricaoServico());
            preparedStatement.setDouble(3, servico.getPrecoServico());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertServico() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do servico no banco de dados
    public void updateServico(Servico servico) throws Exception {
        try {
            preparedStatement = connect
                    .prepareStatement(
                            "UPDATE servico SET tipoServico = ?, descricaoServico = ?, precoServico = ? WHERE idServico = ? ");
            preparedStatement.setString(1, servico.getTipoServico());
            preparedStatement.setString(2, servico.getDescricaoServico());
            preparedStatement.setDouble(3, servico.getPrecoServico());
            preparedStatement.setInt(4, servico.getIdServico());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateServico() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do servico no banco de dados
    public void deleteServico(Integer idServico) throws Exception {
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM servico WHERE idServico = ?");
            preparedStatement.setInt(1, idServico);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteServico() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela Venda de acordo com um filtro,
    // que pode ser vazio
    public List<Venda> selectVenda() throws Exception {
        return this.selectVenda("");
    }

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
            System.out.println("Erro na função selectVenda() da classe ConexaoDB -> " + e.getMessage());
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
            System.out.println("Erro na função insertVenda() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do venda no banco de dados
    public void updateVenda(Venda venda) throws Exception {
        try {
            preparedStatement = connect
                    .prepareStatement(
                            "UPDATE venda SET idProduto = ?, idCliente = ?, idFuncionario = ?, dataVenda = ?, quantidadeProduto = ? WHERE idVenda = ? ");
            preparedStatement.setInt(1, venda.getIdProduto());
            preparedStatement.setInt(2, venda.getIdCliente());
            preparedStatement.setInt(3, venda.getIdFuncionario());
            preparedStatement.setDate(4, (java.sql.Date) venda.getDataVenda());
            preparedStatement.setInt(5, venda.getQuantidadeProduto());
            preparedStatement.setInt(6, venda.getIdVenda());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateVenda() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do venda no banco de dados
    public void deleteVenda(Integer idVenda) throws Exception {
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM venda WHERE idVenda = ?");
            preparedStatement.setInt(1, idVenda);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteVenda() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela animal-cliente de acordo com um filtro,
    // que pode ser vazio
    public List<AnimalCliente> selectAnimalCliente() throws Exception {
        return this.selectAnimalCliente("");
    }

    public List<AnimalCliente> selectAnimalCliente(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<AnimalCliente> resultado = new ArrayList<AnimalCliente>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM `animal-cliente` " + filtro);
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
            System.out.println("Erro na função selectAnimalCliente() da classe ConexaoDB -> " + e.getMessage());
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
            System.out.println("Erro na função insertAnimalCliente() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        }
    }

    // Altera os dados do relacionamento animal-cliente no banco de dados
    public void updateAnimalCliente(AnimalCliente animalCliente) throws Exception {
        try {
            preparedStatement = connect
                    .prepareStatement(
                            "UPDATE `animal-cliente` SET idAnimal = ?, idCliente = ? WHERE idAnimalCliente = ?");
            preparedStatement.setInt(1, animalCliente.getIdAnimal());
            preparedStatement.setInt(2, animalCliente.getIdCliente());
            preparedStatement.setInt(3, animalCliente.getIdAnimalCliente());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateAnimalCliente() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do animal no banco de dados
    public void deleteAnimalCliente(Integer idAnimalCliente) throws Exception {
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM `animal-cliente` WHERE idAnimalCliente = ?");
            preparedStatement.setInt(1, idAnimalCliente);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteAnimalCliente() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Retorna todos os dados da tabela agendamento de acordo com um filtro,
    // que pode ser vazio
    public List<Agendamento> selectAgendamento() throws Exception {
        return this.selectAgendamento("");
    }

    public List<Agendamento> selectAgendamento(String filtro) throws Exception {
        try {
            // Armazena todos os dados retornados
            List<Agendamento> resultado = new ArrayList<Agendamento>();
            // Executa a consulta
            resultSet = statement.executeQuery("SELECT * FROM agendamento " + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
                var idAgendamento = resultSet.getInt("idAgendamento");
                var idAnimal = resultSet.getInt("idAnimal");
                var idFuncionario = resultSet.getInt("idFuncionario");
                var idServico = resultSet.getInt("idServico");
                var dataAgendamento = resultSet.getDate("dataAgendamento");
                var situacaoAgendamento = resultSet.getString("situacaoAgendamento");

                // Instancia uma tupla da entidade agendamento
                Agendamento agendamento = new Agendamento(idAgendamento, idAnimal, idFuncionario, idServico,
                        dataAgendamento, situacaoAgendamento);

                // Envia a entidade para o resultado
                resultado.add(agendamento);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectAgendamento() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada na tabela agendamento
    public void insertAgendamento(Agendamento agendamento) throws Exception {
        try {
            preparedStatement = connect
                    .prepareStatement(
                            "INSERT INTO `agendamento` (`idAnimal`, `idFuncionario`, `idServico`, `dataAgendamento`, `situacaoAgendamento`) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, agendamento.getIdAnimal());
            preparedStatement.setInt(2, agendamento.getIdFuncionario());
            preparedStatement.setInt(3, agendamento.getIdServico());
            preparedStatement.setDate(4, (java.sql.Date) agendamento.getDataAgendamento());
            preparedStatement.setString(5, agendamento.getSituacaoAgendamento());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertAgendamento() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        }
    }

    // Altera os dados do relacionamento agendamento no banco de dados
    public void updateAgendamento(Agendamento agendamento) throws Exception {
        try {
            preparedStatement = connect
                    .prepareStatement(
                            "UPDATE agendamento SET idAnimal = ?, idFuncionario = ?, idServico = ?, dataAgendamento = ?, situacaoAgendamento = ? WHERE idAgendamento = ?");
            preparedStatement.setInt(1, agendamento.getIdAnimal());
            preparedStatement.setInt(2, agendamento.getIdFuncionario());
            preparedStatement.setInt(3, agendamento.getIdServico());
            preparedStatement.setDate(4, (java.sql.Date) agendamento.getDataAgendamento());
            preparedStatement.setString(5, agendamento.getSituacaoAgendamento());
            preparedStatement.setInt(6, agendamento.getIdAgendamento());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateAgendamento() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do agendamento no banco de dados
    public void deleteAgendamento(Integer idAgendamento) throws Exception {
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM agendamento WHERE idAgendamento = ?");
            preparedStatement.setInt(1, idAgendamento);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteAgendamento() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    protected void close() {
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
            System.out.println("Erro na função close() da classe ConexaoDB -> " + e.getMessage());
        }
    }

}
