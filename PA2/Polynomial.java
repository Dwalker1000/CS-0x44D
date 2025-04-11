package PA2;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/8/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: calculates the canonical form of the polynomial based on the users input


import java.util.*;

public class Polynomial {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int root1, root2;

        //gets the user input for the two roots
        System.out.print("Enter first root: ");
        root1 = console.nextInt();

        System.out.print("Enter second root: ");
        root2 = console.nextInt();

        //prints the canonical form of the polynomial
        System.out.print("The polynomial is ");
        System.out.println("x^2 + " + -(root1 + root2) + "x + " + (root1 * root2));
    }
}
