package org.basic.condNIterators

object IteratorsFor {
  def main(args:Array[String]):Unit = {
    forIterUsingTo()
    forIterUsingUntil()
  }
  def forIterUsingTo() = {
    var sum :Int = 0
    for(i<-1 to 10){
      sum = i+ sum
    }
    println(sum)
  }
  
  def forIterUsingUntil() = {
    var sum :Int= 0
    for(i<-1 until 10){
      sum = i + sum
    }
    println(sum)
  }
}