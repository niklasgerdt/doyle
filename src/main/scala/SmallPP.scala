package eu.route20.doyle.calculations

import eu.route20.doyle.Doyle

// Solving the optimal way to play small pocket pairs
object SmallPP extends App with Doyle {

  List(
    *(1d, 99), // Stack after fold
    *(1d, // Set mining vs tight raiser 146/1326 (22+, ATs+, AJo+, KQ+) is minimally profitable
      %(
        *(1 / 7.5d, // at least set
          %(
            *(0.5 / 100d, 0d), // you're stacked
            *(99.5 / 100d, // set holds
              %(
                *(5 / 10d, 130d), // he has something
                *(5 / 10d, 108.5d) // you win cbet
              )
            )
          )
        ),
        *(6.5 / 7.5d, 96.5d) // missed flop & you fold
      )
    ),
    *(1d, // Set mining vs button raiser 602/1326 (22+, A2s+, K7s+, Q7s+, J7s+, T8s+, 97s+, 87s, 76s, 65s, 54s, A2o+, K8o+, Q8o+, J8o+, T8o+, 97o+, 87o, 76o, 65o, 54o) is minimally profitable
      %(
        *(1 / 7.5d, // at least set
          %(
            *(0.3 / 100d, 0d), // you're stacked
            *(99.7 / 100d, // set holds
              %(
                *(3 / 10d, 135d), // he has something
                *(7 / 10d, 108.5d) // you win cbet
              )
            )
          )
        ),
        *(6.5 / 7.5d, 96.5d) // missed flop & you fold
      )
    )
  ).foreach(println(_))
}
