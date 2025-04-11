package PA2;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/8/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: prompts user for there birthday and provides interesting stats

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthdayTrivia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int monthBorn, dayBorn, yearBorn;

        //gets user values
        System.out.print("Enter the month you were born (1-12): ");
        monthBorn = scan.nextInt();
        System.out.print("Enter the day you were born (1-31): ");
        dayBorn = scan.nextInt();
        System.out.print("Enter the year you were born (1900-2017): ");
        yearBorn = scan.nextInt();

        //creates birthday/target date
        LocalDate birthDate = LocalDate.of(yearBorn, monthBorn, dayBorn);
        LocalDate targetDate = LocalDate.of(2023, 10, 1);

        //calculations
        int dayDif = (int) ChronoUnit.DAYS.between(birthDate, targetDate);
        double yearDif = dayDif / 365.0;
        int hourDif = dayDif * 24;
        int minDif = hourDif * 60;
        int secondDif = minDif * 60;
        int heartbeat = minDif * 72;
        int tacos = (dayDif / 7) * 2;

        //prints outputs (fun facts)
        System.out.println("On October 1st of this year,");
        System.out.println("you will have been alive for around ...");

        System.out.printf("- %.2f years\n", yearDif);
        System.out.println("- " + dayDif + " days");
        System.out.println("- " + hourDif + " hours");
        System.out.println("- " + minDif + " minutes");
        System.out.println("- " + secondDif + " seconds");
        System.out.println();

        System.out.println("Your heart will have beaten around " + heartbeat + " times");
        System.out.println("and most importantly, you will have eaten about " + tacos + " tacos.");
    } // End of main method.
}  // End of BirthdayTrivia class.
