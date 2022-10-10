import entidades.Animal;

class Main {
  public static void main(String[] args) {
    Animal makako = new Animal();
    makako.setNome("Makako");
    System.out.println(makako.getNome());
  }
}