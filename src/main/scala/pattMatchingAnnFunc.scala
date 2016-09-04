/**
  * Created by rdsel on 31/8/2016.
  */
object pattMatchingAnnFunc extends App {

  println("Test o Hello")


  val songTitles = List("One", "Other break in the wall", "Master of puppets", "Learning to live", "Morning time")
  println(songTitles.map(s => s.toLowerCase))
  println(songTitles.map(_.toLowerCase))

  val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
    ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

  // This example is perform using normal filter and map functions
  def wordsWithoutOutliers(wordFreq: Seq[(String, Int)]): Seq[String] =
    wordFreq.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1)

  println(wordsWithoutOutliers(wordFrequencies))

  // Same solution using pattern matching anonymous functions. match is not require
  // ATTENTION >> Always have to use those cases in BLOCKS {}
  def wordsWithoutOutliersCase(wordFreq: Seq[(String, Int)]): Seq[String] =
    wordFreq.filter { case (_, x) => x > 2 && x < 25 } map { case (w, _ ) => w }
  println(wordsWithoutOutliersCase(wordFrequencies))

  val predicate: ((String, Int)) => Boolean = { case (_, f) => f > 3 && f < 25 }
  println(predicate)

  // Solution using partial functions
  def wordsWithoutOutliersCase2(wordFreq: Seq[(String, Int)]): Seq[String] =
    wordFreq.collect { case (word, freq) if (freq > 2 && freq < 25) => word }

  println("Words by Partial Function: " + wordsWithoutOutliersCase2(wordFrequencies))

}
