package org.basic.condNIterators

object IteratorsNestedFor {
  def main(args : Array[String]) :Unit = {
//    legacyNestedFor()
    println("Nested For in scala === ")
    scalaNestedFor()
  }
  
  def legacyNestedFor() = {
    for( x<-1 until 5){
      for(y<-1 until 5){
        print(x + " * " + y + " = " + x*y )
        println("")
      }
    }
  }
  
  def scalaNestedFor() = {
    for(x<-1 until 5; y<-1 until 5){
      print(x + " * " + y + " = " + x*y )
      println("")
    }
  }
}