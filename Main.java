
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




      try {

          // Prepare a statement to insert a record
          String sql = "INSERT INTO agendamento (idAgendamento, idAnimal, `idFuncionario`, `idServico`, `dataAgendamento`, `situacaoAgendamento`) VALUES\n" +
                  "(1, 1, 1, 1, 2022-10-13 21:07:21, adiado),\n" +
                  "(2, 2, 2, 2, 2022-10-13 21:07:56, adiado)";

          // Execute the insert statement
          Statement stmt = (Statement) connection.prepareStatement(sql);

          stmt.execute(sql);

      } catch (SQLException e) {
      }




      int n = sc.nextInt();
    Servico[] vect = new Servico[n];

    for (int i = 0; i < vect.length; i++){
      sc.nextLine();
      String tipoServico = sc.nextLine();
      double valorServico = sc.nextDouble();
      vect[i] = new Servico(tipoServico,valorServico);

    }

    for (int i = 0; i < vect.length; i++) {

      System.out.println("Tipo do servico,"+ vect[i].getTipoServico());
      System.out.println("valor,"+ vect[i].getValorServico());

    }













  }
}