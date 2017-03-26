package org.basic.condNIterators

object IfElse {
  def main(args : Array[String]) : Unit = {
    var testOdd = 5
    if(testOdd %2 == 1){
      println("홀수 입니다")
    }
    else if(testOdd %2 == 0){
      println("짝수 입니다.")
    }
    else{
      println("음수나 비정상적인 값을 입력하셨군요.")
    }
  }
}