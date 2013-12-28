package doyle;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Cards {
	protected final Set<Card> cards;

	Cards() {
		cards = new HashSet<>();
	}

	public Cards(Set<Card> cards) {
		this.cards = Collections.unmodifiableSet(cards);
	}
}
