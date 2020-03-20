package recursion

import java.io._

object PowerSum {
  def powerSum(target: Int, exponent: Int): Int = {
    def pf(x: Int, curr: Int): Int = {
      val next = Math.pow(curr, exponent).toInt
      if (x == 0) 1
      else if (next > x) 0
      else pf(x - next, curr + 1) + pf(x, curr + 1)

    }
    pf(target, 1)
  }

  // def powerSum(target: Int, exponent: Int): Int = {
  //   def pf(x: Int, curr: Int): Int = {
  //     val next = Math.pow(curr, exponent).toInt
  //     if (x == 0) 1
  //     else if (next <= x) {
  //       pf(x - next, curr + 1) + pf(x, curr + 1)
  //     }
  //     else 0
  //   }
  //   pf(target, 1)
  // }

  // def powerSum(target: Int, exponent: Int): Int = {
  //   def pf(x: Int, curr: Int): Int = {
  //     val next = Math.pow(curr, exponent).toInt
  //     if (x == target) 1
  //     else if (x < target && next < target) 0
  //     else {
  //       pf(x + next, curr + 1) + pf(x, curr + 1)
  //     }
  //   }
  //   pf(0, 1)
  // }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val X = stdin.readLine.trim.toInt

    val N = stdin.readLine.trim.toInt

    val result = powerSum(X, N)

    printWriter.println(result)

    printWriter.close()
  }
}

