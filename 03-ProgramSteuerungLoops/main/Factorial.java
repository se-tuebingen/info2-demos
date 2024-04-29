package main;
// This class implements 3 different ways to compute the factorial of a number
/*
 * Author: @Gerard Pons-Moll
 */
public class Factorial {
    public static void main(String[] args) {
        //int result = factorialWhile(7);
        //int result = factorialFor(7);
        int result = factorialRecursive(7);
        System.out.print(result);
    }
    public static int factorialWhile(int number){
        int result = number;
        while (number > 1){
            number -= 1;
            result *= number;
        }
        return result;
    }
    public static int factorialFor(int number){
        int result = 1;
        for (int k = 1; k <= number; k++){
            result *= k;
        }
        return result;
    }
    public static int factorialRecursive(int n){
        if (n == 1)
            return n;
        else
            return n*factorialRecursive(n-1);
    }
}
