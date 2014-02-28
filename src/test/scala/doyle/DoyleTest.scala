package doyle

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

class DoyleTest extends FeatureSpec with GivenWhenThen

class OddsTest extends DoyleTest {
  info("As a Hold'Em player")
  info("I want to know my odds in certain situation")

  feature("odds calculator") {
    scenario("Draw odds on flop") {
      Given("Flop AsKsTh")
      When("I have 8s7s")
      Then("My odds are")
      assertResult(0.36) {
        doyle on Flop odds 9
      }
    }
  }

}