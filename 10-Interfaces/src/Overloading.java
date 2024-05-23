public class Overloading {

  public static void main(String[] args) {
    // The respective function is chosen at compile time.
    // This becomes visible in two ways:
    // 1. You can "jump-to-definition" (CTRL+Click) in the IDE
    // 2. You can inspect the bytecode and check which function is actually called.
    add(1, 3);
    add(1.0, 3.0);
  }

// We cannot overload based on the return type:
//
//  public static int compute() { return 0; }
//  public static double compute() { return 1.3; }


  public static int add(int x, int y) {
    System.out.println("Adding integers");
    return x + y;
  }
  public static double add(double x, double y) {
    System.out.println("Adding doubles");
    return x + y;
  }

  public static int addInts(int x, int y) {
    System.out.println("Adding integers");
    return x + y;
  }
  public static double addDoubles(double x, double y) {
    System.out.println("Adding doubles");
    return x + y;
  }

}
