package doyle.atdd

import doyle.Equity

object Examples extends Application {

  var eq = Equity of "AKs" versus "TT" >>

  println (eq)

  eq = Equity of "Ts8s" versus "AdJh" onBoard "5s2d2h" >>

  println (eq)

val s = List(1, 2, 4)


}
