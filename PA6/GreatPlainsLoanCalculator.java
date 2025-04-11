package PA6;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 10/15/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: displays balance sheet based on the monthly payment inputted

import java.util.Scanner;

public class GreatPlainsLoanCalculator {
    public static void main(String[] args) {
        double monthlyPayment = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter amount you will pay every month: ");
        while(monthlyPayment < 250 || monthlyPayment > 850){
            monthlyPayment = scan.nextDouble();
            if(monthlyPayment < 250 || monthlyPayment > 850){
                System.out.print("Monthly payment must be $250-$850, try again: ");
            }
        }
        System.out.println("MORTGAGE PAYMENT SCHEDULE");
        System.out.println("The amount borrowed is $5000");
        System.out.println();

        display(monthlyPayment);
    }

    /**
     * displays the balance sheet based on the monthly payment
     * @param monthlyPayment    the inputted monthly payment given by the user
     */
    public static void display(double monthlyPayment){
        double interest = 0, balance, remaining = 5000, totalInterest = 0, lastInterest;
        System.out.println("=================================================================");
        System.out.println("Month       Interest        Balance        Payment      Remaining");
        System.out.println("=================================================================");

        for (int i = 1; i<24; i++){
            balance = remaining;
            interest = (2 * remaining) / 12;
            totalInterest += interest;
            balance += interest;
            remaining = balance - monthlyPayment;
            System.out.printf("%5d %,14.2f %,14.2f", i, interest, balance);
            System.out.printf(" %,14.2f %,14.2f\n", monthlyPayment, remaining);
        }
        lastInterest = (2 * remaining) / 12;
        totalInterest += lastInterest;

        double finalPayment = remaining + lastInterest;
        double totalPayed = (remaining + lastInterest) + (monthlyPayment * 23);

        System.out.println("   24                                See final payment info below");
        System.out.println("=================================================================");
        System.out.println();
        System.out.printf("Final payment: $%,.2f\n", finalPayment);
        System.out.printf("Total paid over 24 months: $%,.2f\n", totalPayed);
        System.out.printf("Total interest paid: $%,.2f\n", totalInterest);
        System.out.println();
        System.out.print("Thank you for your business ... ");
        System.out.println("at Great Plains Loans, we treat you like family!");
    }
}

