# 클래스  
## 스칼라에서 클래스와 객체
### 1) Object (싱글턴 객체)
- object를 통해 바로 생성된 객체를 말한다.
- new 키워드를 통해 인스턴스화 하지 않고 프로그램의 전역적으로 static선언 방식과 유사하게 선언된 변수다.
- 하지만, 스칼라에는 static이라는 용어를 사용하지 않는다.
- 싱글턴패턴으로 선언된 것과 유사하게 선언된 객체이다.
- 아예 처음부터 메모리에 생성한 객체다.

### 2) 클래스를 통해서 생성해낸 객체
- new 키워드를 통해 인스턴스화 한  객체를 말한다.

### *스칼라의 main문
```scala
object Ex{
  def main(args : Array[String]) : Unit = {
    println(“hello”)
  }
}
```


java, scala, c++ 등등 모든 프로그램언어는 프로그램을 실행하기 위해 main이라는 이름을 가진 시작 메서드가 하나라도 존재해야 한다. 그런데 자바에서는 모든 영역을 클래스로 나눈다. 따라서 클래스안에 static 키워드를 통해 main문을 생성하지 않고는 컴파일러에게 main문의 위치를 알릴 방법이 없었다. 이런이유로 자바에서는 public static void main이라는 키워드들을 나열해 정적으로 main문을 만들어 사용했다.  
  
스칼라의 경우는 더 객체지향적인 접근을 한다. 스칼라에서는 객체이든가 아니면 인스턴스화 되지 않은 클래스이든가 둘중 하나이다. 따라서 이런 이유로 public class 를 사용하든가 하는 행동을 하지 않고 object예약어를 통해 아예 처음부터 메모리에 객체를 생성해버린 것이다.  

## 클래스의 선언
스칼라 코드  
```scala
class Vehicle ( ab : Int, bb : Int ){
     var a = ab
     var b = bb
}
```
자바로 작성할 경우  
```java
class Vehicle {
     private int a;
     private int b;
     public Vehicle(int a, int b){
          this.a = a;
          this.b = b;
     }
}
```
 - 자바에서는 클래스파일을 밖으로 빼서 하나의 파일로 만단다, .class파일이 항상 외부에 존재하면서 이 파일안에 생성자, 게터, 세터, toString 메서드등 필요한 로직이 모두 들어간다. 하지만 이렇게 클래스 단위로만 수정/변경할 경우 시간이 오래 걸리는 단점이 있다.  
 - 스칼라에서는 클래스의 구현부를 없애는 것도 가능하다.  

또는 클래스의 선언은 아래와 같이 축약형으로 선언할수도 있다.  
### 클래스를 축약형으로 선언하면서 내부의 멤버들을 private로 선언하는 방식
```scala
class Vehicle (a:Int, b:Int)
```

### 케이스 클래스
축약형으로 클래스를 선언할 경우, 멤버변수들이 모두 private로 생성되므로 변수에 바로 접근하는 것은 불가능하다. 자바에서는 보통 private 멤버를 접근할 경우 getter/setter를 사용하는데, 스칼라에서도 물론 이렇게 구현하는 것은 가능하지만, getter/setter를 사용하지는 않고 케이스 클래스를 사용한다.  
(스칼라의 간결하고 짧은 코드를 지향하는 철학과 맞지 않다.)  

스칼라 코드  
```scala
def main ( args : Array[String] ) : Unit = {
     val apple = Fruit("사과")
     println("apple.name")
} 
case class Fruit(name : String)
```

### ※객체이름과 클래스 이름이 같다면?
객체이름과 클래스이름이 같아도 생성이 가능하다. 스칼라는 자바에는 없는 동반 객체(companion object)를 제공한다. 동반 객체라고 부르기도 한다. 같은 이름의 객체와 클래스는 자주 쓰이는 개념이다. 단순히 같은 이름으로 지정할 수 있다는 점 외에도 동반객체와 클래스는 각자의 private 필드나 메서드를 서로 자유롭게 접근할 수 있다는 특성이 있다.  

## 상속
```scala
package org.basic.scalaclass

object Inherit {
  def main (args : Array[String]) : Unit = {
    val apple = new Apple("사과", 1500, "아침에 먹으면 좋습니드아... ")
    apple.printName
    apple.printFeature
  }
}

class Fruit(name : String, price : Int){
  val printName = println("NAME :: " + name )
}

class Apple(name : String, price : Int, feature : String) 
  extends Fruit(name : String, price : Int){
  val printFeature = println("FEATURE :: " + feature )
}
```
(* 참고, Scala에서는 함수 자체를 변수에 할당할 수 있다.)  
Fruits를 상속받는 클래스 Apple에 feature 항목을 추가해서 구현했다.   Apple 클래스는 Fruits클래스의 printName도 사용할 수 있다.  

