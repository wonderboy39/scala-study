# 함수
## 스칼라에서의 함수  
스칼라는 함수형언어이기 때문에 함수자체가 차지하는 비중이 매우 크다. 객체지향언어에서 사용하는 함수, 즉 메서드와는 용도가 다르다. 이에 대해 먼저 정리해보고 넘어가보고자 한다.  
#### 1) 객체지향 언어에서의 함수 vs 함수형 언어인 scala에서의 함수
객체지향 언어에서의 함수는 어떠한 행동을 하기 위한 Method, 즉 수단의 개념이었으며, 함수 그 자체가 객체는 아니었다. 객체 안에 존재하면서 어떠한 동작만을 기술해놓은 멤버의 역할을 수행했다.  
  
함수형 언어에서 함수는 상태를 바꾸어 버리는 side-effect를 지양한다. javascript,python의 함수가 일급객체의 개념이며, 상태의 변경을 방지하기 위해 클로저가 존재한다는 것을 상기한다면 이해햐기 쉽다.  
  
함수형 프로그래밍 언어인 스칼라에서는 함수 자체를 전달하고 반환받을 수 있다. 함수 자체가 객체가 될 수 있다. 스칼라에서 함수는 필요하다면 언제든지 =>로 표현되는 식을 통해 객체처럼 행동할 수 있다.  
*(정리해놓은 내용이 너무 추상적!! - javascript 공부할때 배웠던 일급객체 개념, 클로져, python책도 참고해서 위 부분을 조금 더 구체적으로 정리할 것!!!)*  

## 함수를 정의하는 법, 반환형
#### 함수의 정의방법
함수는 def 키워드를 통해 만들수 있다.  
ex)
```scala
def 함수명([매개변수]) : [반환 자료형] = {
  // do something...
}
```

#### 스칼라 함수의 반환형, 매개변수의 타입지정  
변수의 타입을 지정할 때, 함수의 반환형을 지정하고자 할 때 :[반환형]의 형태로 지정한다. 모든 변수의 타입지정은 :[반환형]을 사용한다.  
ex)
```scala
def main (args : Array[String]) : Unit = {
  println("Hello, it's function.")
}
```
Unit은 자바의 void자료형과 같다.  
  
#### 스칼라 함수 선언,정의시 주의점
스칼라에서는 반환값이 있을 경우에도 반환 자료형을 생략하는 것이 가능하다. 하지만, 아직 스칼라를 배운지 얼마되지 않은 시점에서 생각되는 바로는 반환형, 변수의 타입을 생략하는 방식은 java의 Generic이나, c++의 Template처럼 입력값, 반환형에 의존하지 않고 어떠한 입력값에도 같은 결과(ex. ArrayList < E > 의 add(Object)등등)를 낼 수 있도록 사용할 경우에만 반환형, 변수타입을 생략하는 것이라 추측한다. (apply()함수 등등)  
  
타입이 정해지지 않은 변수를 무분별하게 사용할 경우 IDE등에서 compiler가 직접 Background로 타입추론을 수행할 때 부하를 일으키기도 하며, 공동작업에서 협업의 어려움을 느낄수 있다. (현재 보고 있는 클래스의 변수가 어디서 어느 타입을 사용하는지 알길이 없다는 점, 예기치 않은 오류를 낼수 있다는점, 문서화가 어렵다는 점 때문이다.) 정말 일반화되어 목적이 분명한 Generic한 로직이 아니라면 굳이 차지할 메모리공간을 묵시적으로 생략할 필요는 없다고 본다... 그냥 내 생각...  
ex)
```scala
object Test {
  def main ( args : Array[String]) = {
    println("반환받은 값 : " + greeting() )
  }
  
  def counting() = {
    val cnt = 10
    cnt  // return cnt와 동일한 표현이다. 되도록이면 이러한 표현을 피하자.
  }
}
```
scala에서의 함수의 사용방식들이 기존의 java등의 언어와 다른점을 정리해보면 아래와 같다.
 * 함수에서 return키워드는 생략할 수 있다.  
 * 함수 바디를 생략할 수 있다. 스칼라의 함수에서 {}의 의미는 뒤에서 정리하겠음.  

참고)
```scala
def counting() : Int = {
  val cnt = 39 // 에러가 안나려면 val cnt : Int = 39;와 같이 표현해야 한다.
  return cnt // 컴파일 에러
}
```
위 코드의 경우 에러를 낸다. cnt의 경우 변수의 자료형이 결정되지 않았음에도 Int타입으로 반환하려 하고 있다. 따라서 에러를 발생시킨다.  

