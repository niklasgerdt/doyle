package eu.route20.doyle.dsl_old.cases

import eu.route20.doyle.dsl_old._

object BB_99vsSB extends Game {
  var value = 0d

  value = {
    Case("SB raise 45,4% (22+, A2s+, K8s+, Q8s+, J7s+, T9s, 98s, 87s, 76s, 65s, 54s, A9o+, K9o+, Q9o+, J8o+, T8o+, 97o+, 87o, 76o, 65o, 54o). BB has 99.",
      Branch("BB fold", 1d,
          Leaf("value", 1d, 99d) :: E) :: E)
  }.value

value = {
    Case("SB raise 45,4%. Hero BB has 99.",
      Branch("raise", 1d,
      	Branch("villain folds", 1d,
          Leaf("value", 1d, 103d) :: E) :: E) :: E)
  }.value

value = {
    Case("SB raise 40%. Hero BB has 99.",
      Branch("raise", 1d,
      	Branch("villain folds 88%", 0.88d,
          Leaf("value", 1d, 103d) :: E) :: 
      Branch("bb reraise 12%, sb folds", 0.12d,
      	Leaf("value", 1d, 91d) :: E) :: E) :: E)
  }.value

}