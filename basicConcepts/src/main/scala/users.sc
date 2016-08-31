
trait User {
  def name: String
}

class userPremiun(newName: String) extends User {
  def name = newName
}

class userFree(newName: String) extends User {
  def name = newName
}

val user1 = new userPremiun("Rodrigo")
val user2 = new userFree("Juan Martin")
val user3 = new User {
  override def name: String = "Rodrigo"
}

def whichUser(user: User): String = user match {
  case usr: userPremiun => "User Premiun"
  case usr: userFree => "User Free"
}

whichUser(user1)
whichUser(user2)
//whichUser(user3)