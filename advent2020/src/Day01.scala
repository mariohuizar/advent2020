import zio._
import zio.console._

import scala.io.Source

object Day01 extends zio.App {
  private val readInput = zio.blocking.effectBlocking {
    val source = Source.fromFile("advent2020/src/resources/Day01Input.txt")
    try source.getLines().toList.map(_.toInt) finally source.close()
  }

  def find2020Sum(input: List[Int]): Int = {
    def loop(input: List[Int], current: Int): Int = {
      input match {
        case x :: y :: xs =>
          val toFind = 2020 - current
          if (input.contains(toFind)) {
            current * toFind // we found the answer!
          } else {
            loop(xs, y)
          }
        case _ => 0
      }
    }

    input match {
      case x :: xs => loop(xs, x)
      case _ => 0
    }
  }

  def run(args: List[String]) =
    readInput.map(find2020Sum).flatMap(r => putStrLn(r.toString)).exitCode
}
