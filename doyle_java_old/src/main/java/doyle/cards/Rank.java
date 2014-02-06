package doyle.cards;

public enum Rank {
	ACE('A'), KING('K'), QUEEN('Q'), JACK('J'), TEN('T'), NINE('9'), EIGHT('8'), SEVEN('7'), SIX('6'), FIVE('5'), FOUR('4'), TREE('2'), TWO('2');

	private char mark;

	private Rank(char mark) {
		this.mark = mark;
	}

	public char getMark() {
		return mark;
	}

}
