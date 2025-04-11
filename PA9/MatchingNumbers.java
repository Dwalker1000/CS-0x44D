package PA9;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 11/7/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Displays stats of a randomly rolled "dice" across x trials

import java.util.*;
import java.util.Scanner;

public class MatchingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] diceStats = new int[5];

        int seed = getSeed(scan);
        Random rand = new Random(seed);

        //gets amount of rolls and runs the simulation
        do{
            int rolls = getRolls(scan);
            diceStats = addVals(diceStats, dieRoll(rolls, rand));
            System.out.println();
        }while(doLoop(scan));
        stats(diceStats);
    }

    /**
     * gets seed for the random number from the user and makes sure it is a positive value
     * @param scan  scanner to obtain the users seed
     * @return      a positive seed from the user
     */
    public static int getSeed(Scanner scan) {
        System.out.print("Enter a seed: ");
        int seed = scan.nextInt();

        //makes sure seed in positive
        while (seed < 1){
            System.out.print("Not a positive number, try again: ");
            seed = scan.nextInt();
        }
        return seed;
    }

    /**
     * Gets the amount of rolls the user wants to happen
     * @param scan  scanner to obtain the users seed
     * @return      a positive int from the user related to amount of dice rolls
     */
    public static int getRolls(Scanner scan) {
        System.out.print("Enter number of rolls: ");
        int rolls = scan.nextInt();

        //makes sure rolls is positive
        while (rolls < 1){
            System.out.print("Not a positive number, try again: ");
            rolls = scan.nextInt();
        }
        System.out.println();
        return rolls;
    }

    /**
     * Controls weather the user wants to keep running the simulation
     * @param scan  scanner used to get persons input
     * @return      returns decision as a boolean statement
     */
    public static boolean doLoop(Scanner scan){
        System.out.print("Would you like to run experiment again (Y/N)? ");
        String input = scan.next().toUpperCase();
        return input.equals("Y");
    }

    /**
     * Simulates the die being rolled and adds to the stats that we want to collect
     * @param rolls How many rolls the user wants to occur
     * @param rand  The random variable used to randomize the dice
     * @return      Returns an array with the information of the collected stats
     */
    public static int[] dieRoll(int rolls, Random rand){
        int three = 0, four = 0, five = 0, twoThree = 0;

        //loop for each roll
        for (int i = 0; i < rolls; i++) {
            int[] dieRead = new int[6];
            boolean twoCheck = false, threeCheck = false;

            //loop for the dice simulation
            for (int j = 0; j < 5; j++){
                dieRead[rand.nextInt(6)] += 1;
            }

            //collects stats based on the simulation data
            for (int x = 0; x < dieRead.length; x++){
                if (dieRead[x] == 2){
                    twoCheck = true;
                }
                if (dieRead[x] == 3){
                    three++;
                    threeCheck = true;
                }
                if (dieRead[x] == 4){
                    four++;
                }
                if (dieRead[x] == 5){
                    five++;
                }
            }
            if (twoCheck && threeCheck){
                twoThree ++;
            }
        }

        //sorry had to do this because of the function length limit
        //prints stats and returns an array with the information from the simulation
        stats(new int[] {twoThree, three, four, five, rolls});
        return new int[] {twoThree, three, four, five, rolls};
    }

    /**
     * Prints stats based on the inputted array of information
     * @param arr   array obtained from the dice rolls
     */
    public static void stats(int[] arr){
        String strR = "rolls", strT = "times", strFo = "times", strFi = "times", strTT = "times";

        //word variations
        if (arr[4] == 1){
            strR = "roll";
        }
        if(arr[0] == 1){
            strTT = "time";
        }
        if(arr[1] == 1){
            strT = "time";
        }
        if(arr[2] == 1){
            strFo = "time";
        }
        if(arr[3] == 1){
            strFi = "time";
        }

        //printed information
        System.out.println("After " + arr[4] + " " + strR + ":");
        System.out.printf("- Three dice matching: %d %s (%.1f%%)\n",
                arr[1], strT, ((double)arr[1]) / arr[4] * 100);
        System.out.printf("- Four dice matching: %d %s (%.1f%%)\n",
                arr[2], strFo, ((double)arr[2]) / arr[4] * 100);
        System.out.printf("- Five dice matching: %d %s (%.1f%%)\n",
                arr[3], strFi, ((double)arr[3]) / arr[4] * 100);
        System.out.printf("- Three and two dice matching: %d %s (%.1f%%)\n",
                arr[0], strTT, ((double)arr[0]) / arr[4] * 100);
    }

    /**
     * adds values to a singular array for the final print
     * @param totalStats    Array of all the added stats
     * @param newStats      The inputted array of the stats found during the simulation
     * @return              The new array with the combined information
     */
    public static int[] addVals(int[] totalStats, int[] newStats){
        for (int i = 0; i < totalStats.length; i++){
            totalStats[i] += newStats[i];
        }
        return totalStats;
    }
}
