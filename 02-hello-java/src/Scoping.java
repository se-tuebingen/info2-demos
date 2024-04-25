public class Scoping {

  public static void main(String[] args) {
    // Constant and variable bindings have a "scope" that
    // they are valid in.

    // For example, we cannot refer to x, before it is bound
    //    System.out.println(x); // Tip: try commenting this out

    final int x = 4;

    // after defining, this is fine
    System.out.println(x);

    // Curly braces introduce a new block and also a new scope.
    {
      // Variables defined in a block are not visible outside
      final int y = 4;
      System.out.println(y);
    }
    //    System.out.println(y); // Tip: try commenting this out
  }
}
