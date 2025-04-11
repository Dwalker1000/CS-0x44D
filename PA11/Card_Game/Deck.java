package PA11.Card_Game;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 12/2/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Class template description: Represents a deck of cards with methods to draw cards
//                                                          and check the deck's state

public class Deck {
    // The size of the deck with 13 cards per suit of spades, hearts, clubs and diamonds.
    // DO NOT CHANGE THIS CLASS CONSTANT.
    public static final int SIZE_OF_DECK = Card.SUIT.length * Card.RANK.length;

    //variables
    private Card[] card;
    private int currIdx;

    /**
     * Creates deck in standard order
     */
    public Deck() {
        this.card = new Card[SIZE_OF_DECK];
        this.currIdx = 0;
        int index = 0;
        for (int suit = 0; suit < Card.SUIT.length; suit++) {
            for (int rank = 0; rank < Card.RANK.length; rank++) {
                this.card[index++] = new Card(rank, suit);
            }
        }
    }

    /**
     * Creates deck with a specific order
     * @param order The custom order of the deck
     */
    public Deck(int[] order) {
        this.card = new Card[SIZE_OF_DECK];
        this.currIdx = 0;
        int index = 0;
        for (int suit = 0; suit < Card.SUIT.length; suit++) {
            for (int rank = 0; rank < Card.RANK.length; rank++) {
                this.card[order[index++]] = new Card(rank, suit);
            }
        }
    }

    /**
     * Draws next card from deck
     * @return  The next card in deck or null if deck is empty
     */
    public Card draw() {
        if (currIdx >= SIZE_OF_DECK) {
            return null;
        }
        Card drawnCard = this.card[currIdx];
        this.card[currIdx] = null;
        currIdx++;
        return drawnCard;
    }

    /**
     * Checks if the deck is empty
     * @return  True if empty, false otherwise
     */
    public boolean isEmpty() {
        return currIdx >= SIZE_OF_DECK;
    }

    /**
     * Converts card into a string
     * @return  String indicating how many cards are in deck
     */
    public String toString() {
        int remainingCards = SIZE_OF_DECK - currIdx;
        String result = "The deck has " + remainingCards + " remaining card";

        if (remainingCards != 1) {
            result += "s";
        }

        result += ".";
        return result;
    }

    /**
     * Compares two decks
     * @param obj   The object we are comparing
     * @return      True if both decks have the same index, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Deck other = (Deck) obj;
        return this.currIdx == other.currIdx;
    }
}
