public class Types {

  public static void main(String[] args) {
    // Java has a static type system.
    // This way errors can be found at "compile time" by Java's type
    // checker and we do not have to run the program to find them.

    // Java distinguishes between primitive types like
    final int   a = 1;
    final long  b = 144231L;
    final short c = 12;
    final byte  d = 17;

    final double e = 14d;
    final float   f = 14f;

    final char    g = '\n';
    final boolean h = true;

    // and reference types like
    final String i = "Hello";

    // Note that `void` as annotated on `main` is not really a
    // type but marks that `main` does not return any value.
    // It is thus more of an "arity", than a type.

    // Being a statically typed language means that certain errors
    // are found without running the program. For example comparing
    // a number to a boolean does not make sense and is reported by
    // the type checker.

    //    14 > true

    // Tip: Comment out the above code to see an error.
  }

}
