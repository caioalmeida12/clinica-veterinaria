package conexaoDB;

import entidades.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalDB extends ConexaoDB {
    // Retorna todos os dados da tabela animal de acordo com um filtro,
    // que pode ser vazio
    public List<Animal> selectAnimal() throws Exception {
        return this.selectAnimal("");
    }

    public List<Animal> selectAnimal(String filtro) throws Exception {
        try {
            this.conectar();
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
            System.out.println("Erro na função selectAnimal() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Insere uma nova entrada do tipo animal no banco de dados
    public void insertAnimal(Animal animal) throws Exception {
        try {
            this.conectar();
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
            System.out.println("Erro na função insertAnimal() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Altera os dados do animal no banco de dados
    public void updateAnimal(Animal animal) throws Exception {
        try {
            this.conectar();
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
            System.out.println("Erro na função updateAnimal() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }

    // Excluir os dados do animal no banco de dados
    public void deleteAnimal(Animal animal) throws Exception {
        this.deleteAnimal(animal.getIdAnimal());
    }

    public void deleteAnimal(Integer idAnimal) throws Exception {
        try {
            this.conectar();
            preparedStatement = connect.prepareStatement("DELETE FROM animal WHERE idAnimal = ?");
            preparedStatement.setInt(1, idAnimal);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erro na função deleteAnimal() da classe ConexaoDB -> " + e.getMessage());
            throw e;
        } finally {
            close();
        }
    }
}
