package equityresolver;

public class SamplingEquityResolver implements EquityResolver {
	public static final int SAMPLES = 100 * 1000;

//	@Override
	public Equity equitiesForHolecards(Hand hero, Hand villain) {
		if (hero == null || villain == null)
			throw new NullPointerException("Hand can't be null");
		if (!hero.isHoleCards() || !villain.isHoleCards())
			throw new IllegalArgumentException("Construct valid holecards!");
		if (hero.isDuplicates(villain))
			throw new IllegalArgumentException("Construct valid holecards!");
		for (int i = 0; i < SAMPLES; i++){
//			Deck deck = DeckFactory.createDeck();
		}
		return null;
	}
}
