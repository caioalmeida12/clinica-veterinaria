package conexaoDB;

import java.sql.*;
import java.util.Date;

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
