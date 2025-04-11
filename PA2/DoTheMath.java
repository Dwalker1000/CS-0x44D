package PA2;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/6/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: preforms mathematical operations based on the given inputs

import java.util.Scanner;

public class DoTheMath {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x,y,z;

        //gets input values
        System.out.print("Enter value for x: ");
        x = scan.nextDouble();
        System.out.print("Enter value for y: ");
        y = scan.nextDouble();
        System.out.print("Enter value for z: ");
        z = scan.nextDouble();

        //power printouts
        System.out.println("The result of x to the power y is " + Math.pow(x,y));
        System.out.println("The result of x to the power (y to the power z) is "
                + Math.pow(x,Math.pow(y,z)));

        //Absolute Value |x|
        System.out.println("The absolute value of x is " + Math.abs(x));

        //Square root of (x*y)^z
        System.out.println("The square root of (x * y) to the power z is "
                + Math.sqrt(Math.pow(x*y,z)));

    }  // End of main method.
}  // End of DoTheMath class.
