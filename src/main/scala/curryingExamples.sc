

/* CURRYING (Functions than return other Functions */

def sum2(f: Int => Int): (Int, Int) => Int = {
  def oneFunct(a: Int, b: Int): Int = {
    f(a) + f(b)
  }
  oneFunct
}

sum2(x => x * x)
sum2(x => x * x)(2, 4)
