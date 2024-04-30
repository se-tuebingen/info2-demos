import java.util.Scanner;

public class DynamicArrays {
  public static void main(String[] args) {
    resizable();
  }

  public static void nonResizable() {
    final var input = new int[100];
    var length = 0;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      var next = scanner.nextInt();
      if (next < 0) break;
      input[length] = next;
      length = length + 1;
    }

    System.out.println("The numbers are:");
    for (int i = 0; i < length; i = i + 1) {
      System.out.println(input[i]);
    }
  }
  public static void resizable() {
    var capacity = 10;
    var input = new int[capacity];
    var length = 0;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      var next = scanner.nextInt();
      if (next < 0) break;

      if (length >= capacity) {       // (1) recognize there is not enough space
        capacity = capacity * 2;      // (2) determine required capacity
        var temp = new int[capacity]; // (3) create a new array with the new capacity
        // (4) copy elements
        System.arraycopy(input, 0, temp, 0, input.length);
        input = temp;                 // (5) replace old array with new (larger) array
      }
      input[length] = next;
      length = length + 1;
    }

    System.out.println("The numbers are:");
    for (int i = 0; i < length; i = i + 1) {
      System.out.println(input[i]);
    }
  }
}
