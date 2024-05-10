package main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The program takes a finite number of digits from the user and computes their product.
 *
 * This illustrates a cleaner implementation with functions (done in class). See Product.
 *
 *     @Author: Gerard Pons-Moll
 */
public class ProductWithMethod {

    static Scanner sc = new Scanner(System.in);

    public static int getNextPostiveNumber() {
        int N;
        do {
            N = sc.nextInt();
            if (N <= 0) {
                System.out.println("please enter positive number! ");
            }
        } while (N <= 0);
        return N;
    }
    public static int getNextNegativeNumber() {
        int N;
        do {
            N = sc.nextInt();
            if (N > 0) {
                System.out.println("please enter negative number! ");
            }
        } while (N > 0);
        return N;
    }

    public static int productArray(int[] myArr) {
        int product = 1;
        for (int i = 0; i < myArr.length; i++) {
            product *= myArr[i]; // product = product * myArr[i];
        }
        return product;
    }

    public static void main(String[] args) {
        // Before writing code, write the operations needed:
        // 1) Get N from input getNextPositiveNumber
        // 2) Fill array with getNextPositiveNmber
        // 3) Compute product

        // 1) N
        System.out.println("Please introduce N: ");
        int arrLength = getNextPostiveNumber();

        // 2) Fill in vals
        int[] arr = new int[arrLength];
        System.out.println("Please introduce numbers now: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getNextPostiveNumber();
            // arr[i] = getNextNegativeNumber(); only 1 line of code change
        }
        System.out.println(Arrays.toString(arr)); // Check!

        // 3) compute product of numbers
        System.out.println(productArray(arr));
    }
}
