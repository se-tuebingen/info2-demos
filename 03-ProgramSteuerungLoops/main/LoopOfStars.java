package main;

public class LoopOfStars {
        public static void main(String[] args) {
            final int MAX_LEVEL=10;
            for (int i=0;i<MAX_LEVEL;i++) {
                for (int j = 0; j < MAX_LEVEL - i; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
    }

