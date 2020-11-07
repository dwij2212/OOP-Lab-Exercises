package cardGame;

class Card {
	private String number;
	private char category;
	private int totalWeight;

	public Card(String number, char category) {
		this.number = number;
		this.category = category;
		settotalWeight();
	}

	public String getnumber() {
		return number;
	}

	public void setnumber(String number) {
		this.number = number;
	}

	public char getcategory() {
		return category;
	}

	public void setCategory(char category) {
		this.category = category;
	}

	public int gettotalWeight() {
		return totalWeight;
	}

	public void settotalWeight() {
		int numweight, catweight = 0;
		if (number.equals("J"))
			numweight = 11;
		else if (number.equals("Q"))
			numweight = 12;
		else if (number.equals("K"))
			numweight = 13;
		else if (number.equals("A"))
			numweight = 14;
		else if (number.equals("10"))
			numweight = 10;
		else
			numweight = number.charAt(0) - '0';
		if (category == 'C')
			catweight = 1;
		else if (category == 'H')
			catweight = 15;
		else if (category == 'D')
			catweight = 30;
		else if (category == 'S')
			catweight = 45;
		totalWeight = numweight + catweight;
	} // end of set weight method
} // end of card class