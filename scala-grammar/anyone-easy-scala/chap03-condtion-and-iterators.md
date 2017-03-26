# 조건문과 반복문  
## 1.조건문
#### 1) if/ else if/ else문
if, else if, else문은 c, java등 다른 프로그램 언어에 비교했을때 크게 다른 점이 없다.
ex)
```scala
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
```
## 2.반복문
c,java등의 언어들과 비슷하게 for, while, do~while을 사용할 수 있다. 각각의 경우를 들어보면 아래와 같다.
#### 1) for
for문 내부에서 변수의 시작의 시작에서 끝까지의 구간을 설정하는 방식은 c,java와는 다르다. 우선 for문 안에서 반복문 내에서 사용되는 구간변수 설정시 i<-0과 같이 표현한다. for문안에서 임시변수를 선언및 초기화하는 경우 <-키워드를 사용하는 듯하다. 이에 대해서는 예제를 통해서 정리해본다. <-키워드는 차차 공부해가면서 같은 연산자가 나오면 정리해봐야 할듯하다.  

또한 scala의 for문내에서 index를 증가시키는 방식은 아래와 같이 총 세가지 이다.  
> for( x<-1 to 10) {....}
> for( x<-1 until 10) {...}
> for( (num,index) <- List.zipWithIndex ) {...}

#### for (x<-1 to 10)의 방식  
for문의 each step을 구분할 변수의 구간 설정시 to를 사용할 경우 to키워드는 c,java에서 사용하는 비교 연산자 <= 와 같은 역할을 수행한다.
```scala
package org.basic.condNIterators

object IteratorsFor {
  def main(args:Array[String]):Unit = {
    forIterUsingTo()
  }
  def forIterUsingTo() = {
    var sum :Int = 0
    for(i<-1 to 10){
      sum = i+ sum
    }
    println(sum)
  }
}
/*
출력결과
55
*/
```

#### for( x<-1 until 10)의 방식  
for문의 each step을 구분할 변수의 구간 설정시 until을 사용할 경우 until키워드는 c,java에서 사용하는 비교연산자 < 와 같은 역할을 수행한다.
```scala
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
/*
출력결과
55
45
*/
```

#### 인덱스가 있는 for문 : for( (num,index) <- List.zipWithIndex )
반목문 사용시 인덱스가 필요할 경우 아래와 같은 방식을 사용한다.
```scala
for( (num, index) <- List.zipWithIndex ){
  println(num)
  println(index)
}
```

#### 2) while, do while
while, do while은 c, java와 다른 것이 거의 없다. 자세한 표현방식은 예제를 참고해보자
ex) while문의 사용예
```scala
package org.basic.condNIterators

object IteratorsWhile {
  def main(args : Array[String]) : Unit = {
    iterUsingWhile()
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
}
/*
출력결과
55
*/
```

ex) do~while 사용예
```scala
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
/*
출력결과
55
66
*/
```

#### 3) 이중 for문의 사용
c, java에서 사용하는 방식의 이중 for를 스칼라에서도 사용할 수 있다. 하지만 스칼라에도 추가된 중첩된 for문의 형식을 예제로 남겨보면 아래의 형태를 가진다. 두번째 이후의 반복문의 each step을 의미하는 변수의 시작과 끝 구간을 단순히 한번더 나열하는 것으로 끝난다.

ex)
```scala
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
```

#### 4) 조건문을 가진 반복문
for문내에 조건문을 사용해야 하는 경우가 있다. 이 경우 어떤식으로 표현하는지 예를 통해 알아보자
```scala
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
/*
출력결과
1 3 5 7 9 
*/
```

