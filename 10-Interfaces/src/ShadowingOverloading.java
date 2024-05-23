public class ShadowingOverloading {

  static int n = 1;

  public static void main(String[] args) {
    System.out.println(n); // 1
    {
      int n = 42;
      System.out.println(n);
      System.out.println(other());
    }
  }

  static int other() { return n; }
}
