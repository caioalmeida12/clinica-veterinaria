package entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conn = null;
    public Connection getConexao(){


try {

    String url = "jdbc:mysql://localhost:3306/clinica_veterinaria?user=root&password=";
conn = DriverManager.getConnection(url);


}catch (SQLException e){

    System.out.println("Erro");



}

return conn;

    }

    public void FechaConexao(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Não conectado!!\n"+ex);
        }
    }

}
