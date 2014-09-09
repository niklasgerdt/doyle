package eu.route20.doyle.calculations

import eu.route20.doyle.Doyle

// Solving the optimal way to play small pocket pairs
object SmallPP extends App with Doyle {

  List(
    *(1d, 99), // Stack after fold
    *(1d, // Set mining vs tight raiser 146/1326 (22+, ATs+, AJo+, KQ+) is minimally profitable
      %(
        *(1 / 8.5d, // at least set
          %(
            *(0.5 / 100d, 0d), // you're stacked
            *(99.5 / 100d, // set holds
              %(// you win cbet/small pot
                *(5 / 10d, 108.5d),
                *(5 / 10d, 115d)
              )
            )
          )
        ),
        *(7.5 / 8.5d, 96.5d) // missed flop & you fold
      )
    ) // easy to defend by limiting post flop defeat size to small pot against known set miner
    ,
    *(1d, // Set mining vs button raiser 602/1326 (22+, A2s+, K7s+, Q7s+, J7s+, T8s+, 97s+, 87s, 76s, 65s, 54s, A2o+, K8o+, Q8o+, J8o+, T8o+, 97o+, 87o, 76o, 65o, 54o) is minimally profitable
      %(
        *(1 / 8.5d, // at least set
          %(
            *(0.3 / 100d, 0d), // you're stacked
            *(99.7 / 100d, // set holds
              %(
                *(3 / 10d, 115d), // he has something
                *(7 / 10d, 108.5d) // you win cbet
              )
            )
          )
        ),
        *(7.5 / 8.5d,
          96.5d) // missed flop & you fold
      )
    ),
    *(1d, // Fight back vs lag button raiser 602/1326.
      // (22+, A2s+, K7s+, Q7s+, J7s+, T8s+, 97s+, 87s, 76s, 65s, 54s, A2o+, K8o+, Q8o+, J8o+, T8o+, 97o+, 87o, 76o, 65o, 54o)
      %(
        *(1 / 8.5d, // at least set
          %(
            *(0.3 / 100d, 0d), // you're stacked
            *(99.7 / 100d, // set holds
              %(
                *(3 / 10d, 115d), // he has something and plays pot control
                *(7 / 10d, 108.5d) // you win cbet
              )
            )
          )
        ),
        *(7.5 / 8.5d, // missed flop
          %(
            *(7 / 10d, 96.5d), // you fold
            *(3 / 10d, // you push him off and win small pot or lose big one
              %(//228, 524, 78
                *(78 / 602d,
                  %(
                    *(1 / 8.5d, 55d), // try to push set out
                    *(7.5 / 8.5d, 115d)
                  )
                ),
                *(524 / 602d,
                  %(
                    *(13 / 100d, 55d), // try to push out two pairs and fds/sds ++
                    *(87 / 100d, 115d)
                  )
                )
              )
            )
          )
        )
      )
    )
  ).foreach(println(_))
}
