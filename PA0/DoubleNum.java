package PA0;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 8/26/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: allows the user to input a number and then doubles it

import java.util.Scanner;

public class DoubleNum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num;

        System.out.print("Enter num: ");
        num = console.nextInt();

        System.out.println("num doubled is: " + (2 * num));
    }
}