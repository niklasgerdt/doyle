sealed trait Node {
  def node: Node
}
case class Root(node: Node, probability: Double) extends Node
case class Leaf (node: Node, payoff: Double) extends Node

class Strategy() {
// 	var childs: List

 	
 } 