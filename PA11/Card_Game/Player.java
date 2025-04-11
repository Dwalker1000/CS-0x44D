package PA11.Card_Game;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 12/2/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Class template description: Represents a player in a card game with methods to manage their hand

public class Player {
    //variables
    private int id;
    private int numOfCards;
    private Card[] hand;

    /**
     * Default constructor, initializes player with ID 0, no cards, and an empty hand
     */
    public Player() {
        this.id = 0;
        this.numOfCards = 0;
        this.hand = new Card[52];
    }

    /**
     * Initializes a player with a specific ID
     * @param id    The player's unique ID
     */
    public Player(int id) {
        this.id = id;
        this.numOfCards = 0;
        this.hand = new Card[52];
    }

    /**
     * Retrieves the players ID
     * @return  The players ID
     */
    public int getID() {
        return this.id;
    }

    /**
     * Returns number of cards in the players hand
     * @return  Number of cards in hand
     */
    public int getNumOfCards() {
        return this.numOfCards;
    }

    /**
     * Removes and returns a card at specific index in hand.
     * @param idx   Index of card to retrieve
     * @return      The card at the index, or null if there is no card
     */
    public Card getCard(int idx) {
        Card card = this.hand[idx];
        this.hand[idx] = null;
        this.numOfCards--;
        return card;
    }

    /**
     * Adds card to the player's hand, no card is added if hand is full
     * @param card  The card to add to the player's hand
     */
    public void addCard(Card card) {
        for (int i = 0; i < hand.length; i++) {
            if (this.hand[i] == null) {
                this.hand[i] = card;
                this.numOfCards++;
                break;
            }
        }
    }

    /**
     * Checks if player has card with a matching rank or suit
     * @param card  The card to check for
     * @return      The index of the matching card, or -1 if no match is found
     */
    public int hasCard(Card card) {
        for (int i = 0; i < hand.length; i++) {
            if (this.hand[i] != null &&
                    (this.hand[i].getRank().equals(card.getRank()) ||
                            this.hand[i].getSuit().equals(card.getSuit()))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Players hand is string representation
     * @return  A string of cards in players hand, or "No cards" if hand is empty
     */
    public String toString() {
        String result = "";

        for (Card card : hand) {
            if (card != null) {
                result += card + " ";
            }
        }

        if (result.isEmpty()) {
            return "No cards";
        }
        return result;
    }

    /**
         * Compares this player with another object to see if they have the same cards
         * @param obj   The object to compare to
         * @return      True if players are equal, false otherwise
         */
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player other = (Player) obj;
            if (this.numOfCards != other.numOfCards) {
                return false;
            }
            for (int i = 0; i < hand.length; i++) {
                if (this.hand[i] == null && other.hand[i] == null) {
                    continue;
                }
                if (this.hand[i] == null || other.hand[i] == null ||
                        !this.hand[i].equals(other.hand[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
