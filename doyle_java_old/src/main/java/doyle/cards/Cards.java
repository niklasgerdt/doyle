package doyle.cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cards {
	private static final String SPLITTER = ",";
	final protected Set<Card> cards;

	protected Cards() {
		cards = null;
	}

	protected Cards(Set<Card> cards) {
		this.cards = Collections.unmodifiableSet(cards);
	}

	protected Cards(String cards, int i) {
		Objects.requireNonNull(cards);
		String[] cardArray = splitToCards(cards);
		Stream<String> stream = Arrays.asList(cardArray).stream();
		if (stream.count() != 2)
			throw new IllegalArgumentException();
		if (stream.anyMatch(s -> s.length() != 2))
			throw new IllegalArgumentException();
		if (!stream.allMatch(s -> isCard(s)))
			throw new IllegalArgumentException();
		//TODO new card
		Set<Card> cardSet = stream.map(s -> new Card(Rank.ACE, Suite.CLUBS)).collect(Collectors.toSet());
		this.cards = Collections.unmodifiableSet(cardSet);
	}

	private String[] splitToCards(String cards) {
		String[] cardArray = cards.split(SPLITTER);
		return cardArray;
	}

	private boolean isCard(String card) {
		boolean hasRank = hasRank(card);
		boolean hasSuite = hasSuite(card);
		return hasRank ? hasSuite : false;
	}

	private boolean hasSuite(String card) {
		final char suite = card.toUpperCase().charAt(1);
		Stream<Suite> stream = Arrays.asList(Suite.values()).stream();
		boolean isSuite = stream.anyMatch(r -> (r.getSuite() == suite));
		return isSuite;
	}

	private boolean hasRank(String card) {
		final char rank = card.toUpperCase().charAt(0);
		Stream<Rank> stream = Arrays.asList(Rank.values()).stream();
		boolean isRank = stream.anyMatch(r -> (r.getMark() == rank));
		return isRank;
	}

	/**
	 * Creates new Flop (immutable) from given cards. Cards must obey general
	 * poker lingo. Examples of valid cards values are As,Ac to mean Ace of
	 * spades and ace of clubs. Valid separators are ,.; and :.
	 * 
	 * @param cards
	 * @return
	 */
	public static Flop createFlop(String cards) {
		return new Flop(cards);
	}

	/**
	 * Creates new Holecards (immutable) from given cards. Cards must obey
	 * general poker lingo. Examples of valid cards values are As,Ac to mean Ace
	 * of spades and ace of clubs. Valid separators are ,.; and :.
	 * 
	 * @param cards
	 * @return
	 */
	public static Holecards createHolecards(String cards) {
		return new Holecards(cards);
	}
}
