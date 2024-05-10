package main;

import java.util.Arrays;
// Class to illustrate the pass by reference in methods
public class ArrayFunction {
    //static void clampToZero(final float[] arr) {
    static void clampToZero(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {1, -1, 2, -3};
        clampToZero(arr);
        System.out.println(Arrays.toString(arr));
    }
}
