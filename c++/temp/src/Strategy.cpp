#include <string>
#include <iostream>

using namespace std;

class Node {
public:
	Node * nodes;
	int nodepointer = 0;
	string description;
	double hitPercentage;
	double payoff;

	Node();
	Node(string desc, double hit, double pay);
	void print();
	double value(double p=1.0);
	void addChild(Node * n);
};

int main() {
	Node root = Node("Vastustaja korottaa tiukasti (99+,XJ+) ja maksat pikkuparilla tehdäksesi setin.", 0.0, 0.0);
	Node fit = Node("Setti osuu.", 1.0/8.0, 0.0);
	cout << "calculating\n";
	root.addChild(&fit);
	cout << root.value();
	return 0;
}

Node::Node(){}

Node::Node(string desc, double hit, double pay){
	description = desc;
	hitPercentage = hit;
	payoff = pay;
}

void Node::print(){
	cout << description;
}

void Node::addChild(Node * n){
	nodes = new Node [1] {Node("Setti osuu.", 1.0/8.0, 0.0)};
	nodepointer++;
}

double Node::value(double p){
    double val = 0.0;
	if (nodepointer==0){
		return payoff * hitPercentage * p;
	}
	else {
		for(int i=0; i < nodepointer; i++){
			return nodes[i].value(nodes[i].hitPercentage * p);
		}
	}
}
