##doyle
Minimalistic DSL/API for describing game trees and solving their value.

####examples
usage 
```scala
import doyle.Doyle
object Example extends Doyle {
```
tree with two leafs each happening with prob. 50% and with values 100 and 0
```scala
  List(
    *(1d,
      %(
        *(1 / 2d, 100d),
        *(1 / 2d, 0d)
      )
    )
  ).foreach(println(_))
```
tree with three leafs each happening with prob. 33.3 %. Leaf 1 has payoff 100, leaf 2 has payoff 0 and leaf 3 has two subleafs with values 100 and 0, where both have prob. 50 %.
```scala
  List(
    *(1d,
      %(
        *(1 / 3d, 100d),
        *(1 / 3d, 0d),
        *(1 / 3d,
          %(
            *(1 / 2d, 100d),
            *(1 / 2d, 0d)
          )
        )
      )
    )
  ).foreach(println(_))
```


