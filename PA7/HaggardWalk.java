package PA7;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/25/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Simulates Haggard's Steps seeing if he falls off a cliff or goes to sleep

import java.util.Random;
import java.util.Scanner;

public class HaggardWalk {
    //Cardinal Directions
    private static final int NORTH = 0;
    private static final int SOUTH = 1;
    private static final int EAST = 2;
    private static final int WEST = 3;

    //movement vars
    private static final int START_X = 1;
    private static final int START_Y = 0;
    private static final int MAX_STEPS = 10;

    public static void main(String[] args) {
        /***** DO NOT EDIT THE CODE BELOW *****/
        
        Scanner console = new Scanner(System.in);
        Random random = new Random();
        
        // Get seed from user.
        int seed = getSeed(console);
        
        // Set seed for random number generator.
        random.setSeed(seed);
        
        /***** DO NOT EDIT THE CODE ABOVE *****/
        runSimulations(random);
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

    /**
     * Runs the 5 simulations fo Haggard's walk
     * @param random        Object used to generate steps
     */
    public static void runSimulations(Random random){
        int asleepCount = 0;
        int cliffCount = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("=== Simulation " + i + " ===");
            boolean fellOffCliff = simulateWalk(random);

            if (fellOffCliff) {
                cliffCount++;
            } else {
                asleepCount++;
            }
        }

        // Print final statistics
        printFinalStatistics(asleepCount, cliffCount);
    }

    /**
     * Simulates a single walk
     * @param random    Object used to generate steps
     * @return          True/False on weather Haggard fell off the cliff
     */
    public static boolean simulateWalk(Random random) {
        int x = START_X;
        int y = START_Y;

        for (int step = 1; step <= MAX_STEPS; step++) {
            System.out.println("About to take step no. " + step);
            System.out.println("Haggard's current position is (" + x + ", " + y + ")");

            //obtains Direction
            int direction = random.nextInt(4);
            String stepDirection = "";

            //what direction he went
            if (direction == NORTH) {
                stepDirection = "One step NORTH";
                y++;
            } else if (direction == SOUTH) {
                stepDirection = "One step SOUTH";
                y--;
            } else if (direction == EAST) {
                stepDirection = "One step EAST";
                x++;
            } else {
                stepDirection = "One step WEST...be careful Haggard";
                x--;
            }

            System.out.println(stepDirection);
            System.out.println("Haggard's new position is (" + x + ", " + y + ")");

            // Check if Haggard fell off the cliff
            if (x < -1) {
                System.out.println("\nOh no! Haggard stepped off the cliff!\n");
                return true;
            }
        }

        // Fell asleep
        System.out.println("\nHaggard safely fell asleep after taking 10 steps.\n");
        return false;
    }

    /**
     * Prints final Stats after sim finishes
     * @param fellAsleepCount       Times Haggard fell asleep
     * @param fellOffCliffCount     Times Haggard fell off cliff
     */
    public static void printFinalStatistics(int fellAsleepCount, int fellOffCliffCount) {
        System.out.println("=== Final statistics ===");
        System.out.println("Total number of simulations run: 5");
        System.out.println("Fell asleep after 10 steps: " + fellAsleepCount + " times");
        System.out.println("Stepped off the cliff: " + fellOffCliffCount + " times");
    }
}
