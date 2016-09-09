import java.net.URL
import scala.io.Source
import scala.util.Try

/**
  * Created by rdsel on 4/9/2016.
  */
object handlingErrors extends App {

  def parseURL(url: String): Try[URL] = Try(new URL(url))

  println(parseURL("http://danielwestheide.com").map(_.getProtocol))
  println(parseURL("garbage").map(_.getProtocol))


  /* --- EITHER --- */

  def getContent(url: URL): Either[String, Source] =
    if (url.getHost.contains("google"))
      Left("Requested URL is blocked for the good of the people!")
    else
      Right(Source.fromURL(url))

  getContent(new URL("http://www.google.com")) match {
    case Left(msg) => println(msg)
    case Right(source) => source.getLines.filter(word => word != "<!-- //FOOTER -->").foreach(println)
  }

  println(getContent(new URL("http://www.google.com")).isLeft)
  println(getContent(new URL("http://www.google.com")))

  type Citizen = String
  case class BlackListedResource(url: URL, visitors: Set[Citizen])

  val blacklist = List(
    BlackListedResource(new URL("https://google.com"), Set("John Doe", "Johanna Doe")),
    BlackListedResource(new URL("http://yahoo.com"), Set.empty),
    BlackListedResource(new URL("https://maps.google.com"), Set("John Doe")),
    BlackListedResource(new URL("http://plus.google.com"), Set.empty)
  )

  val checkedBlacklist: List[Either[URL, Set[Citizen]]] =
    blacklist.map(resource =>
      if (resource.visitors.isEmpty) Left(resource.url)
      else Right(resource.visitors))

  println(checkedBlacklist)
}
