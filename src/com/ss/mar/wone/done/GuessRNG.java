package com.ss.mar.wone.done;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A "mini-game" using a RNG with user input guessing the selected number
 * @author Mosaab
 */
public class GuessRNG {
    /**
     * Takes input, containing game logic
     * @param args
     */
    public static void main(String[] args) {
        /*
        * We use ThreadLocalRandom because the "older" method of using util.Random can cause contention
        * Contention can allow seed syncing which in turn can cause the random number to be guessed
        * This method makes sure that the RNG is used by multiple threads, so seed syncing is difficult/impossible
        * Source: https://stackoverflow.com/a/363692
        * */
        int randomNumber = ThreadLocalRandom.current().nextInt(1, 100+1);

        // Initializing scanner
        Scanner scan = new Scanner(System.in);

        // Initial prompt
        System.out.println("I have chosen a number between 1-100, can you guess what it is?");
        int chances = 5;
        do {
            // Wait for user input
            int guess = scan.nextInt();

            // Input must be within [1-100]
            if (guess > 100 || guess < 1) {
                System.out.println("Sorry, you must enter a number in the range of [1-100]. Try again.");
                continue;
            }

            // Check if input is within +-10 of the RNG
            if (guess >= randomNumber -10 && guess <= randomNumber +10) {
                System.out.println("Nicely done! The number was "+ randomNumber);
                break;
            }
        } while (--chances > 0);

        // Check if the user ran out of chances
        if (chances == 0) {
            System.out.println("Sorry, the number was "+ randomNumber + ". Better luck next time!");
        }
    }
}
