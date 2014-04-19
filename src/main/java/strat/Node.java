package strat;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Node> childs;
	private Double probability;
	private Double payoff;
	private String description;

	public Node(String description) {
		childs = new ArrayList<Node>();
		this.probability = 1.0;
		this.payoff = 1.0;
		this.description = description;
	}

	public Node(Double probability, String description) {
		childs = new ArrayList<Node>();
		this.probability = probability;
		this.payoff = 1.0;
		this.description = description;
	}

	public Node(Double probability, Double payoff, String description) {
		childs = new ArrayList<Node>();
		this.probability = probability;
		this.payoff = payoff;
		this.description = description;
	};

	public void addChild(Node child) {
		childs.add(child);
	}

	public Double value() {
		System.out.println(description);
		return value(this.probability);
	}

	private Double value(Double probability) {
		Double value = 0.0;
		if (childs.isEmpty()) {
			value += payoff * this.probability * probability;
			System.out.println("Arvo: " + value);
		} else
			for (Node n : childs) {
				System.out.println(n.description);
				value += n.value(probability * this.probability);
			}
		return value;
	}
}
