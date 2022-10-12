
import entidades.*;

import java.util.Locale;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {


    System.out.println("Hello world!");
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

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