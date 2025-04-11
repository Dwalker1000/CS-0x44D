package PA1;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 8/30/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.


// Program description: Asks the user for their name and greets them with a hello
import java.util.Scanner;

public class HelloThere {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = scan.next();
        System.out.println("Hello " + name + "!");
    }  // End of main method.
}  // End of HelloThere class.
