package org.basic.condNIterators

object IteratorsWhile {
  def main(args : Array[String]) : Unit = {
    iterUsingWhile()
    iterUsingDoWhile()
  }
  
  def iterUsingWhile() = {
    var sum :Int = 0
    var i : Int = 1
    while (i<=10){
      sum = i + sum
      i = i+1
    }
    println(sum)
  }
  
  def iterUsingDoWhile() = {
    var i = 0
    var sum = 0
    do{
      i = i+1
      sum = i + sum
    }while(i <= 10)
    
    println(sum)
  }
}