
val list = List(1, 3, 4, 6, 7)

list.apply(3)
list(3)
list

def unapply(n: Int, arg: List[Int]): Option[Int] = Some(arg(n))

unapply(3, list)

trait User {
  def name: String
  def score: Int
}
class FreeUser(val name: String, val score: Int) extends User
class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int)] = Some(user.name, user.score)
}

object PremiunUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some(user.name, user.score)
}

FreeUser.unapply(new FreeUser("Daniel", 1000))


val user: User = new FreeUser("Rodrigo", 3000)

user match {
  case FreeUser(name, _) => "Welcome back, dear " + name
  case PremiunUser(name, _) => "Welcome back, dear " + name
}

def sum(a: Int, b: Int): Int = a + b

case class VipUser (name: String, score: Int) extends User

// This work beacuse VipUser is a case class
val tomi = VipUser.apply("Tomi", 10)

tomi match {
  case VipUser("Tomi", _) => println("Got a Tomi gay")
}

