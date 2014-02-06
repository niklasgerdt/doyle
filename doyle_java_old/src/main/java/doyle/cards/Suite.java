package doyle.cards;

public enum Suite {
	DIAMOND('D'), HEARTS('H'), CLUBS('C'), SPADES('S');

	private char suite;

	private Suite(char suite) {
		this.suite = suite;
	}

	public char getSuite() {
		return suite;
	}
}
