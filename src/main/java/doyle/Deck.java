package doyle;

import java.util.Set;

public interface Deck {

	void drop(Set<Card> cards);
	
	Card dealOne();
	
	Holecards dealHolecards();
	
	Flop dealFlop();
	
	Turn dealTurn();
	
	River dealRiver();
}
