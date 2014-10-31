package usage

import doyle.Doyle

object Example extends App with Doyle {
  // value of single leaf with prob. 100% and val 100
  List(*(1d, 100d)).foreach(println(_))

  // tree with two leafs each happening with prob. 50% and with values 100 and 0
  List(
    *(1d,
      %(
        *(1 / 2d, 100d),
        *(1 / 2d, 0d)
      )
    )
  ).foreach(println(_))

}


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
    ),
    *(1d, // Villain 602/1326. Defend with double barrelling 5/10 of misses
      // (22+, A2s+, K7s+, Q7s+, J7s+, T8s+, 97s+, 87s, 76s, 65s, 54s, A2o+, K8o+, Q8o+, J8o+, T8o+, 97o+, 87o, 76o, 65o, 54o)
      %(
        *(1 / 8.5d, // at least set
          %(
            *(78 / 602d,
              %(
                *(1 / 8.5d, 0d), // villain at least set
                *(7.5 / 8.5d, 120d) // modest pot vs pair
              )
            ),
            *(524 / 602d,
              %(
                *(0.15, 120d) //modest pot vs ok pair
                , *(0.15, 108.5) // small vs weak pair
                , *(0.10, 120d) // modest pot vs draw
                , *(0.60, 108.5) // cbet
              )
            )
          )
        ),
        *(7.5 / 8.5d, // missed flop
          %(
            *(5 / 10d, 96.5),
            *(5 / 10d,
              %(
                *(78 / 602d,
                  %(
                    *(1 / 8.5d, 76.5),
                    *(7.5d / 8.5d,
                      %(
                        *(0.5, 76.5),
                        *(0.5, 108.5)
                      )
                    )
                  )
                ),
                *(524 / 602d,
                  %(
                    *(0.15, 76d),
                    *(0.15, 108.5),
                    *(0.10, 90d),
                    *(0.60, 108.5)
                  )
                )
              )
            )
          )
        )
      )
    ),
    *(1d, // Villain 602/1326. Defend with double barrelling 5/10 of misses
      // (22+, A2s+, K7s+, Q7s+, J7s+, T8s+, 97s+, 87s, 76s, 65s, 54s, A2o+, K8o+, Q8o+, J8o+, T8o+, 97o+, 87o, 76o, 65o, 54o)
      %(
        *(1 / 8.5d, // at least set
          %(
            *(78 / 602d,
              %(
                *(1 / 8.5d, 0d), // villain at least set
                *(7.5 / 8.5d, 125d) // modest pot vs pair
              )
            ),
            *(524 / 602d,
              %(
                *(0.15, 120d), //modest pot vs ok pair
                *(0.15,
                  %(
                    *(0.7, 125d),
                    *(0.3, 108d)
                  )), // small vs weak pair
                *(0.10, 140d),
                *(0.60,
                  %(
                    *(0.9, 108.5),
                    *(0.1, 155d)
                  )
                )
              )
            )
          )
        ),
        *(7.5 / 8.5d, // missed flop
          %(
            *(9 / 10d, 96.5),
            *(1 / 10d,
              %(
                *(78 / 602d,
                  %(
                    *(1 / 8.5d, 76.5),
                    *(7.5d / 8.5d,
                      %(
                        *(0.5, 76.5),
                        *(0.5, 108.5)
                      )
                    )
                  )
                ),
                *(524 / 602d,
                  %(
                    *(0.15, 76d),
                    *(0.15,
                      %(
                        *(0.7, 76d),
                        *(0.3, 108d)
                      )
                    ),
                    *(0.10, 76d), // semibluffs with draws
                    *(0.60,
                      %(
                        // fights back with triple barrels
                        *(0.1, 76d),
                        *(0.9, 108.5)
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    ),
    *(1d, // Villain 602/1326. Defend with double barrelling 5/10 of misses
      // (22+, A2s+, K7s+, Q7s+, J7s+, T8s+, 97s+, 87s, 76s, 65s, 54s, A2o+, K8o+, Q8o+, J8o+, T8o+, 97o+, 87o, 76o, 65o, 54o)
      %(
        *(1 / 8.5d, // at least set
          %(
            *(78 / 602d,
              %(
                *(1 / 8.5d, 0d), // villain at least set
                *(7.5 / 8.5d, 125d) // modest pot vs pair
              )
            ),
            *(524 / 602d,
              %(
                *(0.20, 130d), //modest pot vs ok pair
                *(0.10, // weak pair
                  %(
                    *(0.7, 125d),
                    *(0.3, 108d)
                  )), // small vs weak pair
                *(0.10, 140d),
                *(0.60,
                  %(
                    *(0.9, 108.5),
                    *(0.1, 155d)
                  )
                )
              )
            )
          )
        ),
        *(7.5 / 8.5d, // missed flop
          %(
            *(9 / 10d, 96.5),
            *(1 / 10d,
              %(
                *(78 / 602d,
                  %(
                    *(1 / 8.5d, 76.5),
                    *(7.5d / 8.5d,
                      %(
                        *(0.5, 76.5),
                        *(0.5, 108.5)
                      )
                    )
                  )
                ),
                *(524 / 602d,
                  %(
                    *(0.15, 76d),
                    *(0.15,
                      %(
                        *(0.7, 76d),
                        *(0.3, 108d)
                      )
                    ),
                    *(0.10, 76d), // semibluffs with draws
                    *(0.60,
                      %(
                        // fights back with triple barrels
                        *(0.1, 76d),
                        *(0.9, 108.5)
                      )
                    )
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

