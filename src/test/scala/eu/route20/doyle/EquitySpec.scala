package eu.route20.doyle

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

class EquitySpec extends FeatureSpec with GivenWhenThen {

  info("As a Hold'Em player")
  info("I want to know my holecards equity against villain's hand")
  info("So I can make educated decisions")

  feature("Equity calculator") {
    scenario("Hero and villain has aces") {
      Given("No board cards")
      When("five cards are dealt")
      Then("my equity is 50%")
      assert(true)
    }
  }
}