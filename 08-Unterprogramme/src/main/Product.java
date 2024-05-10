package main;

import java.util.Arrays;
import java.util.Scanner;
/**
 * The program takes a finite number of digits from the user and computes their product.
 *
 * This illustrates a "bad implementation without usage of functions. See product with MEthod
 *
 *     @Author: Gerard Pons-Moll modified from Hendrik Lensch
 */

public class Product {
    public static void main(String[] args) {

        // Notice how much code repetion.
        // Bad for multiple reasons
        // 1) Long and hard to understand
        // 2) Hard to modify and mantain
        Scanner sc = new Scanner(System.in);
        int N = 0;
        System.out.println("Please introduce the number of numbers to multiply!");
        do {
            N = sc.nextInt();
            if (N < 0) {
                System.out.println("Please introduce a positive number!");
            }
        } while (N <= 0);


        int[] arr = new int[N];

        System.out.println("Please introduce N-1 numbers!");

        for (int i = 0; i < arr.length; i++) {
            do {
                arr[i] = sc.nextInt();
                if (arr[i] < 0) {
                    System.out.println("Introduce positive number");
                }
            } while (arr[i] < 0);
        }
        System.out.println(Arrays.toString(arr));
        int product = 1;

        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
        }
        System.out.println("The product equals " + product);
    }

}
