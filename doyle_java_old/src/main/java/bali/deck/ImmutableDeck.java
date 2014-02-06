package bali.deck;

import java.util.HashSet;
import java.util.Set;

public class ImmutableDeck implements Deck {
	 final private Set<Card> cards;
	
	public ImmutableDeck(){
		cards = new HashSet<>();
		for (Suite s : Suite.values()){
			for (Rank r : Rank.values()){
				Card c = new Card(r, s);
				cards.add(c);
			}
		}
	}

	@Override
	public int cards() {
		return cards.size();
	}

}
