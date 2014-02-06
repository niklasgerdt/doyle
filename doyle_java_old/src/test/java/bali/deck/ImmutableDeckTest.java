package bali.deck;

import static org.junit.Assert.*;

import org.junit.Test;

import bali.deck.Deck;
import bali.deck.ImmutableDeck;

public class ImmutableDeckTest {
	private static final int NEW_DECK_SIZE = 52;

	@Test
	public void fullDeckHas52Cards() {
		Deck deck = new ImmutableDeck();
		assertEquals(NEW_DECK_SIZE, deck.cards());
	}

}
