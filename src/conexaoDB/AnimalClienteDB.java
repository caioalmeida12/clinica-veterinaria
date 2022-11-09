package conexaoDB;

import entidades.AnimalCliente;
import java.util.ArrayList;
import java.util.List;

public class AnimalClienteDB extends ConexaoDB {
    // Retorna todos os dados da tabela animal-cliente de acordo com um filtro,
    // que pode ser vazio
    public List<AnimalCliente> selectAnimalCliente() throws Exception {
        return this.selectAnimalCliente("");
    }

    public List<AnimalCliente> selectAnimalCliente(String filtro) throws Exception {
        try {
            this.conectar();
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
            this.conectar();
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
            this.conectar();
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
    public void deleteAnimalCliente(AnimalCliente animalCliente) throws Exception {
        this.deleteAnimalCliente(animalCliente.getIdAnimalCliente());
    }

    public void deleteAnimalCliente(Integer idAnimalCliente) throws Exception {
        try {
            this.conectar();
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

}
