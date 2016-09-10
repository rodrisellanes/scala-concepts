import pattMatchingAnnFunc._

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

val wordFrequencies: Seq[(String, Int)] = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
  ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

//val pf: PartialFunction[(String, Int), String]

val pf = new PartialFunction[(String, Int), String] {
  def apply(wordFrequency: (String, Int)) = wordFrequency match {
    case (word, freq) if freq > 3 && freq < 25 => word
  }
  def isDefinedAt(wordFrequency: (String, Int)) = wordFrequency match {
    case (word, freq) if freq > 3 && freq < 25 => true
    case _ => false
  }
}

wordFrequencies.collect(pf)
wordsWithoutOutliersCase(wordFrequencies)

// EXAMPLE USING PARTIAL FUNCTION

val isEven: PartialFunction[Int, String] = {
  case x if x % 2 == 0 => x + " is even"
}

val isOdd: PartialFunction[Int, String] = {
  case x if x % 2 == 1 => x + " is odd"
}

List(1, 2, 3, 4) map(isEven orElse isOdd)

// Refreshing High Order Functions (with anonymous functions)

def operationsHOF(n: Int => Int) = n
def operations(n: Int): Int = n + n

operations(5)
operationsHOF(x => x + 4).apply(2)
operationsHOF(x => x * 2).apply(2)


val words = List("HI", "BYE", "GOOD", "WARCRAFT")

words map(w => if(w.contains("WAR")) w else "No match") foreach(println)


def functTest(f: Int): Unit = println(s"F value is $f")
functTest(20)

val future = Future { Thread.sleep(500) ; 26 }
future.isCompleted

println(s"I'm a future $future")
Thread.sleep(500)

future.isCompleted
println(s"I'm a future $future")