package doyle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DeckImpl extends Cards implements Deck {

	public DeckImpl() {
		super();
		List<Card> list = new ArrayList<>();
		for (Suite s : Suite.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(r, s);
				list.add(c);
			}
		}
		Collections.shuffle(list);
//		cards = new HashSet<>(list);
	}

	@Override
	public void drop(Set<Card> cards) {
		cards.removeAll(cards);
	}

	@Override
	public Card dealOne() {
		Optional<Card> first = cards.stream().findFirst();
		return first.get();
	}

	@Override
	public Flop dealFlop() {
		Set<Card> flop = cards.stream().limit(3).collect(Collectors.toSet());
		drop(flop);
		return new Flop(flop);
	}

	@Override
	public Turn dealTurn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public River dealRiver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Holecards dealHolecards() {
		// TODO Auto-generated method stub
		return null;
	}
}
