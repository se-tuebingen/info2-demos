package main;
// This class implements adding numbers up to N. Careful, there might be a bug :-)
/*
 * Author: @Gerard Pons-Moll
 */

public class SumToN {
    public static void main(String[] args) {
        int result = 0;
        final int N = 100;
        for (int i = 0; i < N; i++) {
            result += i;
        }
        // Verify that the sum was correclty computed
        if (result == N * (N + 1) / 2) {
            System.out.print("The computation was correct \n");
            System.out.print("The result is " + result);
        }else{
            System.out.print("Bug detected. Can you find the mistake?");
        }
    }
}
