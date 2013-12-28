package bali.deck;

public class Card {
	final private Rank rank;
	final private Suite suite;

	public Card(Rank rank, Suite suite) {
		this.rank = rank;
		this.suite = suite;
	}

	public Rank getRank() {
		return rank;
	}

	public Suite getSuite() {
		return suite;
	}
}
