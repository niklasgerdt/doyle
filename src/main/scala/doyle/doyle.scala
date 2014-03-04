package doyle

//abstract class Hand
//case class River extends Hand
//case class Turn extends Hand
//case class Flop extends Hand
//case class HoleCard extends Hand
//case class Card extends Hand

class GameState
object Flop extends GameState
object Turn extends GameState
object River extends GameState

object doyle {

  def on(outs: Int, state: GameState) = {
    if (state == Flop)
      outs * 4 / 100.0
    else if (state == Turn)
      outs * 2 / 100.0
  }

  def outs(livecards: Int) = 0.25
}