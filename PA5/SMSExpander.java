package PA5;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/30/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Replaces known SMS abbreviations with there non-abbreviated form.

import java.util.Scanner;

public class SMSExpander {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = getText(scan);
        String expandedMessage = expandAbbreviation(message);
        printExpanded(expandedMessage);
    }

    /**
     * obtains the users sms message
     * @param console   Scanner object for user input
     * @return  The users sms message
     */
    public static String getText(Scanner console){
        System.out.print("Enter text to decode: ");
        return console.nextLine();
    }

    /**
     * Replaces the know abbreviations with their non-abbreviated form.
     * @param userString    The unexpanded sms message.
     * @return  Expanded string without abbreviations.
     */
    public static String expandAbbreviation(String userString){
        System.out.println("=== Processing");
        boolean containsSMS = false;

        //searches for and replaces the abbreviations
        if (userString.contains("BFF")){
            System.out.println("Replacing \"BFF\" with \"best friend forever\"");
            userString = userString.replace("BFF", "best friend forever");
            containsSMS = true;
        }
        if (userString.contains("BTE")){
            System.out.println("Replacing \"BTE\" with \"blow the exam\"");
            userString = userString.replace("BTE", "blow the exam");
            containsSMS = true;
        }
        if (userString.contains("IDK")){
            System.out.println("Replacing \"IDK\" with \"I don't know\"");
            userString = userString.replace("IDK", "I don't know");
            containsSMS = true;
        }
        if (userString.contains("STT")){
            System.out.println("Replacing \"STT\" with \"spill the tea\"");
            userString = userString.replace("STT", "spill the tea");
            containsSMS = true;
        }
        if (!containsSMS){
            System.out.println("Could not find any known SMS abbreviations.");
        }
        System.out.println("=================");
        return userString;
    }

    /**
     * Displays the expanded message
     * @param result    The expanded string without SMS abbreviations.
     */
    public static void printExpanded(String result){
        System.out.println("=== Expanded text");
        System.out.println(result);
        System.out.println("=================");
    }
}