## 트레이트, 추상클래스, Java에서의 Interface,abstract
### Interface와 Abstract의 개념
트레이트의 개념을 짚기 전에 Java에서의 abstract, interface의 차이점을 알아야 한다.  
Java에서의 abstract,interface의 차이점은 이전에 정리해둔 글이 있다.  
http://silentcargo.tistory.com/76  
  
트레이트의 개념을 짚기 위해 정말 엄청 단순 무식하게 Interface, Abstract의 개념을 짚어보면…  
  
Interface는 내부에 함수의 선언, 상수만을 선언할 수 있으며 implements 키워드로 구현할 수 있다. (extends가 아니기 때문에 상속받는게 아니다. 혼동하면 안된다.). implements하는 것은 여러개의 interface를 부품을 덧붙이듯이 덧붙여 사용할 수 있다. 다중으로 implements할 수 있다.  
  
Abstract클래스는 클래스 내부에 abstract 메서드가 하나 이상이라도 있으면 그 클래스는 abstract클래스가 되어야 한다. abstract 클래스 내부에는 변수를 선언할 수 있으며 abstract 클래스 내부의 메소드는 아래와 같이 선언하고 함수의 몸체(body)는 구현하지 않는다.  
```java
public abstract void print(); 
```
abstract 클래스는 extends 키워드를 사용하므로 클래스처럼 취급된다. 따라서 다중 상속이 불가능하다.  

### 트레이트의 개념, Interface,Abstract와의 비교
트레이트는 Interface와 Abstract의 특징이 서로 합쳐져 있는 개념이다. 
interface가 여러 개의 interface를 implements하듯이 여러개의 trait를 extends할 수 있다(주의할 점은 implements가 아닌 extends한다는 것이다). 하지만 interface는 interface내부의 메서드에 아무 내용도 기술할 수 없다. 이러한 단점을 보완하기 위해  
abstract클래스 내부에 abstract 메서드가 아닌 메서드(abstract키워드가 붙어있지 않은 메서드)의 몸체를 정의해서 사용할 수 있듯이 trait도 trait내부의 함수의 몸체를 정의할 수 있다.  
  
결론적으로, trait은 내부에 메서드의 몸체를 구현할 수 있으며, 하나의 클래스에서 여러개의 trait을 상속(extends)받아서 사용할 수 있다.  
  
### 간단 예제 1)  단순히 Trait을 여러개 상속받는 예제
```scala
package org.basic.traits

object TraitTest {
  def main(args : Array[String]) : Unit = {
    val student = new Person()
    student.walking
    student.testing
    student.studying
  }
}

class Person extends Walking with Studying with Testing {
  
}

trait Walking {
  def walking = println("I'm walking now")
}

trait Studying {
  def studying = println("I'm Studying now")
}

trait Testing {
  def testing = println("I'm Testing now”)
}
```
### 간단 예제 2) Trait을 abstract 클래스처럼 사용하게 될 경우
- 이럴 경우 상속받은 클래스에서 해당 abstract클래스의 메서드를 overriding해야 한다.
- 오버라이딩을 하지 않을 경우 에러를 낸다.
- 인터페이스나, abstract클래스의 abstract메서드처럼 오버라이딩을 강제하고자 할 경우 트레이트의 해당 메서드를 빈 껍데기로 남겨놓을 수 있다.
```scala
package org.basic.traits2

/* scala 에서 Trait을 사용할 때 abstract클래스 처럼 사용하는 방법 */
object TraitTest2 {
  def main ( args : Array[String] ) : Unit = {
    val student : Student = new Student()
    student.testing
    student.walking
    student.studying
  }
}

class Student extends Testing with Studying with Walking{
  def testing = println("I'm testing now ")
}

trait Testing {
  def testing   // abstract 메서드처럼 사용했다.  
}

trait Studying {
  def studying = println("I'm studying now ")
}

trait Walking {
  def walking = println("I'm walking now ")
}
```

### 간단 예제3) scala에서 추상클래스를 사용하는 경우
추상클래스와 원하는 트레이트를 섞어서 상속받아 최종적인 클래스 형태를 반들어내는 것을 mixin “믹스인”이라고 한다.  
```scala
package org.basic.traits3

// 믹스인 개념 얘
object TraitTest3 {
  def main ( args:Array[String] ) : Unit = {
    val student = new CSStudent()
    student.studying
    student.walking
    student.testing
  }
}

class CSStudent extends Student with Walking with Testing{
  def studying = println("I'm coding some pilots.")
}

abstract class Student { // abstract 클래스  
  def studying
  def greeting = println("I'm a student.");
}

trait Walking {
  def walking = println("I'm walking now.")
}

trait Testing {
  def testing = println("I'm testing now.")
}
```
추상클래스인 Student를 상속받을 경우 상속받은 CSStudent라는 클래스 내부에서는 studying이라는 추상 메서드에서는 반드시 오버라이딩을 해야만 한다.  

