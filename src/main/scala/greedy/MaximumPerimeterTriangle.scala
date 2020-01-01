package greedy

object Solution {

  def maximumPerimeterTriangle(sticks: Array[Int]): Option[Array[Int]] = {
    // sticks.sorted(Ordering[Int].reverse).sliding(3, 1).foreach(a => println(a.mkString(" ")))
    sticks.sorted(Ordering[Int].reverse).sliding(3, 1).find(arr => arr.tail.sum >= arr.head)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val sticks = stdin.readLine.split(" ").map(_.trim.toInt)

    maximumPerimeterTriangle(sticks) match {
      case Some(result) => println(result.reverse.mkString(" "))
      case _ => println(-1)
    }
  }
}
