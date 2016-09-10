import scala.util.{Failure, Success, Try}

// Anonymous functions examples

def sumValues(v: Int, f: Int => Int): Int = f(v)

sumValues(20, (x => x + 1))

// HOF using require and Error Handling (Try)
def mathOperations(a: Int, b: Int, fun: (Int, Int) => Int): AnyVal = {
  if(Try(require(b != 0)).isFailure) {
    println("B must be different to 0")
  }
  else fun(a, b)
}

def mathOperations2(a: Int, b: Int, fun: (Int, Int) => Int): Try[Int] =
  Try(fun(a, b))

def sum(a: Int, b: Int) = a + b
def subt(a: Int, b: Int) = a - b
def mult(a: Int, b: Int) = a * b
def div(a: Int, b: Int) = a / b

mathOperations(9, 0, sum)

mathOperations2(9, 0, div).getOrElse("Not division by 0")
