package PA11.Card_Game;
// Name: Daniel Walker
// VUnetID: walkedl2
// Email: daniel.l.walker@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 3
// Date: 12/2/2024
// Honor statement: I attest that I understand the honor code for this class and have neither given
//                  nor received any unauthorized aid on this assignment.

// Class template description: The class represents a playing card with a rank and suit
//                              Allows someone to retrieve card details and compare cards

public class Card {
    // The card ranks.
    // DO NOT CHANGE THIS CLASS CONSTANT.
    public static final String[] RANK = {"Ace", "2", "3", "4", "5", "6", "7",
    "8", "9", "10", "Jack", "Queen", "King"};
    
    // The card suits.
    // DO NOT CHANGE THIS CLASS CONSTANT.
    public static final String[] SUIT = {"Spades", "Hearts", "Clubs", "Diamonds"};
    
    //variables
    private int rank;
    private int suit;

    /**
     * Default constructor set to Ace of Spades
     */
    public Card() {
        this.rank = 0;
        this.suit = 0;
    }

    /**
     * Constructor to initialize card with specific rank/ suit
     * @param rank  rank of card (0-12)
     * @param suit  suit of card (0-3)
     */
    public Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Gets rank of the card
     * @return  the rank as a string
     */
    public String getRank(){
        return RANK[this.rank];
    }

    /**
     * Gets suit of the card
     * @return  the suit as a string
     */
    public String getSuit(){
        return SUIT[this.suit];
    }

    /**
     * Converts card into a string ("Ace|Spades")
     * @return  the string representation of the card
     */
    public String toString() {
        return getRank() + "|" + getSuit();
    }

    /**
     * Compares this card with another card
     * @param obj   the object to compare
     * @return      true if they are the same, false if not
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (getClass() != obj.getClass()) {
            return false;
        }

        Card other = (Card) obj;
        return this.rank == other.rank && this.suit == other.suit;
    }
}