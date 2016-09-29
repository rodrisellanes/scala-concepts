import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm

/* CURRYING (Functions than return other Functions */

def sum2(f: Int => Int): (Int, Int) => Int = {
  def oneFunct(a: Int, b: Int): Int = {
    f(a) + f(b)
  }
  oneFunct
}

sum2(x => x * x)
sum2(x => x * x)(2, 4)


def terrainFunction(levelVector: Vector[Vector[Char]]): (Int, Int) => String = {
  def validPosition(x: Int, y: Int): String = {
    println(levelVector.isDefinedAt(y))
    levelVector(x)(y).toString
//    levelVector.apply(x).apply(y).toString
  }
  validPosition
}

val vector2 = Vector(Vector('a', 'b', 'c'), Vector('d', 'f', 'g'), Vector('h', 'i', 'j'))
//terrainFunction(Vector(Vector('a', 'b', 'c'), Vector('d', 'f', 'g')))(0,3)

0 until vector2.size
0 until vector2(0).size

// Using for expression
val result = {
  for {
    r <- 0 until vector2.size
    c <- 0 until vector2(r).size
    if (vector2(r)(c) == 'r')
  } yield (r, c)
}

println("HIIII" + result)



// Using map and indexOf/indexWhere solution
vector2.map(row => row.indexOf('h')).indexWhere(x => x != -1)
vector2.map(col => col.indexOf('h')).find(_ != -1).get

vector2(0).indexOf('a')
vector2(0).indexWhere(x => x == 'b')
vector2.map(x => x.indexWhere(x => x == 'h'))

vector2.map(col => col.indexOf('h')).filter(_ != -1).apply(0)

val xx = vector2.map(_.indexOf('g') >= 0).indexWhere(_ == true)
vector2(xx).indexOf('g')

val testList: List[(Char, Int)] = List( ('a', 3), ('b', 19), ('c', 21), ('d', 6) )

def isLegal(num: Int): Boolean =
  if(num >= 6) true
  else false
val test = testList.filter(ls => isLegal(ls._2))

val chars = test.map(letter => letter match { case (l, _) => l})

List('t', 'h') ::: test.map(letter => letter._1)

val streamTest = ((1, 2), chars) #:: Stream.empty

List(1, 3, 4, 5, 5, 7, 8).filter(x => !(x >= 5))
