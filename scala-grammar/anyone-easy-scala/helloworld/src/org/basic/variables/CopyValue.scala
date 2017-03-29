package org.basic.variables

object CopyValue {
  def main(args : Array[String]) : Unit = {
    var five : Int = 5
    var copyA = five
    five = 10
    println(five)
    println(copyA)
  }
}