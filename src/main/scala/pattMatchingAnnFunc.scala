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

  def wordsWithoutOutliers(wordFreq: Seq[(String, Int)]): Seq[String] =
    wordFreq.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1)

  println(wordsWithoutOutliers(wordFrequencies))


}