### 간단예제 4) trait 내부 또는 추상클래스에 이미 구현되어 있는 함수를 새롭게 작성하고자 할때
- 상속받을 추상클래스의 메서드를 재구현해서 사용하고자 할 때 override 키워드를 사용하지 않을 때 에러를 발생시킨다.
- 상속받은 trait의 메서드를 재구현해서 사용하고자 할 때 override 키워드를 사용하지 않을 경우 에러를 발생시킨다.
```scala
package org.basic.traits4

object TraitsTest4 {
  def main (args : Array[String] ) : Unit = {
    val student = new CSStudent()
    student.greeting
    student.studying
    student.testing
    student.walking
  }
}

class CSStudent extends Student with Walking with Testing{
  def studying = println("I'm coding some pilots.")
  override def greeting = println("I'm Student at CS Dept.")
  override def walking = println("I'm Walking now... ")
}

abstract class Student{
  def studying
  def greeting = println("I'm a student")
}

trait Walking{
  def walking = println("I'm walking now.")
}

trait Testing{
  def testing = println("I'm Testing now.")
}
```
## 트레이트 쌓기
기능이 모두 구현되어 있는 일반클래스나 일부 기능이 구현되어 있는 추상클래스 여러개를 한 클래스에서 상속받을 경우 ‘다이아몬드 상속’의 문제가 발생할 수 있다.  
  A  
 /  \  
B    C  
 \  /
  D  
A가 최상위 클래스이고, B와 C는 A를 상속받고 있다. 그 B와 C는 개별적으로 A가 가지고 있는 메서드를 오버라이드 해서 다시 구현했다고 해보자. 손자 클래스(Grand Child Class) B와 C를 동시에 상속받고 있다. 이 경우 D가 B의 메서드를 상속받을지 C의 메서드를 상속받을 지 알 수 없다.  
  
자바에서는 이와 같은 문제로 인해 클래스(일반 클래스, 추상클래스 모두)는 하나의 클래스만을 상속받을 수 있다. 단 인터페이스의 경우 부품을 덧붙이듯이 여러개을 상속받을 수 있다.  
  
스칼라는 이러한 문제에 정면으로 대응한다.  
1) 필요하다면 B, C 둘중 하나만 실행하거나  
2) B, C 모두의 기능을 실행하는 방식이다.  
3) 이도 저도 마음에 들지 않는다면 최종으로 상속받는 일반클래스에서 재구현해 사용할 수 있다.  
  
코드를 보면서 살펴보자. 아래의 코드는 빌드가 되지 않는다.  
```scala
package orag.basic.traits_stacked

object TraitTest1 {
  def main (args : Array[String]) : Unit = {
    
  }
}

abstract class Food{
  def name="Food"
}

trait Fruit{
  def name="fruit"
}

trait Apple{
  def name="orange"
}

trait Banana{
  def name="banana"
}

class Something extends Food with Fruit with Apple with Banana
```
Something 클래스가 서로 충돌되는 메서드들을 가지고 있다는 warning을 띄운다.  
  
### B,C 둘 중 하나만 실행하는 방식
위의 코드를 override 예약어와 함께 적당한 상속관계를 만들어주면 일단 프로그램을 실행시켜 볼 수는 있다. 아래의 코드를 보자  
```scala
package org.basic.triatis_stacked

object TraitTest1 {
  def main (args: Array[String]):Unit = {
    val food = new Something
    println(food.name)
  }
}

abstract class Food{
  def name = "Food"
}

trait Fruit extends Food{
  override def name="fruit"
}

trait Apple extends Food{
  override def name="orange"
}

trait Banana extends Food{
  override def name="banana"
}

class Something extends Food with Fruit with Apple with Banana{
  
}
```
모두 오버라이드 했으며 , 가장 마지막으로 override된 것이 실행되는 것을 알수 있다.  
  
모두 실행할 수 있는 방식  (? 이부분 나중에 다시 정리 - 언어책 하나 깊게 파고들어서..)  
```scala
super키워드를 통해 상속받은 모든 클래스에서 실행할 수도 있다.  
package org.basic.traits_stacked2

object TestTrait1 {
  def main (args : Array[String] ) : Unit = {
    val food = new Something
    println(food.name)
  }
}

abstract class Food {
  def name = "Food"
}

trait Fruit extends Food{
  override def name = super.name + " Fruits"
}

trait Apple extends Food{
  override def name = super.name + " Apple"
}

trait Banana extends Food{
  override def name = super.name + " Banana"
}

class Something extends Food with Fruit with Apple with Banana

출력결과
Food Fruits Apple Banana
```









