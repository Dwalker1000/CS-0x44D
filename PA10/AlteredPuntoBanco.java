package PA10;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 11/18/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Program description: simulates a game of Punto Banco based on a given seed

import java.util.Random;
import java.util.Scanner;

public class AlteredPuntoBanco {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] result = new int[4];

        //gets seed and defines random object
        int seed = getSeed(scan);
        Random rand = new Random(seed);

        do{
            //plays game and adds to score/games played
            int win = puntoBanco(rand);
            result[win] += 1;
            result[3] += 1;

            //displays result of game
            if (win == 0) {System.out.println("Result of game: player wins\n");}
            else if (win == 2) {System.out.println("Result of game: bank wins\n");}
            else {System.out.println("Result of game: tie\n");}
        }while(repeat(scan));

        //total results
        printResults(result);
    }

    /**
     * gets seed for the random number from the user and makes sure it is a positive value
     * @param scan  scanner to obtain the users seed
     * @return      a positive seed from the user
     */
    public static int getSeed(Scanner scan) {
        System.out.print("Enter a seed: ");
        int seed = scan.nextInt();

        //makes sure seed in positive
        while (seed < 1){
            System.out.print("Not a positive number, try again: ");
            seed = scan.nextInt();
        }
        System.out.println();
        return seed;
    }

    /**
     * function on weather or not to continue playing the game
     * @param scan  Scanner object
     * @return      Returns boolean representing the players decision
     */
    public static boolean repeat(Scanner scan){
        System.out.print("Would you like to play again (Y/N)? ");
        return scan.next().equalsIgnoreCase("Y");
    }

    /**
     * simulates the game
     * @param rand  random object to generate cards
     * @return      returns who won the game (0 = player, 1 = tie, 2 = bank)
     */
    public static int puntoBanco(Random rand){
        int playerTotal = 0, bankTotal = 0, card;

        //Players Simulation
        playerTotal = simulation(rand, true);
        //if player's score is greater than 8 they win
        if (playerTotal > 7) {return 0;}

        //Bank Simulation
        bankTotal = simulation(rand, false);
        //if player's score is greater than 8 they win
        if (bankTotal > 7) {return 2;}

        //who wins based on score
        if(bankTotal > playerTotal) {return 2;}
        else if(bankTotal < playerTotal) {return 0;}
        else {return 1;}
    }

    /**
     * Runs the simulation of Punto Banco
     * @param rand      Random object to get card values
     * @param player    is it the player or the bank
     * @return          returns the total points obtained
     */
    public static int simulation(Random rand, boolean player){
        int total = 0, card;

        String playerOut = "PA11.Card_Game.Player";
        if(!player) {playerOut = "Bank";}

        //simulation
        for (int i = 0; i < 2; i++){
            card = rand.nextInt(13);
            total += obtainValue(card);
            System.out.println(displayCard(card, i, player));
        }

        //makes sure score is less than 10
        if (total >= 10) {total -= 10;}

        //need a third card
        if(total <= 5) {
            card = rand.nextInt(13);
            total += obtainValue(card);
            System.out.println(displayCard(card, 3, player));
        }

        //makes sure score is less than 10
        if (total >= 10) {total -= 10;}

        System.out.println(playerOut + " total: " + total + "\n");

        return total;
    }

    /**
     * obtains value of the card for the total
     * @param card  random number representing card value
     * @return      returns points obtained from each card
     */
    public static int obtainValue(int card){
        //ace
        if (card == 0){
            return 1;
        }

        //cards 2-9
        else if(card > 0 && card < 9){
            return card + 1;
        }

        //face card and ten's
        else{
            return 0;
        }
    }

    /**
     * displays the current card to the user
     * @param card      random value that represents the card
     * @param cardNum   what card is drawn (first, second, third)
     * @param player    is it bank to player
     * @return          returns string that gets printed
     */
    public static String displayCard(int card, int cardNum, boolean player){
        String display;

        //who's turn is it
        if(player){display = "PA11.Card_Game.Player draws ";}
        else{display = "Bank draws ";}

        //card number
        if (cardNum == 0) {display += "first card: ";}
        else if (cardNum == 1) {display += "second card: ";}
        else {display += "third card: ";}

        //value of the card
        if (card == 0) {display += "Ace";}
        else if(card > 0 && card < 10) {display += card + 1;}
        else if(card == 10) { display += "Jack";}
        else if(card == 11) { display += "Queen";}
        else if(card == 12) { display += "King";}

        //completed string
        return  display;
    }

    /**
     * displays the final results of how many games were won
     * @param results   array of how many games were played, tied, and won by each player
     */
    public static void printResults(int[] results){
        String games = "games";
        if (results[3] == 1) {games = "game";}
        System.out.printf("PA11.Card_Game.Player wins: %d of %d %s (%.1f%%)\n",
                results[0], results[3], games, (double)results[0]/results[3] * 100);
        System.out.printf("Bank wins: %d of %d %s (%.1f%%)\n",
                results[2], results[3], games, (double)results[2]/results[3] * 100);
        System.out.printf("Ties: %d of %d %s (%.1f%%)\n",
                results[1], results[3], games, (double)results[1]/results[3] * 100);
    }
}
