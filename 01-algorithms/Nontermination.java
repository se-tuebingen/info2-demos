import java.util.Scanner;

/**
 * This is an example illustrating non-terminating behavior of
 * interactive processes.
 */
public class Nontermination {
    public static void main(String[] args) {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter a number: ");
            sum += scanner.nextInt();
            System.out.println("Sum so far: " + sum);
        }
    }
}