package conexaoDB;

import java.sql.*;
import entidades.*;

public class ConexaoDB {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void conectar() throws Exception {
        try {
            // Tenta conectar o DB
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/clinica-veterinaria?"
                            + "user=root&password=");

            statement = connect.createStatement();
        } catch (Exception e) {
            throw e;
        }
    }

    // Retorna todos os dados da tabela cliente
    public Cliente getCliente() throws Exception {
        try {
            // executa uma busca de tabela
            resultSet = statement.executeQuery("select * from cliente");
            resultSet.next();
            var idCliente = (Integer) resultSet.getInt("idCliente");
            var nomeCliente = resultSet.getString("nomeCliente");
            var cpfCliente = resultSet.getString("cpfCliente");
            var nascimentoCliente = resultSet.getDate("nascimentoCliente");
            var emailCliente = resultSet.getString("emailCliente");
            var telefoneCliente = resultSet.getString("telefoneCliente");
            var enderecoCliente = resultSet.getString("enderecoCliente");

            Cliente temporario = new Cliente(idCliente, nomeCliente, cpfCliente, nascimentoCliente, emailCliente,
                    telefoneCliente, enderecoCliente);

            return temporario;
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        // Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));

    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("nomeCliente");
            System.out.println("User: " + user);
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

        }
    }

}
