package conexaoDB;

import entidades.Agendamento;
import entidades.Venda;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class VendaDB extends ConexaoDB {
    // Retorna todos os dados da tabela Venda de acordo com um filtro,
    // que pode ser vazio
    public List<Venda> selectVenda() throws Exception {
        return this.selectVenda("");
    }

    public List<Venda> selectVenda(String filtro) throws Exception {
        try {
            this.conectar();
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
    
     public List<Venda> selectVenda2(String filtro) throws Exception {
        try {
            this.conectar();
            // Armazena todos os dados retornados
            List<Venda> resultado = new ArrayList<Venda>();
            

            // Executa a consulta
           
            
            
            
            resultSet = statement.executeQuery("SELECT idVenda,produto.nomeProduto,cliente.nomeCliente,funcionario.nomeFuncionario,dataVenda,quantidadeProduto FROM `venda` "
                    + "INNER JOIN produto on venda.idProduto = produto.idProduto "
                    + "INNER join cliente on venda.idCliente = cliente.idCliente "
                    + "INNER JOIN funcionario on venda.idFuncionario = funcionario.idFuncionario;" + filtro);
            while (resultSet.next()) {
                // Tratamento dos dados
            var idVenda = resultSet.getInt("idVenda");
            var nomeProduto = resultSet.getString("nomeProduto");
            var nomeCliente = resultSet.getString("nomeCliente");
            var nomeFuncionario = resultSet.getString("nomeFuncionario");
            var dataVenda = resultSet.getDate("dataVenda");
            var quantidadeProduto = resultSet.getInt("quantidadeProduto");

                // Instancia uma tupla da entidade agendamentoAgendamento agendamento = new Agendamento(idAgendamento,nomeAnimal,nomeFuncionario,tipoServico,dataAgendamento,situacaoAgendamento);
                  Venda venda = new Venda(idVenda, dataVenda, quantidadeProduto, nomeFuncionario, nomeCliente, nomeProduto);
                // Envia a entidade para o resultado
                resultado.add(venda);
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("Erro na função selectVenda2() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    };

    // Insere uma nova entrada do tipo Venda no banco de dados
    public void insertVenda(Venda venda) throws Exception {
        try {
            this.conectar();
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
            this.conectar();
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
    public void deleteVenda(Venda venda) throws Exception {
        this.deleteVenda(venda.getIdVenda());
    }

    public void deleteVenda(Integer idVenda) throws Exception {
        try {
            this.conectar();
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

}
