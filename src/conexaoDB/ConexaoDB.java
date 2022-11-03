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
