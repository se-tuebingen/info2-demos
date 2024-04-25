public class Expressions {

  public static void main(String[] args) {

    // please ignore this for now:
    int x = 7;

    // Many expressions in Java are not unlike those in Racket / BSL
    // Here we show different expressions (and how they evaluate)
    // by printing them.

    //        A Statement
    // vvvvvvvvvvvvvvvvvvvvvvvvv
    System.out.println( 1 + 1 );
    //                 ^^^^^^^
    //              An Expression


    // Strings are expressions
    System.out.println( "Hello World" );


    // Function calls are expressions
    System.out.println( add(1, 2) );

    // Comparisons are expressions
    System.out.println( add(1, 2) );

    // Variable references are expressions
    System.out.println( x );

    // Booleans are expressions
    System.out.println( true );
    System.out.println( false );
    System.out.println( !true );

    // Comparisons are expressions
    System.out.println( x > 0 );

    // Strings can be concatenated
    System.out.println( "Hello" + " " + "World!" );

    // Arithmetic expressions are written infix
    System.out.println( x + 1 );
    System.out.println( x * 2 );

    // Arithmetic expressions follow the typical precedence
    System.out.println( x * 2 + 1 );
    System.out.println( (x * 2) + 1 );
  }


  // Function defininition. Please ignore for now.
  public static int add(int x, int y) {
    return x + y;
  }
}
