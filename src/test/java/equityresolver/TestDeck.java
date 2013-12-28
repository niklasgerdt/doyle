package gerdtni.equityresolver;

public class TestDeck implements Deck {
	protected static int TIMES_CALLED = 0;

	public TestDeck() {
		TIMES_CALLED++;
	}
}
