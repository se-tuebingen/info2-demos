package main;

import java.util.Scanner;

public class PrimeFactors {
    /**
     * Das Programm berechnet in einer Methode die Primfaktorenzerlegung einer Zahl.
     *
     * Es werden gezeigt - Rekursion - Teile-und-Herrsche - Transformation in
     * iterative Algorithmen
     *
     * Autor:
     */
    public static void main(String[] args) {
        int n; // Parameter for die Fibonacci-Funktion
        Scanner scan = new Scanner(System.in);

        System.out.print("Positiver Wert fuer n: ");
        n = scan.nextInt();
        while (n < 0) {
            System.out.print("Der Parameter muss positiv oder 0 sein. " + "Bitte noch einmal ... ");
            n = scan.nextInt();
        } // Wert fuer n >= 0 ...

        System.out.println("Primfaktorenzerlegung fuer " + n + " = ");

        factors(n);

        System.out.println("Primfaktorenzerlegung fuer " + n + " (iterativ) = ");
        //factorsIter(n);

        scan.close();
    } // end main

    /**
     * Rekursive Methode zur Berechnung der Primfaktorzerlegung
     */
    static void factors(int n) {

        if (n == 1) {
            return;
        }
        // Looks for the next divisor of n
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + " * ");
                factors(n / i);
                return;
            }
        }
        // Set break point here to see stack status
        System.out.println(n);

    }

    /**
     * Iterative Methode fuer die Primfaktorenzerlegung
     */
    static void factorsIter(int n) {

        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " * ");
                    n = n / i;
                    break;
                }
            }
        }

    }

} // end class PrimeFactors