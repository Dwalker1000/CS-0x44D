package PA2;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/6/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: calculates cost to drive the car different distances

import java.util.Scanner;

public class CarCosts {
    public static void main(String[] args) {
        double carEfficiency, gasCost;
        Scanner scan = new Scanner(System.in);

        //obtain values from user
        System.out.print("Enter the car's efficiency: ");
        carEfficiency = scan.nextDouble();
        System.out.print("Enter the cost of fuel: ");
        gasCost = scan.nextDouble();

        //calculates cost to drive the car and displays the value
        System.out.printf("The cost to drive this car for 10 miles is $%.2f\n"
                , (gasCost / carEfficiency) * 10);
        System.out.printf("The cost to drive this car for 50 miles is $%.2f\n"
                , (gasCost / carEfficiency) * 50);
        System.out.printf("The cost to drive this car for 400 miles is $%.2f\n"
                , (gasCost / carEfficiency) * 400);
    }  // End of main method.
}  // End of PA2.CarCosts class.
