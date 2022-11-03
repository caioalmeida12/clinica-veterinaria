package conexaoDB;

import entidades.Servico;
import java.util.ArrayList;
import java.util.List;

public class ServicoDB extends ConexaoDB {
    // Retorna todos os dados da tabela Servico de acordo com um filtro,
    // que pode ser vazio
    public List<Servico> selectServico() throws Exception {
        return this.selectServico("");
    }

    public List<Servico> selectServico(String filtro) throws Exception {
        try {
            this.conectar();
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
            this.conectar();
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
            this.conectar();
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
            this.conectar();
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
}
