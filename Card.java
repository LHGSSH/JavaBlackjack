/**
 * This class represents a playing card.
 * 
 * @author Liam Hilton-Green
 * @version 1.0
 * 
 * CEN3031    Project
 * File Name: card.java
 */

public class Card {
	/**
	 * The suit of the card (hearts, spades, etc.)
	 */
	private Suit suit;
	
	/**
	 * The type of card. Rank can be 1-13. 
	 * 1 represents an ace card.
	 * 2-10 are their respective values. 
	 * 11 is a jack card, 12 is a queen card, and 13 is a king card.
	 */
	private int rank;
	
	/**
	 * The point value of the card.
	 * An ace card can be 1 or 11, depending on which gives the better advantage.
	 * Numbered cards have their rank as their value.
	 * Face cards (jack, queen, or king) are 10 points.
	 */
	private int value;
	
	/**
	 * The constructor for Card.
	 * @param suit: the suit of the card
	 * @param rank: the rank of the card
	 */
	public Card(Suit suit, int rank) {
		setSuit(suit);
		setRank(rank);
		
		if (rank >= 1 && rank <= 10) { //Ace or numbered card
			setValue(rank);
			//If the card is an ace, the value can be reset later, if needed
		}
		if (rank >= 11) { //Face card
			setValue(10);
		}
	}
	
	/**
	 * Returns the suit of the card.
	 * @return suit: the suit of the card
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * Sets the suit of the card.
	 * You can choose from Suit.HEARTS, Suit.DIAMONDS,
	 * Suit.CLUBS, or Suit.SPADES.
	 * @param newSuit: the suit you want to set the card as
	 */
	public void setSuit(Suit newSuit) {
		this.suit = newSuit;
	}
	
	/**
	 * Returns the rank of the card.
	 * @return rank: the rank of the card
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Sets the rank of the card.
	 * @param newRank: the rank you want to set the card as
	 */
	public void setRank(int newRank) {
		this.rank = newRank;
	}
	
	/**
	 * Returns the point value of the card.
	 * @return value: the point value of the card
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the point value of the card.
	 * @param newValue: the value you want to set the card to
	 */
	public void setValue(int newValue) {
		this.value = newValue;
	}
	
	/**
	 * Returns whether the card is an ace or not.
	 * @return whether the card is an ace or not
	 */
	public boolean isAce() {
		if (this.getValue() == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
