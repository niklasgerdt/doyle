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

trait Calculator {
  def odds(outs: Int){
    
  }
}
class OddsCalculator(multiplier: Int){
  protected def multi = this.multiplier
}

object doyle {

  def on(state: GameState) = {
    new OddsCalculator(4){
      def odds(outs: Int) =  outs * multi / 100.0
    }
  }

  def outs(livecards: Int) = 0.25
}