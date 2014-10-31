package doyle.usage

import doyle.old._

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


object CallingWithSmallPocketPairs extends Game {
  var value = 0d

  value = {
    Case("Vastustaja korottaa tiukasti (99+,XJ+) ja maksat pikkuparilla tehdäksesi setin.",
      Branch("Osut settiin", 1 / 8.5d,
        Branch("hänellä pari lähtökätenä", 36 / 132d,
          Leaf("hän tekee setin", 1 / 100d, -100d) ::
            Leaf("voitat ok potin yliparia vastaan", 99 / 100d, 35d) :: E) ::
          Branch("hänellä korkeat kortit piilossa", 96 / 132d,
            Leaf("hän tekee parin ja voitat ok potin", 1 / 4d, 35d) ::
              Leaf("hän missaa ja jatkobluffaa", 3 / 4d, 8.5d) :: E) :: E) ::
        Leaf("missaat ja häviät alkumaksun", 7.5 / 8.5d, -3d) :: E)
  }.value
  println("Arvo: " + value)
  println("Edes näin tiukkaa vastustajaa vastaan et voi vain maksaa setin takia kannattavasti.")

  value = {
    Case("Vastustaja korottaa tiukasti (99+,XJ+) ja maksat pikkuparilla tehdäksesi setin. Jatkat peliä maksamalla jatkobetsin hyvällä flopilla",
      Branch("Osut settiin", 1 / 8.5d,
        Branch("hänellä pari lähtökätenä", 36 / 132d,
          Leaf("hän tekee setin", 1 / 100d, -100d) ::
            Leaf("voitat ok potin yliparia vastaan", 99 / 100d, 35d) :: E) ::
          Branch("hänellä korkeat kortit piilossa", 96 / 132d,
            Leaf("hän tekee parin ja voitat ok potin", 1 / 4d, 35d) ::
              Leaf("hän missaa ja jatkobluffaa", 3 / 4d, 8.5d) :: E) :: E) ::
        Branch("missaat ja maksat jatkobetsin hyvällä flopilla", 7.5 / 8.5d,
          Branch("maksat jatkobetsin puolet kerroista", 1 / 2d,
            Branch("Vastustajalla pari lähtökätenä", 32 / 132d,
              Leaf("häviät myös jatkobetsin", 1 / 1d, -8.5d) :: E) ::
              Branch("Vastustajalla korkeat lähtökortit", 96 / 132d,
                Branch("Tekee parin flopilla", 1 / 3d,
                  Leaf("Tekee parin flopilla", 1 / 1d, -8.5d) :: E) ::
                  Branch("jatkobetsi ylikorteilla", 2 / 3d,
                    Leaf("mutta vetää ohi", 1 / 4d, -8.5d) ::
                      Leaf("parisi pitää", 3 / 4d, 11d) :: E) :: E) :: E) ::
            Branch("kippaat jatkobetsiin", 1 / 2d,
              Leaf("kippi", 1 / 1d, -3d) :: E) :: E) :: E)
  }.value
  println("Arvo: " + value)
  println("et voi pelata fit-or-fold peliä pikkupareilla,  vaan joudut riskeeraamaan sopivilla flopeilla (korkein kortti J). Entä, jos hän jatkobetsaa usein turnilla?")

  value = {
    Case("Vastustaja korottaa normaalisti (55+, XJ+, XTs+, 76s+) ja maksat pikkuparilla tehdäksesi setin. Jatkat peliä maksamalla jatkobetsin hyvällä flopilla",
      Branch("Osut settiin", 1 / 8.5d,
        Branch("hänellä pari lähtökätenä", 60 / 188d,
          Leaf("hän tekee setin", 1 / 100d, -100d) ::
            Leaf("voitat ok potin yliparia vastaan", 99 / 100d, 35d) :: E) ::
          Branch("hänellä korkeat kortit piilossa", 128 / 188d,
            Leaf("hän tekee parin ja voitat ok potin", 1 / 4d, 35d) ::
              Leaf("hän missaa ja jatkobluffaa", 3 / 4d, 8.5d) :: E) :: E) ::
        Branch("missaat ja maksat jatkobetsin hyvällä flopilla", 7.5 / 8.5d,
          Branch("maksat jatkobetsin puolet kerroista", 1 / 2d,
            Branch("Vastustajalla korkeampi pari lähtökätenä", 42 / 188d,
              Leaf("häviät myös jatkobetsin", 1 / 1d, -8.5d) :: E) ::
              Branch("vastustallasi matalampi pari lähtönä", 18 / 188d,
                Leaf("vastustallasi matalampi pari lähtönä", 1 / 1d, 11d) :: E) ::
              Branch("Vastustajalla korkeat lähtökortit", 128 / 188d,
                Branch("Tekee parin flopilla", 1 / 3d,
                  Leaf("Tekee parin flopilla", 1 / 1d, -8.5d) :: E) ::
                  Branch("jatkobetsi ylikorteilla", 2 / 3d,
                    Leaf("mutta vetää ohi", 1 / 4d, -8.5d) ::
                      Leaf("parisi pitää", 3 / 4d, 11d) :: E) :: E) :: E) ::
            Branch("kippaat jatkobetsiin", 1 / 2d,
              Leaf("kippi", 1 / 1d, -3d) :: E) :: E) :: E)
  }.value
  println("Arvo: " + value)
  println("Kannattaako pienimmillä pareilla maksaa koska arvo ei ole osumisessa, vaan taitavassa postflop pelissä?")

