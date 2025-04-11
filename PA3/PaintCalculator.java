package PA3;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/13/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: calculates the total number of paint cans needed to paint a wall

import java.util.Scanner;
import java.lang.Math;

public class PaintCalculator {
    static int NUM_WALLS = 4;
    static int COVERAGE_OF_SINGLE_GALLON = 350;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Get wall height and width.
        double wallHeight = getWallHeight(console);
        double wallWidth = getWallWidth(console);

        // More code goes here.
        double wallArea = calcWallArea(wallHeight, wallWidth);
        double gallonsPaintNeeded = calcGallons(wallArea);
        displayResults(wallArea, gallonsPaintNeeded);
    }

    /**
     * Prompts and returns the wall height.
     *
     * THIS METHOD PROVIDED TO YOU. DO NOT MODIFY.
     *
     * @param  console A Scanner object for console (or keyboard) input.
     * @return         The wall height in feet.
     */
    public static double getWallHeight(Scanner console) {
        System.out.print("Enter wall height (feet): ");
        double wallHeight = console.nextDouble();
        return wallHeight;
    }

    /**
     * Prompts and returns the wall width.
     *
     * THIS METHOD PROVIDED TO YOU. DO NOT MODIFY.
     *
     * @param  console A Scanner object for console (or keyboard) input.
     * @return         The wall width in feet.
     */
    public static double getWallWidth(Scanner console) {
        System.out.print("Enter wall width (feet): ");
        double wallWidth = console.nextDouble();
        return wallWidth;
    }

    /**
     * calculates and returns the wall area.
     * @param wallHeight is the height of the given wall.
     * @param wallWidth is the width of the given wall.
     * @return The wall area in square feet.
     */
    public static double calcWallArea(double wallHeight, double wallWidth){
        return wallHeight * wallWidth;
    }

    /**
     * calculates and returns the total gallons needed.
     * @param wallArea is the Area of the given wall.
     * @return How many gallons of paint is needed.
     */
    public static double calcGallons(double wallArea){
        return ((NUM_WALLS * wallArea)/COVERAGE_OF_SINGLE_GALLON);
    }

    /**
     * prints out the total area, the amount of paint and the number of cans needed for the wall.
     * @param wallArea is the Area of the given wall.
     * @param gallonsPaintNeeded is the amount of paint needed to cover the wall.
     */
    public static void displayResults(double wallArea, double gallonsPaintNeeded){
        System.out.printf("The wall area is %.1f square feet\n", wallArea);
        System.out.printf("The paint needed (assuming 4 walls) " +
                          "is %.2f gallons\n", gallonsPaintNeeded);
        System.out.println("The number of cans to purchase is "
                          + (int)Math.ceil(gallonsPaintNeeded) + " can(s)");
    }
}
