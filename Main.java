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
      // var resultado = mysql.selectCliente("WHERE idCliente = 2").get(0);
      // mysql = new ConexaoDB();
      var resultado = new Funcionario((Integer) 5, "mateur", (Integer) 0101010101, new java.sql.Date(2022, 01, 07),
          "mateu@gmail.com",
          (Float) 2424f,
          "92812837",
          "tesss");
      mysql.insertFuncionario(resultado);

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}