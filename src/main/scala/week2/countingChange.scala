package week2

/**
  * Created by rdsel on 4/10/2016.
  */
object countingChange extends App {

  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if(money < 0 || coins.isEmpty) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
//  assert(countChange(6, List(1, 2)) == 4)



  def giveChange(money: Int): Int = {
    val coins = List(1, 2)
    def loopCalc(money: Int, coins: List[Int], acc: Int): Int = {

      if(money == acc) 1
      else {
        coins.map(x => (1 to money).map(y => x + )

      }
    }
  }

}
