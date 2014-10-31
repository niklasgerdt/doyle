package doyle

trait Doyle {

  def *(p: Double, v: Double): Double = p * v

  def *(p: Double, v: Double, desc: String): Double = *(p, v)

  def *(v: Double): Double = *(1d, v)

  def %(v1: Double*): Double = v1.foldLeft(0d)(_ + _)

  def %(v1: Double, desc: String): Double = %(v1)

  def <(b: Double, p: Double, v: Double) = 100 * p * (v - b)
}

