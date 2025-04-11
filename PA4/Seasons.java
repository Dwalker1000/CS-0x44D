package PA4;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/26/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: Obtains date from the user and produces its corresponding season.

import java.util.*;

public class Seasons {
    public static String[] ALLMONTHS = {"january", "february", "march", "april", "may",
            "june", "july", "august", "september", "october", "november", "december"};
    public static int[] DAYSINMONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //obtains month and day
        String month = getMonth(scan).toLowerCase();
        int day = getDay(scan);

        //checks validity of the date
        if (validInput(month, day)){
            // obtains and prints season
            String season = calcSeason(month, day);
            displaySeason(season);
        }
        else{
            System.out.println("Invalid date.");
        }
    }

    /**
     * Prompts and returns the month.
     * @param  console A Scanner object for console (or keyboard) input.
     * @return         The inputted month.
     */
    public static String getMonth(Scanner console){
        System.out.print("Enter the month: ");
        return console.next();
    }

    /**
     * Prompts and returns the day.
     * @param  console A Scanner object for console (or keyboard) input.
     * @return         The inputted day.
     */
    public static int getDay(Scanner console){
        System.out.print("Enter day: ");
        return console.nextInt();
    }

    /**
     * Checks to see if the date is valid.
     * @param inputMonth The month given by the user.
     * @param inputDay The day given by the user.
     * @return         If date is valid.
     */
    public static boolean validInput(String inputMonth, int inputDay){
        boolean validMonth = false;
        boolean validDay = false;
        inputMonth = inputMonth.toLowerCase();
        //cycles through the months to check validity
        for (int i = 0; i < ALLMONTHS.length; i++) {
            if (inputMonth.equals(ALLMONTHS[i])) {
                validMonth = true;
                // checks if the day is valid
                validDay = inputDay >= 1 && inputDay <= DAYSINMONTHS[i];
            }
        }
        return (validMonth && validDay);
    }

    /**
     * Returns the season.
     * @param inputMonth The month given by the user.
     * @param inputDay The day given by the user.
     * @return         The season of the date.
     */
    public static String calcSeason(String inputMonth, int inputDay){
        int pos = 0;

        //finds position of the Month in the array
        for (int i = 0; i < ALLMONTHS.length; i++){
            if (inputMonth.equals(ALLMONTHS[i])){
                pos = i;
            }
        }

        //uses month position and day to get seasons
        if ((pos == 11 && inputDay >= 19) || pos == 0 || pos == 1 || (pos == 2 && inputDay <= 19)){
            return "winter";
        }
        else if (pos == 2 || pos == 3 || pos == 4 || (pos == 5 && inputDay <= 20)){
            return "spring";
        }
        else if (pos == 5 || pos == 6 || pos == 7 || (pos == 8 && inputDay <= 20)){
            return "summer";
        }
        return "fall";
    }

    /**
     * Returns the season.
     * @param season The season that the date is in.
     */
    public static void displaySeason(String season){
        System.out.println("This date occurs in the " + season + ".");
    }
}
