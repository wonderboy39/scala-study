package org.basic.condNIterators

object IteratorsWithCond {
  def main(args : Array[String] ) : Unit = {
    iterForWithcondition()
  }
  
  def iterForWithcondition() = {
    for( i<-(1 to 10) if(i%2 == 1)){
      print(i + " ")
    }
    println()
  }
}