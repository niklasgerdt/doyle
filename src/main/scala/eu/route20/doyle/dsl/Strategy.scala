package eu.route20.doyle.dsl

case class Case(desc: String, nodes: List[Strategy]) extends Strategy
case class Branch(desc: String, prob: Double, nodes: List[Strategy]) extends Strategy
case class Leaf(desc: String, prob: Double, payoff: Double) extends Strategy
case class End extends Strategy

trait Strategy {
  def value(): Double = {
    value(1.0)
  }

  def value(p: Double): Double = {
    var value = 0d
    this match {
      case n: Leaf => {
        value += n.payoff * p * n.prob
        println(n.desc + " " + value)
        value
      }
      case n: Branch => n.nodes.foreach(x => value += x.value(p * n.prob))
      case n: Case => n.nodes.foreach(y => value += y.value(1.0))
    }
    value
  }
}

class Game extends App {

  def E() = List()

}