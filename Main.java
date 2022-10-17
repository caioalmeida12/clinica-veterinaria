
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

      Connection connection = null;









      int n = sc.nextInt();
    Produto[] vect = new Produto[n];

    for (int i = 0; i < vect.length; i++){
      sc.nextLine();
      String nomeProduto = sc.nextLine();
      double valorProduto = sc.nextDouble();
      vect[i] = new Produto(nomeProduto,valorProduto);

    }















  }
}