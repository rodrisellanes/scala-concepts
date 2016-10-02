/**
  * Created by rdsel on 1/10/2016.
  */
object factorial extends App {

  // Factorial using tail recursive

  def factorial(num: Int): Int = {
    require(num >= 0, "The nummber must be grater than 0")
    def calculateFact(num: Int, count: Int, acc: Int): Int = {
      if(num == 0) acc
      else calculateFact(num - 1, count + 1, acc * count)
    }
    calculateFact(num, 1, 1)
  }
  println(factorial(5))

  // Factorial using just recursive

  def factorial2(num: Int): Int = {
    if(num == 0) 1
    else num * factorial2(num - 1)
  }
  println(factorial2(5))

  // Factorial keeping al operations in a List

  def factorialList(num: Int, count: Int = 1, acc: BigInt = 1): List[BigInt] = {
    if(count > num) Nil
    else acc * count :: factorialList(num, count + 1, acc * count)
  }
  println(factorialList(5))




}
