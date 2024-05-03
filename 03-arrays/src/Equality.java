import java.util.Arrays;

record Person(String name, int age) {}

public class Equality {

  public static void main(String[] args) {

    // Records
    // -------
    System.out.println("\nRECORDS");

    // The following example illustrates "structural equality" of records
    // in Java.
    final var p1 = new Person("tester", 12);
    var p2 = new Person("tester", 12);

    // Two records are structurally equal, if their components are equal
    System.out.println(p1.equals(p2));

    // while their references differ:
    System.out.println(p1 == p2);


    // Arrays
    // ------
    System.out.println("\nARRAYS");

    // Arrays implement `equals` by comparing the references (not the contents!)
    final int[] arr1 = { 1, 2, 3 };
    final int[] arr2 = { 1, 2, 3 };

    System.out.println(arr1.equals(arr2));
    System.out.println(arr1 == arr2);

    // We can use the function Arrays.equals for a structural comparison on arrays
    System.out.println(Arrays.equals(arr1, arr2));

    // Strings
    // -------
    System.out.println("\nSTRINGS");
    // Another example of reference types are strings. They are also compared by reference
    // equality:
    final var str1 = new String(new byte[] { 'a', 'b', 'c' });
    final var str2 = new String(new byte[] { 'a', 'b', 'c' });
    System.out.println(str1 == str2);

    // Using `equals` compares their contents:
    System.out.println(str1.equals(str2));

    // TIPP: Use Jump-to-definition and look at the different implementations of `equals`.
  }
}

