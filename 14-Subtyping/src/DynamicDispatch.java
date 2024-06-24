package subtyping;

interface Greeter {
  void sayHello();
  default void sayHello(String to) {
    System.out.println("Hoi!");
  }
}

class Swabian implements Greeter {
  public void sayHello() { System.out.println("Hoi!"); }
  public void sayHello(String to) {
    System.out.println("Hoi!!!!");
  }
}
class Bavarian implements Greeter {
  public void sayHello() { System.out.println("Servus!"); }
}


class Hamburgian implements Greeter {
  public void sayHello() { System.out.println("Moin!"); }
}


public class DynamicDispatch {
  public static void main(String[] args) {
    Greeter g;
    if (Math.random() > 0.5) g = new Swabian(); else g = new Bavarian();

    g.sayHello();
    g.sayHello("Jonathan");
  }
}
