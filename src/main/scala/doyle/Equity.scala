package doyle

object Equity {

  def of(hand: String) = new Versus(hand)
}

class Versus(hero: String) {

  def versus(villain: String) = new EquityResolver(hero, villain, Option.empty)
}

class EquityResolver(hero: String, villain: String, board: Option[String]) {

  def onBoard(board: String) = new EquityResolver(hero, villain, Option(board))

  def >>() = {
    0.5
  }
}

case class Hand