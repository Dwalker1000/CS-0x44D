package PA11.Card_Game;
// Name: CS 1101 instructor

// Description: This program plays a game of cards where the objective is an empty
//              hand. Players can remove a card with the same rank or suit as the
//              card in play or otherwise draw a card from draw from the deck. The
//              game ends when one player has no more cards or no more cards are
//              available to draw from the deck.

import java.util.*;

public class CardGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter a seed: ");
        int seed = console.nextInt();
        
        random.setSeed(seed);
        
        // Generate an array of values from 0 to NUMBER_OF_CARDS - 1
        // in random order to simulate the shuffling positions of the
        // cards.
        int[] order = shuffle(random);
        
        // Create a new Deck object.
        Deck deck = new Deck(order);
        
        // Create an array of Player objects.
        Player[] player = initializePlayers(console, deck);
        
        System.out.println();
        
        // Print initial player hands.
        for (Player onePlayer : player) {
            System.out.println("Player " + onePlayer.getID() + " hand: " + onePlayer);
        }
        
        System.out.println();
        
        // Play the game and return which player won. When null is returned,
        // no player won after all the cards have been drawn.
        Player winner = playGame(deck, player);
        
        // Print the result of the game.
        printResult(winner);
    }
    
    /**
     * Place one round of the game and return the winner.
     *
     * @param  deck   The deck of cards.
     * @param  player An array of players.
     * @return        The player who won, or null if a tie.
     */
    public static Player playGame(Deck deck, Player[] player) {
        // The winner of the game (null means no winner).
        Player winner = null;
        
        // Which player's turn it is (always starts with player one).
        int turn = 0;
        
        // Get the first card from the deck as the starter card.
        Card currentCard = deck.draw();
        
        System.out.println("Starting card is: " + currentCard);
        System.out.println();
        
        while (winner == null && !deck.isEmpty()) {
            // Play a player's turn and return the card placed by the player.
            // If the player had to draw, the current card remains as-is.
            currentCard = playTurn(currentCard, deck, player[turn]);
            
            // Check if the player that just played a card has no cards
            // left, which means the player has won.
            if (player[turn].getNumOfCards() == 0) {
                winner = player[turn];
            } else {
                // Show the current card in play.
                System.out.println("Current card is: " + currentCard);
                System.out.println();
                
                // Increment to the next player.
                turn++;
                
                if (turn == player.length) {
                    turn = 0;
                }
            }
        }
        
        return winner;
    }
    
    /**
     * Plays one player's turn and returns the card the player placed or
     * the current card as-is if the player had to draw.
     *
     * @param  currentCard The current card.
     * @param  deck        The deck of cards.
     * @param  player      The player who's turn it is.
     * @return             The current card for the next player to match.
     */
    public static Card playTurn(Card currentCard, Deck deck, Player player) {
        // Printer player's turn header.
        System.out.println("=== Player " + player.getID() + "'s turn ===");
        
        // Show the player's current hand.
        System.out.println("Hand: " + player);
        
        // Check if player has a playable card, either the same rank as the current
        // card or the same suit as the current card.
        int cardIdx = player.hasCard(currentCard);
        
        if (cardIdx > -1) {
            // Player has a card to play, get and print the card.
            Card playerCard = player.getCard(cardIdx);
            System.out.println("Plays: " + playerCard);
            
            // Set the current card to the card that the player just played.
            currentCard = playerCard;
        } else {
            // Player does not have a card to player, draw a card from the deck.
            player.addCard(deck.draw());
            System.out.println("Draws.");
        }
        
        // Show the player's current hand.
        System.out.println("Hand: " + player);
        System.out.println();
        
        return currentCard;
    }
    
    /**
     * Prints the winner of the game if a player won.
     *
     * @param  winner The player who won.
     */
    public static void printResult(Player winner) {
        if (winner != null) {
            System.out.println("Player " + winner.getID() + " won!");
        } else {
            System.out.println("No players won.");
        }
    }
    
    /**
     * Creates an array of values zero to SIZE_OF_DECK - 1, then
     * randomly shuffles the values returning the shuffled array.
     *
     * @param  random A Random object to generate random numbers.
     * @return An array of shuffled values.
     */
    public static int[] shuffle(Random random) {
        int[] order = new int[Deck.SIZE_OF_DECK];
        
        // Populate array with values zero to SIZE_OF_DECK - 1.
        for (int i = 0; i < Deck.SIZE_OF_DECK; ++i) {
            order[i] = i;
        }
        
        // Shuffle values in array, by generating a random integer
        // between zero to SIZE_OF_DECK - 1 and swapping the value
        // at that index with the value at the index of the loop
        // variable.
        for (int i = order.length - 1; i > 0; --i) {
            int idx = random.nextInt(Deck.SIZE_OF_DECK);
            
            int temp = order[idx];
            order[idx] = order[i];
            order[i] = temp;
        }
        
        return order;
    }
    
    /**
     * Creates and initializes an array of Player objects, including
     * drawing the first hand of cards for each player.
     *
     * @param  console A Scanner object for console (or keyboard) input.
     * @param  deck    The deck of cards.
     * @return An array of Player objects with initial hands.
     */
    public static Player[] initializePlayers(Scanner console, Deck deck) {
        System.out.print("Enter number of players: ");
        int playerCount = console.nextInt();
        
        System.out.print("Enter cards per player: ");
        int cardCount = console.nextInt();
        
        Player[] player = new Player[playerCount];
        
        // Instantiate Player objects.
        for (int i = 0; i < player.length; ++i) {
            player[i] = new Player(i + 1);
        }
        
        // Draw cards for each player.
        for (int i = 0; i < cardCount; ++i) {
            for (Player person : player) {
                person.addCard(deck.draw());
            }
        }
        
        return player;
    }
}
