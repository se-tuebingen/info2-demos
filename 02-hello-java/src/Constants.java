public class Constants {

  public static void main(String[] args) {
    // Like in Racket, Java supports constant definitions
    // (define size (* 2 2 2 2 2 2 2 2))
    final int size = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2;

    // The right-hand side expression is first evaluated (here to 256)
    // and then bound to `size`.

    // Like in Racket, we can refer to bound variables by their name:
    System.out.println( size );
  }

}
