package blackjackFrame;

public class Card {
	private int rank;
	private char simbol;
	private String image;

	public Card(int rank, char simbol, String image) {
		this.rank = rank;
		this.simbol = simbol;
		this.image = image;
	}

	public char getSimbol() {
		return simbol;
	}

	public int getRank() {
		return rank > 10 ? 10 : rank;
	}


	public String getImage() {
		return image;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return rank+" "+simbol+" "+image;
	}

}
