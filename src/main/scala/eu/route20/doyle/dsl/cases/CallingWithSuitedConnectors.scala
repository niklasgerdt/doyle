package eu.route20.doyle.dsl.cases

import eu.route20.doyle.dsl._

object CallingWithSuitedConnectors extends Game {
  var value = 0d

  value = {
    Case("Vastustaja korottaa normaalisti (55+, XJ+, XTs+, 76s+) ja maksat suittarilla (87s). Maksat flopilla, jos osut.",
      Branch("Pari", 29 / 100d, 
          E) ::
      Branch("Parempi kuin 2 paria", 3.6 / 100d, 
          E) ::
      Branch("FD tai STR8D", 16/100d, 
          E) ::
      Branch("Gutshot passiivisesti pelaten", 21.6/100d, 
          Branch("v ylipari, lyö flopin ja turnin", 24/188d, 
            Leaf("maksu flopilla ja str8 turnilla", 8/100d, 40d) ::
            Leaf("maksu flopilla ja missi", 92/100d, -8.5d)
          ::E)::
          Branch("v alipari, lyö flopin", 54/188d, 
            Leaf("maksu flopilla ja str8 riverilla", 16/100d, 16d) ::
            Leaf("maksu flopilla ja missi", 84/100d, -8.5d)
          ::E)
      ::E) ::
      Branch("Ohi", 29.8/100d, 
          Leaf("kippi", 1/1d, -3d) ::E)
      ::E)
  }.value
  println("Arvo: " + value)
  println("Kannattaako pienimmillä pareilla maksaa koska arvo ei ole osumisessa, vaan taitavassa postflop pelissä?")

}