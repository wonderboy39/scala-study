## Scala 시작하기.
##### 1. 개발환경설정  
  
##### 2. Hello World
ex)
```scala
package org.basic.structure

object Ex01 {
  def main (args: Array[String]) : Unit={
    println("hello")
  }
}
```
* Ex01이라는 object를 생성했다. scala에서 object는 오직하나만 존재하는 객체이다.
* 함수의 선언은 def키워드를 통해 한다.
* 매개인자의 선언은 매개변수 이름 : 타입, 매개변수 이름2, 타입2, ... 등으로 이루어질 수 있다.
* 함수의 반환형은 함수 머리의 맨 뒤에 :반환형 으로 선언하여 사용할 수 있다.
* Unit은 java나 c언어의 void 키워드와 같다고 보면 된다.
* 함수 몸체의 선언은 함수 머리 = {//함수 몸체}의 형식으로 선언할 수 있다.


위의 코드를 java로 작성한 것은 아래와 같다.
```java
package org.basic.structure
class Ex01{
  public static void main(String [] args){
    System.out.println("hello");
  }
}
```

##### 3. java와 다른점, 함수를 구성하는 요소
###### 3.1 스칼라의 객체는 싱글턴이며, 오직 하나만 존재한다.
> * 스칼라는 object라는 키워드를 사용해 object선언을 한다. (java는 class를 선언함으로써 소스코드가 시작되고, 객체선언 후 인스턴스화 할때 new연산자를 사용한다.)  
> * 스칼라의 object예약어는 클래스 자체를 싱글턴 객체로 생성해낸다. java의 static키워드와 유사한 효과를 내고자 한다면 object내에 원하는 로직을 작성하면 된다.  
> * 스칼라에서 object라는 것은 싱글턴 객체이기 때문에 선언을 하고나면 단 하나만 존재하는 객체가 된다. (java에서 static class형식으로 선언한 것과 유사한 개념)  
> * 스칼라에서는 모든 것이 객체다. +와 같은 연산자도 함수형태의 객체이다. 함수 또한 객체다.  

###### 3.2 함수가 다르다.
> * 함수의 선언은 def키워드를 이용한다.  
> * Unit은 java/c언어의 void와 같은 개념이다.   
> * 함수반환형은 함수 머리의 맨 뒤에 :[반환형]과 같은 형식으로 선언한다.  

###### 3.3 세미콜론을 사용하지 않아도 된다.  
> * 문장끝에 세미콜론이 없어도 수행에 아무 상관이 없다.  
> * 세미콜론을 붙여도 프로그램의 수행에 지장은 없다. 하지만 보통 세미콜론을 사용하지 않는다.  
