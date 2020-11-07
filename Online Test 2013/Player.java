package cardGame;

import java.util.ArrayList;

class Player extends Thread {
	private String Name;
	private int turn;
	private int roundsWon;
	private ArrayList<Card> playerCards;
	private Table table;

	Player(String Name, Table table) {
		super(Name);
		playerCards = new ArrayList<Card>();
		this.Name = Name;
		this.table = table;
		turn = 0;
	}

	public ArrayList<Card> getplayerCards() {
		return playerCards;
	}

	public void setplayerCards(ArrayList<Card> cardsOnHand) {
		this.playerCards = cardsOnHand;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getPlayersName() {
		return Name;
	}

	public void setRoundsWon(int i) {
		this.roundsWon = i;
	}

	public int getroundsWon() {
		return roundsWon;
	}

	public void addCard(Card c) {
		playerCards.add(c);
	}

	public void run() {
		Card cardToThrow;
		/*
		 * Please make a note use the predefined described functions as much as possible
		 ** zero marks will be awarded if you modified the code or declared varriable You
		 * have to write the code to perform the following tasks in sequential manner.
		 * 1. This function runs till the round:Table is less or equal to
		 * maxRounds:Table. 2. Player gets the synchronized access on table 3. Player
		 * waits till his turn:Player is not equal to currentTurn:Table and rounds:Table
		 * is less than or equal the maxRounds:Table. 4. After that if rounds:Table is
		 * less than or equal to maxRound:Table it performs the following task 4.1 Sleep
		 * for some time. 4.2 Selects the card to throw. 4.3 Display the message that
		 * shows the selected card category and card number. 4.3 Add selected card in
		 * roundCards:Table. 4.4 Removes the selected card from playerCards:Players. 4.5
		 * Increments the currenttzurn:Table. 4.6 Notify to others.
		 */
		while (table.getRound() < table.getmaxRounds()) {
			synchronized (table) {
				while (!(table.getcurrentTurn() == getTurn()) && table.getRound() < table.getmaxRounds()) {
					try {
						table.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (table.getRound() < table.getmaxRounds()) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					cardToThrow = selectCardToThrow();
					System.out.println("Card thrown by player: " + this.Name + " is " + cardToThrow.getcategory()
							+ cardToThrow.getnumber());
					table.getroundCards().add(cardToThrow);
					this.playerCards.remove(cardToThrow);
					table.setcurrentTurn(table.getcurrentTurn() + 1);

					table.notifyAll();
				}
			}

		}
	} // end of run method

	Card selectCardToThrow() {
		ArrayList<Card> cardsOnTable = table.getroundCards();
		Card cardToThrow = null;
		Card maxCardInHand = playerCards.get(0);
		Card minCardInHand = playerCards.get(0);
		for (Card c : playerCards) {
			if (c.gettotalWeight() > maxCardInHand.gettotalWeight())
				maxCardInHand = c;
			if (c.gettotalWeight() < minCardInHand.gettotalWeight())
				minCardInHand = c;
		}
		if (!cardsOnTable.isEmpty()) {
			Card maxCardOnTable = cardsOnTable.get(0);
			for (Card c : cardsOnTable) {
				if (c.gettotalWeight() > maxCardOnTable.gettotalWeight())
					maxCardOnTable = c;
			}
			if (maxCardInHand.gettotalWeight() > maxCardOnTable.gettotalWeight()) {
				cardToThrow = maxCardInHand;
			} else
				cardToThrow = minCardInHand;
		} else {
			cardToThrow = maxCardInHand;
		}
		return cardToThrow;
	}
}