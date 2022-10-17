package entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao(){

        Connection conn = null;
try {

    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria?user=root&password=";
conn = DriverManager.getConnection(url);

}catch (SQLException e){

    System.out.println("Erro");



}

return conn;

    }

}