참고)
아래 함수의 경우에는 에러가 아니다.
```scala
object Test{
  def main (args : Array [String]) : Unit = {
    val result = multiply(1,2)
    println(result)
  }
  
  def multiply(left :Int, right :Int) : Int = {
    /*
    result = left * right
    result
    */
    left * right
  }
}
```
함수의 반환형, 매개변수의 타입을 모두 지정해주었기 때문에 return키워드를 굳이 사용할 필요가 없어도 되기 때문에 생략했다. 아마도 이 정도까지는 생략해도 되지 않을까 싶다.  

위의 방식은 아래와 같이 함축적으로 표현할수도 있다.  
```scala
def multiply ( left : Int, right : Int) : Int = left * right
```
매개변수의 타입을 명확히 지정했고, return 타입 또한 명시적으로 지정했다. 따라서 컴파일러가 불필요한 타입추론을 수행하지도 않고, 축약형으로 선언한 return 값이 무엇인지도 알 수 있다.  
  
## CALL BY NAME 함수  
스칼라에서는 함수를 아래의 두가지 방식으로 호출가능하다.
 * call by value  
 * call by name  
call by value는 일반적인 함수형태이다. (ex. avg(sum(x)))  
call by name 은 함수자체가 인자값으로 넘겨지는 형태이다. sum함수 자체가 avg함수의 인자로 넘어가는 형태이다.  

아래의 예는 일반적으로 자주 쓰이는 call by value방식의 함수다.  
```scala
package org.basic.functions

object CallByValue {
  def main (args:Array[String]) : Unit = {
    println("result :: " + avg(sum(10), 2))
  }
  
  def sum ( n: Int ) : Int = {
    println("start of sum() ===")
    var result :Int = 0
    for(i<-1 to 10){
      result = result + i
    }
    return result
  }
  
  def avg ( sum : Int , cnt : Int ) : Float = {
    println("start of avg() ===")
    var result : Float = 0.0f
    result = (sum : Float) / cnt
    println("end of avg() ===")
    return result
  }
}
/*
start of sum() ===
start of avg() ===
end of avg() ===
result :: 27.5
*/
```

아래의 예는 함수자체를 인자로 받는 call by name 형식의 함수다. (c언어의 함수포인터를 할당하는 것을 생각해도 된다. 하지만 함수를 인자로 전달함을 나타내는 선언을 수행시 사용하는 연산자는 꼭 지켜야한다.)
```scala
package org.basic.functions

object CallByFunc {
  def main ( args : Array[String] ) : Unit = {
    println("avg :: " + avg(2, sum(10)))
  }
  
  def sum ( n : Int ) : Int = {
    println("start of sum() ===")
    var result : Int= 0
    for(i<-1 to n){
      result = result + i
    }
    return result
  }
  
  def avg ( cnt : Int, n: => Int ) : Float= {
    println("start of avg() ===")
    var result : Float = 0.0f
    result = (n:Float) / cnt
    println("end of avg() ===")
    return result
  }
}
/*
출력결과 :
start of avg() ===
start of sum() ===
end of avg() ===
avg :: 27.5
*/
```

스칼라에서 call by name으로 호출되는 함수는 호출하는 함수가 매개변수를 필요로 할때마다 계속 부름을 당한다. 인자로 들어간 함수의 리턴값이 인자로 들어가는 것이 아닌, 함수의 코드 자체가 매개변수로 전달되므로 출력결과에서 보이듯이 avg() 수행 도중에 sum()함수를 수행한다. call by value일 경우 단순 값 전달이기 때문에 이러한 출력이 나오지 않는다. 마치 c언어에서 함수에 매개인자로 함수포인터를 전달받아 함수 내부에서 그 함수 포인터의 코드를 수행시키는 방식과 유사해보인다.  

=>는 객체로 생각하고 봐야 한다. 스칼라에서는 매개변수로 함수 자체를 넣어줄 수 있기 때문에 매개변수로 들어가는 함수에 대해 일반적인 함수의 표현방식을 사용하면 컴파엘에러가 나고, =>로 표현된 함수 객체로만 표현가능하다. call by name은 함수를 실행하는 것이 아니라 함수자체를 부르는 것이다.  
