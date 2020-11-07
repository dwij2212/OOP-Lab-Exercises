package cardGame;

import java.util.ArrayList;

class Table {
	private ArrayList<Card> roundCards;
	private int currentTurn = 1;
	private int round;
	private int maxRounds;

	public boolean isIsOver() {
		return isOver;
	}

	public void setIsOver(boolean isOver) {
		this.isOver = isOver;
	}

	private boolean isOver;

	public Table() {
		roundCards = new ArrayList<Card>();
		round = 1;
		maxRounds = 13;
	}

	public int getcurrentTurn() {
		return currentTurn;
	}

	public void setcurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}

	public ArrayList<Card> getroundCards() {
		return roundCards;
	}

	public void setroundCards(ArrayList<Card> cardsOnTable) {
		this.roundCards = cardsOnTable;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int i) {
		this.round = i;
	}

	public int getmaxRounds() {
		return maxRounds;
	}
}