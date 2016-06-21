package hello

/**
  * Created by Administrator on 14/06/2016.
  */
object MultiDimensionalArray {

  val a = Array.ofDim[Int](4,4,4)

  a(0)(0)(0) = 1
  a(0)(0)(1) = 2
  a(0)(0)(2) = 3
  a(0)(0)(3) = 4

  a(0)(1)(0) = 5
  a(0)(1)(1) = 6
  a(0)(1)(2) = 7
  a(0)(1)(3) = 8

  a(0)(2)(0) = 9
  a(0)(2)(1) = 10
  a(0)(2)(2) = 11
  a(0)(2)(3) = 12

  a(0)(3)(0) = 13
  a(0)(3)(1) = 14
  a(0)(3)(2) = 15
  a(0)(3)(3) = 16

  a(1)(0)(0) = 17
  a(1)(0)(1) = 18
  a(1)(0)(2) = 19
  a(1)(0)(3) = 20


  def main(args: Array[String]) {
    println(a)
  }

}
