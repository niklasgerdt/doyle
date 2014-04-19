package strat;

public class SimplePocketPairTest {

	public static void main(String[] args) {
		setMiningAgainstTightRaiser();
		setMiningAgainstBasicRaiser();
		//Et voi maksaa pikkupareilla vain tehdäksesi setin. Tarvitset lisäoptioita (bluffeja/maksuja).
	}

	private static void setMiningAgainstTightRaiser() {
		Node root = new Node(
				"Pikkuparien arvo, kun vastustaja korottaa tiukasti(TT+,AQ+) 3bb.");
		Node fit = new Node(1/9d, "Setti osuu.");
		root.addChild(fit);
		Node fitAndPot = new Node(30/62d, "Vastustajallasi pari lähtökätenä.");
		fit.addChild(fitAndPot);
		Node setoverset = new Node(1/100d, -100d, "vastustajasi tekee korkeamman setin.");
		fitAndPot.addChild(setoverset);
		Node setWin = new Node(99/100d, 35d, "Voitat vastustajasi parin setillä.");
		fitAndPot.addChild(setWin);
		Node fitAndCBet = new Node(32/62d, "Vastustajallasi kaksi korkeaa korttia.");
		fit.addChild(fitAndCBet);
		Node villainHits = new Node(1/4d, 35d, "V tekee parin flopilla ja voitat potin");
		fitAndCBet.addChild(villainHits);
		Node villainMisses = new Node(3/4d, 8.5d, "V missaa ja voitat vain jatkobluffin");
		fitAndCBet.addChild(villainMisses);
		Node miss = new Node(8/9d, -3d, "Missaat ja häviät maksun.");
		root.addChild(miss);
		Double value = root.value();
		System.out.println(value);
	}

	private static void setMiningAgainstBasicRaiser() {
		Node root = new Node(
				"Pikkuparien arvo, kun vastustaja korottaa edelleen tiukasti(99+,XJ+) 3bb.");
		Node fit = new Node(1/9d, "Setti osuu.");
		root.addChild(fit);
		Node fitAndPot = new Node(36/132d, "Vastustajallasi pari lähtökätenä.");
		fit.addChild(fitAndPot);
		Node setoverset = new Node(1/100d, -100d, "vastustajasi tekee korkeamman setin.");
		fitAndPot.addChild(setoverset);
		Node setWin = new Node(99/100d, 35d, "Voitat vastustajasi parin setillä.");
		fitAndPot.addChild(setWin);
		Node fitAndCBet = new Node(96/132d, "Vastustajallasi kaksi korkeaa korttia.");
		fit.addChild(fitAndCBet);
		Node villainHits = new Node(1/4d, 35d, "V tekee parin flopilla ja voitat potin");
		fitAndCBet.addChild(villainHits);
		Node villainMisses = new Node(3/4d, 8.5d, "V missaa ja voitat vain jatkobluffin");
		fitAndCBet.addChild(villainMisses);
		Node miss = new Node(8/9d, -3d, "Missaat ja häviät maksun.");
		root.addChild(miss);
		Double value = root.value();
		System.out.println(value);
	}
}
