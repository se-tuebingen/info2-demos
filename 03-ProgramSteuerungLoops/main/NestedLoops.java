package main;


public class NestedLoops {
    
    public static void main(String[] args) {

        // Nested loop
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++ ) {
                System.out.print("" + i + j+ " ");
            }
            System.out.println();
        }
        System.out.println();
        
        // Same functionality with one loop
        for (int k = 0; k < (10 * 5); k++) {
            int i = k / 10;
            int j = k % 5;
            System.out.print("" + i + j + " ");

            if (j == 4) {
                System.out.println();
            }
        }
        
         
        
    }
    
}