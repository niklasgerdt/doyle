package doyle;

public class Equities {
	final private double hero;
	final private double tie;
	final private double villain;

	public Equities(double hero, double tie, double villain) {
		this.hero = hero;
		this.tie = tie;
		this.villain = villain;
	}

	public double getHero() {
		return hero;
	}

	public double getTie() {
		return tie;
	}

	public double getVillain() {
		return villain;
	}
}
