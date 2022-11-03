package conexaoDB;

import entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDB extends ConexaoDB {
    // Retorna todos os dados da tabela funcionario de acordo com um filtro,
    // que pode ser vazio
    public List<Funcionario> selectFuncionario() throws Exception {
        return this.selectFuncionario("");
    }

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
                var cpfFuncionario = resultSet.getString("cpfFuncionario");
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
            System.out.println("Erro na função selectFuncionario() da classe ConexaoDB -> " + e.getMessage());
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
            preparedStatement.setString(1, funcionario.getCpfFuncionario());
            preparedStatement.setString(2, funcionario.getNomeFuncionario());
            preparedStatement.setDate(3, (java.sql.Date) funcionario.getNascimentoFuncionario());
            preparedStatement.setString(4, funcionario.getEmailFuncionario());
            preparedStatement.setFloat(5, funcionario.getSalarioFuncionario());
            preparedStatement.setString(6, funcionario.getEnderecoFuncionario());
            preparedStatement.setString(7, funcionario.getTelefoneFuncionario());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função insertFuncionario() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do funcionario no banco de dados
    public void updateFuncionario(Funcionario funcionario) throws Exception {
        try {
            preparedStatement = connect.prepareStatement(
                    "UPDATE funcionario SET nomeFuncionario = ?, cpfFuncionario = ?, nascimentoFuncionario = ?, emailFuncionario = ?, salarioFuncionario = ?, telefoneFuncionario = ?, enderecoFuncionario = ? WHERE idFuncionario = ? ");
            preparedStatement.setString(1, funcionario.getNomeFuncionario());
            preparedStatement.setString(2, funcionario.getCpfFuncionario());
            preparedStatement.setDate(3, (java.sql.Date) funcionario.getNascimentoFuncionario());
            preparedStatement.setString(4, funcionario.getEmailFuncionario());
            preparedStatement.setFloat(5, funcionario.getSalarioFuncionario());
            preparedStatement.setString(6, funcionario.getTelefoneFuncionario());
            preparedStatement.setString(7, funcionario.getEnderecoFuncionario());
            preparedStatement.setInt(8, funcionario.getIdFuncionario());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função updateFuncionario() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do funcionario no banco de dados
    public void deleteFuncionario(Integer idFuncionario) throws Exception {
        try {
            preparedStatement = connect.prepareStatement("DELETE FROM funcionario WHERE idFuncionario = ?");
            preparedStatement.setInt(1, idFuncionario);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteFuncionario() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }
}
