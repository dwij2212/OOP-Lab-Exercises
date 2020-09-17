package lab4;

public class Card {
	
	String rank, suit;
	int number;
	
	public Card(String suit, String rank, int number) {
		super();
		this.rank = rank;
		this.suit = suit;
		this.number = number;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	public boolean matches(Card c) {
		
		// This checks whether rank and suit of cards are same
		// If this is same then this returns true
		if (this.rank.equals(c.rank) && this.suit.equals(c.suit)) {
			return true;
		}
		
		return false;
	}
}
