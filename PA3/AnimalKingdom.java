package PA3;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/14/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: prints out animal faces

public class AnimalKingdom {
    public static void main(String[] args) {
        printMessage();
        bull();
        bull();
        dog();
        dog();
        fox();
        fox();
        lion();
        lion();
    }

    /**
     * Prints an introductory message.
     */
    public static void printMessage() {
        System.out.println("This program will print various animal faces.");
        System.out.println();
    }

    /**
     * Prints a Bull.
     */
    public static void bull() {
        System.out.println("((___))");
        System.out.println("-(. .)-");
        System.out.println("(o___o)\n");
    }

    /**
     * Prints a Dog.
     */
    public static void dog() {
        System.out.println("  -___-");
        System.out.println("\\/). .(\\/");
        System.out.println("  (_o_)\n");
    }

    /**
     * Prints a Fox.
     */
    public static void fox() {
        System.out.println("(\\,,,/)");
        System.out.println(" (. .)");
        System.out.println("  \\_/\n");
    }

    /**
     * Prints a Lion.
     */
    public static void lion() {
        System.out.println(" ^,,,^");
        System.out.println(" <. .>");
        System.out.println("==(Y)==\n");
    }
}
