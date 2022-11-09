package conexaoDB;

import entidades.Agendamento;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDB extends ConexaoDB {
    // Retorna todos os dados da tabela agendamento de acordo com um filtro,
    // que pode ser vazio
    public List<Agendamento> selectAgendamento() throws Exception {
        return this.selectAgendamento("");
    }

    public List<Agendamento> selectAgendamento(String filtro) throws Exception {
        try {
            this.conectar();
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
            this.conectar();
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
            this.conectar();
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
    public void deleteAgendamento(Agendamento agendamento) throws Exception {
        this.deleteAgendamento(agendamento.getIdAgendamento());
    }

    public void deleteAgendamento(Integer idAgendamento) throws Exception {
        try {
            this.conectar();
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
}
