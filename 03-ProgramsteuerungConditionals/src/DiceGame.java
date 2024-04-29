package main;
import java.util.Random;

// This class implements a simple dice gamble game.
// The idea shown in class is how to write the code from scratch testing every small part. Try it!
/*
 * Author: @Gerard Pons-Moll
 */
public class DiceGame {
    public static void main(String[] args) {
        // Dice Game
        // 1 -> win = -10
        // 6 -> win =  10
        // 100 throws
        // Requirements: Random number generator
        Random randObj = new Random();
        int diceNumber = randObj.nextInt(6);
        int win = 0;
        // I play until I make at least 100 Euros
        while (win < 100) {
            // A new game starts. 100 throws of a dice
            for (int i = 0; i < 100; i++) {
                diceNumber = randObj.nextInt(6) + 1;
                if (diceNumber < 2) {
                    win -= 10;
                } else if (diceNumber == 6) {
                    win += 10;
                }
            }
            System.out.println(win);
        }
        System.out.println("The final win is:" + win);


    }
}
