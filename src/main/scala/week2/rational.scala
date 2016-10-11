package week2

/**
  * Created by rdsel on 3/10/2016.
  */
object rational extends App {

  val r1 = new Rational(1, 2)
  val r2 = new Rational(1, 3)


  class Rational(n: Int, d: Int) {

    def numer = n
    def denom = d

    def add(that: Rational) =
      new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

    def neg = new Rational(-numer, denom)

    // Dry principle "Don't Repeat Yourself"
    def sub(that: Rational) = add(that.neg)

    override def toString =
      numer + "/" + denom
  }

  println(r1 + " " + r2)

  val sumResult = r1.add(r2)
  val subResult = r1.sub(r2)

  println(sumResult + "\n" + subResult)
}
