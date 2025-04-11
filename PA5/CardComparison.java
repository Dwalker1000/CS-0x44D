package PA5;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 9/30/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: compares two cards and determines what card is more valuable.

import java.util.Scanner;

public class CardComparison {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //obtains monthly expenses
        System.out.print("Enter monthly expenses: ");
        double monthlyExpenses = scan.nextDouble();

        //gets info about the cards
        double[] card1Info = CardInfo(1, scan, monthlyExpenses);
        double[] card2Info = CardInfo(2, scan, monthlyExpenses);

        //prints the cards info and what card is better
        Results(card1Info, card2Info);
    }

    /**
     * Returns the annual ward dollar and the recommended card.
     * @param  cardNum    What card is it (1,2).
     * @param  scan    A Scanner object for console (or keyboard) input.
     * @param  monthlyExpenses    Total monthly expenses.
     * @return         An array with the stats of the card (net award dollars, PA11.Card_Game.Card num).
     */
    public static double[] CardInfo(int cardNum, Scanner scan, double monthlyExpenses){
        System.out.println("=== Credit PA11.Card_Game.Card " + cardNum + " Offer");

        //obtains annual fee and points obtained per dollar spent
        System.out.print("Enter annual fee: ");
        double annualFee = scan.nextDouble();
        System.out.print("Enter points per dollar spent: ");
        double PPDS = scan.nextDouble(); //points per dollar spent(PPDS)

        System.out.println("===================================");

        //gets total award dollars from the annual fee and PPDS
        double awardDollars = award(monthlyExpenses, annualFee, PPDS);
        return new double[] {awardDollars, cardNum};
    }

    /**
     * Returns the annual ward dollar and the recommended card.
     * @param  monthlyExpenses    Total monthly expenses.
     * @param  annualFee    The annual fee of card x.
     * @param  PPDS    The points per dollar spent for card x.
     * @return         The net reward dollars for card x.
     */
    public static double award(double monthlyExpenses, double annualFee, double PPDS){
        // (yearly expenses)/(points per dollar) - annual fee
        double awardMoney = (((monthlyExpenses*12.0)*PPDS)/100)-annualFee;

        //sets any negative award money to zero
        if (awardMoney < 0){
            return 0.0;
        }
        return awardMoney;
    }

    /**
     * Returns the annual ward dollar and the recommended card.
     * @param  card1    An array of doubles containing stats for card1.
     * @param  card2    An array of doubles containing stats for card2.
     */
    public static void Results(double[] card1, double[] card2){
        System.out.println("=== Results");

        //returns the total award dollars for each card
        System.out.printf("Credit PA11.Card_Game.Card %1.0f annual award dollars = $%.2f\n", card1[1], card1[0]);
        System.out.printf("Credit PA11.Card_Game.Card %1.0f annual award dollars = $%.2f\n", card2[1], card2[0]);

        //what card we recommend getting
        if (card1[0] > card2[0]){
            System.out.println("We recommend applying for Credit PA11.Card_Game.Card 1.");
        }
        else if (card1[0] == card2[0]){
            System.out.println("Both cards result in the same total award dollars.");
        }
        else{
            System.out.println("We recommend applying for Credit PA11.Card_Game.Card 2.");
        }
        System.out.println("===================================");
    }
}
