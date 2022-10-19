
import entidades.*;

import conexaoDB.*;
import java.util.Locale;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner input = new Scanner(System.in);

    ConexaoDB mysql = new ConexaoDB();

    try {
      mysql.conectar();

      var resultado = mysql.getCliente("");
      System.out.println(resultado.get(1).getNomeCliente());

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}