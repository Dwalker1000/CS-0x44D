package PA4;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/25/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Decodes certain SMS abbreviations.

import java.util.Scanner;

public class SMSTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //obtain the abbreviation from the user
        String abbreviation = getAbbreviation(scan);

        //decodes the abbreviation
        abbreviation = decodeAbbreviation(abbreviation);

        //displays the decoded abbreviations
        printAbbreviation(abbreviation);
    }

    /**
     * Prompts and returns the SMS abbreviation.
     * @param  console A Scanner object for console (or keyboard) input.
     * @return         The Capitalized version of the Abbreviation.
     */
    public static String getAbbreviation(Scanner console){
        System.out.print("Enter SMS abbreviation: ");
        String abbreviation = console.next();
        return abbreviation.toUpperCase();
    }

    /**
     * Returns the decoded SMS abbreviation.
     * @param  userString The SMS message that the user provided.
     * @return         The decoded Abbreviation.
     */
    public static String decodeAbbreviation(String userString){
        if (userString.equals("BFF")){
            return ("Best Friends FOREVER!!! :-)");
        }
        else if (userString.equals("BTE")){
            return ("Blew The Exam :-(");
        }
        else if (userString.equals("STT")) {
            return ("Spill The Tea ;-)");
        }
        return ("<unknown abbreviation>");
    }

    /**
     * Prints the decoded SMS abbreviation.
     * @param  result The decoded SMS abbreviation.
     */
    public static void printAbbreviation(String result){
        System.out.println("The translation is " + result);
    }
}
