package gerdtni.equityresolver;

public class EquityResolverTest {
	private EquityResolver eq = new SamplingEquityResolver();
	Hand h1 = new TestHand();
	Hand h2 = new TestHand();

	public void runTests() {
		nullCheckForHolecards();
		validatesHands();
		validatesHandsForNoDuplication();
		createsNewDeckForAllSamlples();
		dropsHolecardsFromAllSampleDecks();
		takesFiveFromAllSampleDecks();
	}

	private void nullCheckForHolecards() {
		try {
			eq.equitiesForHolecards(new TestHand(), null);
			eq.equitiesForHolecards(null, new TestHand());
			eq.equitiesForHolecards(null, null);
			System.out.println("Shouldn't be able to pass null!");
		} catch (Exception e) {
		}
	}

	private void validatesHands() {
		TestHand.TIMES_EQUITIES_FOR_HOLECARDS_CALLED = 0;
		eq.equitiesForHolecards(h1, h2);
		if (TestHand.TIMES_EQUITIES_FOR_HOLECARDS_CALLED != 2)
			System.out.println("Should validate both hands!");
	}

	private void validatesHandsForNoDuplication() {
		TestHand.TIMES_IS_DUPLICATED_CALLED = 0;
		eq.equitiesForHolecards(h1, h2);
		if (TestHand.TIMES_IS_DUPLICATED_CALLED != 1)
			System.out.println("Should check for duplication!");
	}

	private void createsNewDeckForAllSamlples() {
		TestDeck.TIMES_CALLED = 0;
		eq.equitiesForHolecards(h1, h2);
		if (TestDeck.TIMES_CALLED != SamplingEquityResolver.SAMPLES)
			System.out.println(SamplingEquityResolver.SAMPLES + "Should create new deck for every sample" + TestDeck.TIMES_CALLED);
	}

	private void dropsHolecardsFromAllSampleDecks() {

	}

	private void takesFiveFromAllSampleDecks() {

	}
}
