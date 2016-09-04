/**
  * Created by rdsel on 4/9/2016.
  *
  * OPTION -> IMPORTANT!!! can be treated as a collection map, flatMap, filter and other methods
  *           and "For comprehensions"
  *
  */
object optionTypes extends App {

  val greeting: Option[String] = Some("Hello Rodrigo")
  println(greeting)

  val emptyGreeting: Option[String] = None
  println(emptyGreeting)

  val absentGreeting: Option[String] = Option(null)
  println(absentGreeting)

  val presentGreeting: Option[String] = Option("I'm back!!")
//  println(presentGreeting)

  lazy val nullOption: Option[String] = Option("I'm Lazy val")
//  println(nullOption)

  case class User (
    id: Int,
    firstName: String,
    lastName: String,
    age: Int,
    gender: Option[String]
    )

  object UserRepository {
    private val users = Map(1 -> User(1, "John", "Doe", 29, Some("male")),
                            2 -> User(2, "Martin", "Dow", 20, None),
                            3 -> User(3, "Susan", "Daft", 30, Some("female")))

    def findByIde(id: Int): Option[User] = users.get(id)
    def findAll = users.values

  }

  val user1 = UserRepository.findByIde(1)
//  val user2 = UserRepository.users // This doesn't work because users is private
  if(user1.isDefined) {
    println(user1.get.firstName)
  }

  val allUsers = UserRepository.findAll
  println(allUsers)

  // GIVING DEFAULT VALUES -> Trying to get the parameter, or otherwise returning default value "not specified"
  val speUser = User(3, "Rodrigo", "Trung", 26, None)
  println("Gender: " + speUser.gender.getOrElse("Not specified"))

  // Using Pattern Matching
  val user4 = User(4, "Mickel", "Row", 63, Some("Male"))
  user4.gender match {
    case Some(gender) => println("Gender: " + gender)
    case None => println("The gender is undefined")
//  case _ => println("Gender: " + user4.gender)
  }

  def userGender(usr: User): String = {
    usr.gender match {
      case Some(gender) => usr.firstName + " --> " + gender
      case None => "Gender undefined value"
    }
  }
  println(userGender(user4))

  //  =====  VERY IMPORTANT TOOL "foreach", WORKING WITH MAP =====
  UserRepository.findAll.foreach(user => println(user.firstName))

  // Using map method (collection)
  println(UserRepository.findByIde(4).map(_.age)) // Get None because nos user 4 exist in UserRepository

  // Using flatMap method (collection)
  /*If we use flatMap, the mapped elements of the inner lists
  are converted into a single flat list of strings. Obviously,
  nothing will remain of any empty inner lists.*/
  println(UserRepository.findByIde(1).flatMap(_.gender))

  // Using filter
  println("" + UserRepository.findByIde(1).filter(_.age > 20).get.firstName)

  // For comprehensions
  for {
    user <- UserRepository.findByIde(1)
    gender <- user.gender
  } yield println(gender)

  for {
    user <- UserRepository.findAll
    gender <- user.gender
  } yield println(gender)



}
