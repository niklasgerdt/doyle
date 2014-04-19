#include <string>
#include <iostream>

using namespace std;

class Node {
public:
	Node * node [];
	string description;
	double hitPercentage;
	double payoff;

//	Node(Node n, string desc, double hit = 1.0, double pay = 1.0);
	void hello();
};

void Node::hello(){
	cout << "Hello world\n";
}