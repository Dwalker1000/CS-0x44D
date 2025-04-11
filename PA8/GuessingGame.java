package PA8;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/30/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: guessing game where users finds random number within limited attempts

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    // Constant for the maximum number the user can guess.
    private static final int MAX = 100;  // DO NOT CHANGE

    public static void main(String[] args) {
        /***** DO NOT EDIT THE CODE BELOW *****/

        Scanner console = new Scanner(System.in);
        Random random = new Random();

        printHeading("Game setup");

        // Get seed from user.
        int seed = getSeed(console);

        // Set seed for random number generator.
        random.setSeed(seed);

        /***** DO NOT EDIT THE CODE ABOVE *****/

        // Get number of guesses and validate it
        int maxGuesses = getMaxGuesses(console);

        // Display game instructions.
        printInstructions(maxGuesses);

        // Generate the random number
        int mysteryNumber = random.nextInt(MAX) + 1;

        // Start game
        playGame(console, mysteryNumber, maxGuesses);
    }

    /**
     * Prompts the user for the maximum number of guesses (1-100)
     * @param console   Scanner object for console input
     * @return          A validated integer for the maximum number of guesses
     */
    public static int getMaxGuesses(Scanner console) {
        System.out.print("Enter maximum guesses allowed: ");
        while (!console.hasNextInt()) {
            System.out.print("Not in the range 1-100, try again: ");
            console.next();
        }
        int maxGuesses = console.nextInt();

        //makes sure maxGuesses is between 1 and 100
        while (maxGuesses < 1 || maxGuesses > MAX) {
            System.out.print("Not in the range 1-100, try again: ");
            maxGuesses = console.nextInt();
        }

        return maxGuesses;
    }

    /**
     * Displays the instructions for the game
     * @param maxGuesses The maximum number of guesses allowed
     */
    public static void printInstructions(int maxGuesses) {
        System.out.println("\nPlay game");
        System.out.println("=========\n");
        System.out.println("I'll pick a number between 1-" + MAX + ". You try to guess it.");
        System.out.println("If you don't guess it right, I'll give you a hint to help you.");
        if (maxGuesses == 1){
            System.out.println("You get " + maxGuesses + " guess. Let's play!\n");
        }
        else{
            System.out.println("You get " + maxGuesses + " guesses. Let's play!\n");
        }
        System.out.println("I am thinking of a number between 1 and 100.\n");
    }

    /**
     * Plays the  game by prompting user to guess the random number
     * @param console       Scanner object for console input
     * @param mysteryNumber The randomly generated number the user must guess
     * @param maxGuesses    The maximum number of guesses allowed for the user
     */
    public static void playGame(Scanner console, int mysteryNumber, int maxGuesses) {
        int guessCount = 0;
        boolean correctGuess = false;

        while (guessCount < maxGuesses && !correctGuess) {
            guessCount++;
            int guess = getUserGuess(console, guessCount);
            correctGuess = guessCheck(guess, mysteryNumber, guessCount, maxGuesses);
        }

        if (!correctGuess) {
            //had to get under 100 char limit :(
            int num = mysteryNumber;
            System.out.println("Sorry, you lose. The number I was thinking of was " + num + ".");
        }
    }

    /**
     * preforms checks to see if user got the num or not
     * @param guess             what the user guesses
     * @param mysteryNumber     num user is trying to guess
     * @param guessCount        how many guesses the user has made
     * @param maxGuesses        how many guesses the user has (total)
     * @return                  weather they guessed correct or not
     */
    public static boolean guessCheck(int guess, int mysteryNumber, int guessCount, int maxGuesses){
        if (guess == mysteryNumber) {
            if (guessCount == 1){
                System.out.println("Correct! You got it in " + guessCount + " guess.");
            }
            else{
                System.out.println("Correct! You got it in " + guessCount + " guesses.");
            }
            return true;
        } else if (guessCount != maxGuesses) {
            System.out.println("Sorry, that guess is incorrect.");
            if (guess < mysteryNumber) {
                System.out.println("The number I am thinking of is higher.");
            } else {
                System.out.println("The number I am thinking of is lower.");
            }
        }
        return false;
    }

    /**
     * Prompts user for guess and validates that guess is between 1-100
     * @param console       Scanner object for console input
     * @param guessCount    The current guess attempt count
     * @return              An integer representing users guess
     */
    public static int getUserGuess(Scanner console, int guessCount) {
        System.out.print("Guess " + guessCount + ", enter your guess: ");

        while (!console.hasNextInt()) {
            System.out.print("Not in the range 1-100, try again: ");
            console.next();
        }

        int guess = console.nextInt();

        while (guess < 1 || guess > MAX) {
            System.out.print("Not in the range 1-100, try again: ");
            while (!console.hasNextInt()) {
                System.out.print("Not in the range 1-100, try again: ");
                console.next();
            }
            guess = console.nextInt();
        }

        return guess;
    }

   /**
    * Prints a heading based on the passed string.
    *
    * THIS METHOD PROVIDED TO YOU. DO NOT MODIFY.
    *
    * @param  heading The heading to print.
    */
   public static void printHeading(String heading) {
      System.out.println(heading);

      for (int i = 0; i < heading.length(); ++i) {
         System.out.print("=");
      }

      System.out.println();
      System.out.println();
   }

   /**
    * Prompts and returns the random number generator seed.
    *
    * THIS METHOD PROVIDED TO YOU. DO NOT MODIFY.
    *
    * @param  console A Scanner object for console (or keyboard) input.
    * @return         The seed to set the random number generator.
    */
    public static int getSeed(Scanner console) {
        System.out.print("Enter a seed: ");
        int seed = console.nextInt();
        return seed;
    }
}
