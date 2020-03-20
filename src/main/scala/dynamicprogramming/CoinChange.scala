package dynamicprogramming

import java.io.PrintWriter

import scala.io.StdIn

object Solution {
  // def memoize[I, O](formula: I => O): I => O = {
  //   var memo = Map.empty[I, O]
  //   def recur(n: I): O = {
  //     if(memo contains n) {
  //       memo(n)
  //     } else {
  //       val result = formula(n)
  //       memo += (n -> result)
  //       result
  //     }
  //   }
  //   recur
  // }

  // def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
  //   override def apply(key: I) = getOrElseUpdate(key, f(key))
  // }

  // lazy val getWays: ((Long, Array[Long])) => Long = memoize {
  //   case (n: Long, c: Array[Long]) =>
  //     if (n == 0) 1
  //     else if (n < 0 || c.length == 0) 0
  //     else getWays(n - c.head, c) + getWays(n, c.tail)
  // }

  // def getWays(n: Long, c: Array[Long]): Long = {
  //   if (n == 0) 1
  //   else if (n < 0 || c.length == 0) 0
  //   else getWays(n - c.head, c) + getWays(n, c.tail)
  // }

  def getWays(n: Long, c: Array[Long]): Long = {
    if (n == 0) 1
    else if (n < 0 || c.length == 0) 0
    else getWays(n - c.head, c) + getWays(n, c.tail)
  }

  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val m = firstMultipleInput(1).toInt

    val c = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toLong)

    val ways = getWays(n, c)

    printWriter.println(ways)

    printWriter.close()
  }
}
