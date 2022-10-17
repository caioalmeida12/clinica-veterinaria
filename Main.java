
import com.mysql.jdbc.Statement;
import entidades.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica-veterinaria", "root", "")) {
      System.out.println("Database connected!");
  } catch (SQLException e) {
      throw new IllegalStateException("Cannot connect the database!", e);
  }
  }
}