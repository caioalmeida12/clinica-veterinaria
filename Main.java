import View.ClienteView;
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

    new ClienteView().setVisible(true);

   /* try {
      mysql = new ConexaoDB();
      mysql.insertAnimalCliente(1, 2);

    } catch (Exception e) {
      System.out.println(e);
    }*/
  }
}