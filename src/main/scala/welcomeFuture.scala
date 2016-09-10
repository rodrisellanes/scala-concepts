import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

/**
  * Created by rdsel on 9/9/2016.
  */
object welcomeFuture extends App {

  println((80 to 90).contains(9))

  type CoffeeBeans = String
  type GroundCoffee = String
  type CoffeePowder = String
  case class Water(temperature: Int)
  type Milk = String
  type Espresso = String

  case class GrindingException(msg: String) extends Exception(msg)

  def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
    println("start grinding...")
    Thread.sleep(Random.nextInt(2000))
    if (beans == "baked beans") throw GrindingException("are you joking?")
    println("finished grinding...")
    s"ground coffee of $beans"
  }
  val coffee1 = grind("Arabian")

  def heatWater(water: Water): Future[Water] = Future {
    println("The water is heating on the stove")
    Thread.sleep(50)
    println("The water is ready, 85 C degree")
    water.copy(temperature = 85)
  }

  val hotWater = heatWater(Water(25))

  def mixAllTogether(coffe: CoffeePowder, water: Water, milk: Milk): Future[Espresso] = Future {
    println("Mixing all ingredients together... almost ready")
    Thread.sleep(60)
    println("Is ready")
    "Espresso"
  }

  mixAllTogether("Nestle Strong", Water(25), "Full Fat Milk")

  // Mapping the future

  val temperatureOkay: Future[Boolean] = heatWater(Water(25)).map { water =>
    println("we're in the future!")
    (80 to 85).contains(water.temperature)
  }

  // For Comprehensions
  val acceptable: Future[Boolean] = for {
    heatedWater <- heatWater(Water(25))
    okay <- temperatureOkay
  } yield okay


  
}
