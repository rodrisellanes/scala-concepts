/**
  * Created by rdsel on 30/9/2016.
  */
object fibonacci extends App {

  def fibonacci(bound: Int): Int = {
    def fiboLoop(bound: Int, x1: Int, x2: Int): Int = {
      if (bound <= 2) x2
      else fiboLoop(bound - 1, x2, x1 + x2)
    }
    fiboLoop(bound, 1, 2)
  }
  println(fibonacci(6))


  /* Fobonacci returning a List */

  def fibonacciList(bound: Int): List[Int] = {
    def fiboLoop(bound: Int, acc: List[Int]): List[Int] = {
      if (bound <= 2) acc
      else fiboLoop(bound - 1, acc :+ (acc.last + acc.init.last))
    }
    fiboLoop(bound, List(1, 2))
  }
  println(fibonacciList(15))


  /* Fobonacci returning a Stream */

  def fibonacciStream: Stream[Int] = {
    def fiboLoop(acc: Stream[Int]): Stream[Int] =
      fiboLoop(acc :+ (acc.last + acc.init.last))
    fiboLoop(Stream(1, 2))
  }
//  println(fibonacciStream)

  lazy val fibs: Stream[BigInt] = BigInt(0) #::
    BigInt(1) #::
    fibs.zip(fibs.tail).map { n => n._1 + n._2 }

  println(fibs.take(500).toList)


}