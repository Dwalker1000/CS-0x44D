package PA7;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/25/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Obtains a valid String, Vowel, and Average from the user

import java.util.Scanner;

public class ValidateMe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        WordCheck(scan);
        VowelCheck(scan);
        AverageCheck(scan);
    }

    /**
     * Obtains String from user and prints it out
     * @param scan  Input scanner for the string
     */
    public static void WordCheck(Scanner scan){
        System.out.print("Enter a string: ");
        String word = scan.nextLine();

        //checks for the valid input
        while (word.isEmpty()) {
            System.out.print("Nothing entered, try again: ");
            word = scan.nextLine();
        }
        System.out.println("You entered a valid string of " + word);
    }

    /**
     * Obtains Vowel from user and prints it out
     * @param scan  Input scanner for the string
     */
    public static void VowelCheck(Scanner scan){
        String vowel;
        System.out.print("Enter a vowel: ");

        //checks for the valid input
        do {

            vowel = scan.nextLine().trim().toUpperCase();
            if (vowel.isEmpty() || !vowel.matches("[AEIOU]")) {
                System.out.print("Not a vowel, try again: ");
            }
        } while (vowel.isEmpty() || !vowel.matches("[AEIOU]"));

        System.out.println("You entered a valid vowel of " + vowel);
    }

    /**
     * Obtains Average from user and prints it out
     * @param scan  Input scanner for the double
     */
    public static void AverageCheck(Scanner scan) {
        double average = -1;
        String input;
        boolean check = false;

        System.out.print("Enter an average: ");

        while (!check) {
            input = scan.nextLine().trim();

            // Check if input is empty
            if(!input.isEmpty()) {
                Scanner strScan = new Scanner(input);

                if (strScan.hasNextDouble()) {
                    average = strScan.nextDouble();

                    // Validate if the double is within the specified range
                    if (average >= -0.0001 && average <= 1.0001) {
                        check = true;
                    }
                }
            }
            if (!check){
                // If input is invalid, prompt the user to try again
                System.out.print("Average must be between 0-1 (inclusive), try again: ");
            }
        }

        // Output the validated average with two decimal precision
        System.out.printf("You entered a valid average of %.2f\n", average);
    }

}
