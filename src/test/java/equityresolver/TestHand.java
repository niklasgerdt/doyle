package equityresolver;

public class TestHand implements Hand {
	protected static int TIMES_EQUITIES_FOR_HOLECARDS_CALLED;
	protected static int TIMES_IS_DUPLICATED_CALLED;

	@Override
	public boolean isHoleCards() {
		TIMES_EQUITIES_FOR_HOLECARDS_CALLED++;
		return true;
	}

	@Override
	public boolean isDuplicates(Hand villain) {
		TIMES_IS_DUPLICATED_CALLED++;
		return false;
	}

}
