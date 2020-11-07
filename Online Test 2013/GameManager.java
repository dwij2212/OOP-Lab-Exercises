package cardGame;

import java.util.ArrayList;
import java.util.StringTokenizer;

class GameManager extends Thread {
	private ArrayList<Player> playersList;
	private Table table;

	public GameManager() {
		table = new Table();
		playersList = new ArrayList<Player>();
		initializePlayers();
		setPlayersTurn();
		System.out.println(" Round " + table.getRound() + " is going to begin");
		start();
		startPlayers();
	}

	void startPlayers() {
		for (int i = 0; i < playersList.size(); i++)
			playersList.get(i).start();
	}

	public static void main(String[] arg) {
		GameManager gm = new GameManager();
	}

	public void run() {
		Player round_Winner, game_Winner;
		/*
		 * Please make a note use the predefined described functions as much possible
		 ** zero marks will be awarded if you modified the code or declared varriable You
		 * have to write the code to perform the following tasks in sequential manner 1.
		 * This function runs till the round:Table is less than maxRounds:Table. 2. Game
		 * manager gets the synchronized access on table 3. Wait till the
		 * roundCards:Table is not equal to four. 4. after that 4.1 It finds the round
		 * winner. 4.2 update the roundsWon:Player. 4.3 Sleep for some time. 4.4 Display
		 * the round winner name and round number 4.5 clears the roundCards:Table 4.6
		 * increments the round:Table 4.7 if round:Table is less or equal to
		 * maxRounds:Table then 4.7.1 Set the players turn for next round 4.7.2 Set
		 * currenturn:Table to 1 4.7.3 Display the the message that shows that new round
		 * begins with round number. 4.8 after that Notify to others 4.9 After
		 * completing all rounds it computes 4.9.1 Game winner 4.9.2 Display the game
		 * winner name 4.9.3 Display the game is over.
		 */

		while (table.getRound() < table.getmaxRounds()) {
			synchronized (table) {
				while (table.getroundCards().size() != 4) {
					try {
						table.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				round_Winner = this.roundWinner();
				round_Winner.setRoundsWon(table.getRound());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Winner of Round " + table.getRound() + " is " + round_Winner.getName());
				table.setroundCards(new ArrayList<Card>());
				table.setRound(table.getRound() + 1);
				setPlayersTurn();
				table.setcurrentTurn(1);

				System.out.println("NEW Round begins ----------- Round: " + table.getRound());

				table.notifyAll();

			}
		}
		game_Winner = gameWinner();
		System.out.println("Game winner: " + game_Winner.getName());
		System.out.println("Game over!!");
	} // end of run

	Player gameWinner() {
		Player winner = playersList.get(0);
		for (Player player : playersList) {
			if (player.getroundsWon() > winner.getroundsWon())
				winner = player;
		}
		return winner;
	}

	Player roundWinner() {
		ArrayList<Card> cardsOnTable = table.getroundCards();
		Card maxCard = cardsOnTable.get(0);
		Player roundWinner = null;
		int turnMaxCard = 1, cardCount = 1;
		;
		for (Card c : cardsOnTable) {
			if (c.gettotalWeight() > maxCard.gettotalWeight()) {
				maxCard = c;
				turnMaxCard = cardCount;
			}
			cardCount++;
		}
		boolean winnerFound = false;
		int player = 1;
		while (!winnerFound && player < 5) {
			if (playersList.get(player - 1).getTurn() == turnMaxCard) {
				winnerFound = true;
				roundWinner = playersList.get(player - 1);
			}
			player++;
		}
		return roundWinner;
	}

	void setPlayersTurn() {
		int round = table.getRound();
		int countPlayer = 1;
		int player = (round % 4 == 0) ? 4 : (round % 4);
		while (countPlayer <= 4) {
			playersList.get(player - 1).setTurn(countPlayer);
			countPlayer++;
			player = (((player + 1) % 5) == 0) ? 1 : (player + 1);
		}
	}

	void initializePlayers() {
		for (int player = 1; player <= 4; player++)
			playersList.add(new Player("P" + player, table));
		ArrayList<String> playerCard = new ArrayList<String>();
		playerCard.add("S4 S5 D4 D2 D7 D8 H4 H5 H8 C4 C5 CQ CK");
		playerCard.add("S2 SJ SQ SK D3 D5 DJ DQ HQ HK C6 C7 C10");
		playerCard.add("S3 S8 S9 S10 D6 D9 D10 H9 H10 HJ C2 C9 CJ");
		playerCard.add("S6 S7 SA DK DA H2 H3 H6 H7 HA C3 C8 CA");
		String delims = " ";
		String line = null;
		int count = 0;
		while (count < playerCard.size()) {
			ArrayList<Card> lst = new ArrayList<Card>();
			System.out.println("Player P" + (count + 1) + " Cards ");
			System.out.println(playerCard.get(count));
			StringTokenizer st = new StringTokenizer(playerCard.get(count), delims);
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				if (s.length() != 3)
					lst.add(new Card(s.charAt(1) + "", s.charAt(0)));
				else
					lst.add(new Card(s.charAt(1) + "" + s.charAt(2), s.charAt(0)));
			}
			playersList.get(count).setplayerCards(lst);
			count++;
		} // end of while
	} // end of method
} // end of class