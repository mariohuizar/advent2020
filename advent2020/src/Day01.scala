import zio._
import scala.io.Source

object Day01 extends zio.App {

  val readInput = Task.effect(Source.fromFile("advent2020/src/resources/Day01Input.txt").getLines.toList.map(_.toInt))

  def find2020Sum(input: List[Int]): Int = {
    def loop(input: List[Int], current: Int): Int  = {
      input match {
        case x :: y :: xs =>
          val toFind = 2020 - current
          if (input.contains(toFind)) {
            println(s"result: ${current * toFind}")
            current + toFind
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

  def run(args: List[String]) = readInput.map(find2020Sum).exitCode
}

