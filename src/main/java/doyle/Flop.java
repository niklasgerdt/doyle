package doyle;

import java.util.Objects;
import java.util.Set;

public class Flop extends Cards {
	private static final int CARDS_ON_FLOP = 3;

	public Flop(Card c1, Card c2, Card c3) {
		super();
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
	}

	public Flop(Set<Card> cards) {
		super(cards);
	}

	static Flop createFlop(Set<Card> cards) {
		Objects.requireNonNull(cards);
		if (cards.size() != CARDS_ON_FLOP)
			throw new IllegalArgumentException();
		return new Flop(cards);
	}
}
