#include <iostream>
#include "Node.hpp"
#include "person.hpp"
using namespace std;

void hello();

int main()
{
	hello();
	Node n;
	n.hello();
	person a;
	a.setName("Fil");
	a.print();
	return 0;
}

void hello(){
	cout << "Hello world\n";
}

