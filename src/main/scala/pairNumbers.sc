// Four different ways to get pairNumbers from a List[Int]

val numbs = List(1, 4, 6, 3, 7, 8, 10, 33, 2)

def pairNumbs(nums: List[Int]): List[Int] = {
  for {
    num <- numbs
    if(num % 2 == 0)
  } yield num
}

pairNumbs(numbs)

// PairNumber but in the recursive way

def pairNumberRec(nums: List[Int]): List[Int] = {
  if(nums.isEmpty) Nil
  else if(nums.head %2 == 0) nums.head :: pairNumberRec(nums.tail)
  else pairNumberRec(nums.tail)
}

pairNumberRec(numbs)

// PairNumber but in the pattern matching way
def pairNumberCase(numbers: List[Int]): List[Int] = numbers match {
  case Nil => Nil
  case a :: b if(a %2 == 0) => a :: pairNumberCase(b)
  case _ :: b => pairNumberCase(b)
}

pairNumberCase(numbs)

// Using list method "filter" NUMBERS.filer(anonymous function)
numbs.filter(num => num %2 == 0)

