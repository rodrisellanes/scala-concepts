
val numbers = 1 :: 3 :: 5 :: Nil

numbers match {
  case List(a, b) => a * b
  case List(a, b, c) => a + b + c
  case _ => 0
}

// It doesn't work because
numbers match {
  case a :: b => a * b.head
  case _ => 0
}

case class Player(name: String, score: Int)
class Student(val name: String, val score: Int)

object Student {
  def unapply(std: Student): Option[(String, Int)] = Some(Studentstd.name, (String, Int)std.score)
}

def printMessage[T](player: T) = player match {
  case Player(name, score) if(score <= 4) => println("Student " + name + " has to study more")
  case Player(name, _) => println("Good job dude!")
  case Student(_, _) => println("Welcome back friend, happy to see you again")
}

val player1 = Player("Rodrigo", 7)
val player2 = Player("Robert", 4)
val student1 = new Student("John", 10)

printMessage(player1)
printMessage(player2)

printMessage(student1)


def gameResults(): Seq[(String, Int)] = ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil

def hallOfFame = for {
  result <- gameResults()
  (name, score) = result
  if (score > 5000)
} yield name


val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

for {
  list @ head :: _ <- lists
} yield list.size
