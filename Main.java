import conexaoDB.*;
import entidades.*;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner input = new Scanner(System.in);

    ConexaoDB mysql = null;

    try {
      mysql = new ConexaoDB();
      var resultado = mysql.getVenda("WHERE idVenda = 2").get(0);
      System.out.println(resultado.getValorVenda());

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}