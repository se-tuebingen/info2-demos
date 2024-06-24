public class StaticDynamic {

  static int x = 10; // static "class" field (global)

  int y; // field on instances of the class

  StaticDynamic(int y) { this.y = y; }

  // static class method
  static void f() { System.out.println(StaticDynamic.x); }

  // method on instances of class StaticDynamic
  void m() {
    System.out.println(StaticDynamic.x);
    System.out.println(this.y);
    StaticDynamic.f();
  }
}
