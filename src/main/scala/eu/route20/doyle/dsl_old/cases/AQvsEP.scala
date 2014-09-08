package eu.route20.doyle.dsl_old.cases

import eu.route20.doyle.dsl_old._

object AQvsEP extends Game {
  var value = 0d

  value = {
    Case("AQ:n pelaaminen BB:ssä BUT/SB-korotusta(40% / 22+, A2s+, K2s+, Q5s+, J7s+, T8s+, 97s+, 86s+, 75s+, 65s, A3o+, K9o+, Q9o+, J9o+, T8o+, 98o) vastaan. Stäkki 100bb.",
        Branch("Kippi", 1d,
        	Leaf("Kippi", 1d, 99d) :: E) :: E)
  }.value
  println("Arvo: " + value)

  value = {
    Case("AQ:n pelaaminen BB:ssä SB/BUT-korotusta(40% / 22+, A2s+, K2s+, Q5s+, J7s+, T8s+, 97s+, 86s+, 75s+, 65s, A3o+, K9o+, Q9o+, J9o+, T8o+, 98o) vastaan. Stäkki 100bb.",
        Branch("Osut pariin", 0.3,
        	Leaf("Pari", 1d, 121d) :: E) :: E)
  }.value
  println("Arvo: " + value)

}