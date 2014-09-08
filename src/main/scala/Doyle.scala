package eu.route20.doyle

trait Doyle {

  def *(p: Double, v: Double): Double = p * v

  def *(v: Double): Double = *(1d, v)

  def %(v1: Double*): Double = v1.foldLeft(0d)(_ + _)

}
