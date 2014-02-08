package doyle

object HandUtil {

  def toHand(hand: String): Option[Hand] = {
    
    def toHand(hand: String): Option[Hand] = {
      println("test")
      Option(new Hand)
    }

    hand match {
      case null | "" => Option.empty
      case _ => toHand(hand)
    }
  }
}

//    		Objects.requireNonNull(cards);
//		String[] cardArray = splitToCards(cards);
//		Stream<String> stream = Arrays.asList(cardArray).stream();
//		if (stream.count() != 2)
//			throw new IllegalArgumentException();
//		if (stream.anyMatch(s -> s.length() != 2))
//			throw new IllegalArgumentException();
//		if (!stream.allMatch(s -> isCard(s)))
//			throw new IllegalArgumentException();
//		//TODO new card
//		Set<Card> cardSet = stream.map(s -> new Card(Rank.ACE, Suite.CLUBS)).collect(Collectors.toSet());
//		this.cards = Collections.unmodifiableSet(cardSet);
