package PA1;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 8/30/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description:

import java.util.Scanner;

public class BasicIO {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //gets first integer
        System.out.print("Enter an integer: ");
        int intOne = scan.nextInt();

        //multiples the first int by 3/square's the first int
        System.out.println("The triple of " + intOne + " is " + (intOne *3));
        System.out.println("The square of " + intOne + " is " + (int)(Math.pow(intOne,2)));
        System.out.println("Voila!");

        //gets second integer
        System.out.print("Enter another integer: ");
        int intTwo = scan.nextInt();

        //adds the two int's/multiplies the two int's
        System.out.println("(" + intOne + " + " + intTwo + ") is " + (intOne + intTwo));
        System.out.println("(" + intOne + " * " + intTwo + ") is " + (intOne * intTwo));
        System.out.println("That is all!");
    }
}