  value = {
    Case("Vastustaja korottaa löysästi (22+, XT+, A2+, 54s+, 64s+) ja maksat pikkuparilla",
      Branch("Osut settiin", 1 / 8.5d,
        Branch("hänellä pari lähtökätenä", 78 / 410d,
          Leaf("hän tekee setin", 1 / 100d, -100d) ::
            Leaf("voitat ok potin yliparia vastaan", 99 / 100d, 45d) :: E) ::
          Branch("hänellä korkeat kortit piilossa", 332 / 410d,
            Leaf("hän tekee parin ja voitat ok potin", 1 / 4d, 45d) ::
              Leaf("hän missaa ja jatkobluffaa", 3 / 4d, 8.5d) :: E) :: E) ::
        Branch("missaat ja maksat jatkobetsin hyvällä flopilla", 7.5 / 8.5d,
          Branch("maksat jatkobetsin puolet kerroista", 1 / 2d,
            Branch("Vastustajalla korkeampi pari lähtökätenä", 42 / 410d,
              Leaf("häviät myös jatkobetsin", 1 / 1d, -8.5d) :: E) ::
              Branch("vastustallasi matalampi pari lähtönä", 36 / 410d,
                Leaf("vastustallasi matalampi pari lähtönä", 1 / 1d, 11d) :: E) ::
              Branch("Vastustajalla korkeat lähtökortit", 332 / 410d,
                Branch("Tekee parin flopilla", 1 / 3d,
                  Leaf("Tekee parin flopilla", 1 / 1d, -8.5d) :: E) ::
                  Branch("jatkobetsi ylikorteilla tai vedolla tai bluffina", 2 / 3d,
                    Leaf("mutta vetää ohi", 1 / 4d, -8.5d) ::
                      Leaf("parisi pitää", 3 / 4d, 11d) :: E) :: E) :: E) ::
            Branch("kippaat jatkobetsiin", 1 / 2d,
              Leaf("kippi", 1 / 1d, -3d) :: E) :: E) :: E)
  }.value
  println("Arvo: " + value)
  println("Kannattaako pienimmillä pareilla maksaa koska arvo ei ole osumisessa, vaan taitavassa postflop pelissä?")

  value = {
    Case("Vastustaja korottaa löysästi (22+, XT+, A2+, 54s+, 64s+) ja maksat pikkuparilla",
      Branch("Osut settiin", 1 / 8.5d,
        Branch("hänellä pari lähtökätenä", 78 / 410d,
          Leaf("hän tekee setin", 1 / 100d, -100d) ::
            Leaf("voitat ok potin yliparia vastaan", 99 / 100d, 45d) :: E) ::
          Branch("hänellä korkeat kortit piilossa", 332 / 410d,
            Leaf("hän tekee parin ja voitat ok potin", 1 / 4d, 45d) ::
              Leaf("hän missaa ja jatkobluffaa, joskus myös turnilla", 3 / 4d, 12.5d) :: E) :: E) ::
        Branch("missaat ja maksat jatkobetsin hyvällä flopilla", 7.5 / 8.5d,
          Branch("maksat jatkobetsin puolet kerroista", 1 / 2d,
            Branch("Vastustajalla korkeampi pari lähtökätenä", 42 / 410d,
              Leaf("häviät myös jatkobetsin", 1 / 1d, -8.5d) :: E) ::
              Branch("vastustallasi matalampi pari lähtönä", 36 / 410d,
                Leaf("vastustallasi matalampi pari lähtönä", 1 / 1d, 11d) :: E) ::
              Branch("Vastustajalla korkeat lähtökortit", 332 / 410d,
                Branch("Tekee parin flopilla", 1 / 3d,
                  Leaf("Tekee parin flopilla", 1 / 1d, -8.5d) :: E) ::
                  Branch("jatkobetsi ylikorteilla tai vedolla tai bluffina", 2 / 3d,
                    Leaf("mutta vetää ohi tai jatkobluffaa sinut ulos", 2 / 4d, -8.5d) ::
                      Leaf("parisi pitää", 2 / 4d, 11d) :: E) :: E) :: E) ::
            Branch("kippaat jatkobetsiin", 1 / 2d,
              Leaf("kippi", 1 / 1d, -3d) :: E) :: E) :: E)
  }.value
  println("Arvo: " + value)
  println("Satunnainen tuplajatkobetsaus ja siihen kippaaminen pitää silti välipareilla maksamisen kannattavana?")
  println("\nLoppusanat\nNormaalia etuposition korottajaa vastaan voi maksaa välipareilla, mutta maksamista täytyy jatkaa flopilla, jos se on kohtuullisen kuiva eikä paljon ylikortteja (A,K,Q).")
  println("Korotuksen tullessa myöhäisestä positiosta voit maksaa ehkä hiukan alemmilla pareilla ja jatkaa flopeilla. \nPienimmät parit eivät kuitenkaan taida olla kannattavia hyviä pelaajia vastaan, jotka eivät häviä isoja potteja kohtalaisilla käsillään")
  println("Puhtaasti setin takia maksamiseen maksun täytyy olla vähäinen (2bb) ja rahaa takana kunnolla.\nMyös positio nostaa käden arvoa.")
}

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