
def *(p: Double, v: Double): Double = p * v

def *(v: Double): Double = *(1d, v)

val a = *(1d, 100d)

