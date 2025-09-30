package org.example.ch10

fun main() {

    //클래스 선언.. 주생성자 선언.....................
    class MyClass constructor(){ }
    //주 생성자의 constructor 예약어는 생략 가능..
    class MyClass2(){}
    //개발자가 어떤 생성자도 선언하지 않았다면 컴파일러에 의해 주생성자(default - 매개변수없는)추가
    class MyClass3{}

    val obj1 = MyClass()
    val obj2 = MyClass2()
    val obj3 = MyClass3()


    //생성자도 매개변수를 가질 수 있고.. 매개변수를 옵셔널로 제공할 수 있다.. 이 부분은 함수와 동일하다
    class User1(name: String, age: Int = 0)

    User1("kim", 20)
    User1("kim")
    User1(age = 20, name = "kim")

    //주 생성자로 객체 생성 시점에 실행시킬 로직은.... init 블록으로..
    class User2(name: String){
        init {//생성자 호출 시점에 실행된다..
            println("inti.... $name")
        }
    }
    User2("kim")

    //주생성자와 멤버 변수.................................
    //생성자의 매개변수는 기본.. 생성자 내에서 사용하는 지역변수이다..
    class User3(name: String, age: Int){
        var name: String = ""
        var age: Int = 0
        init {
            this.name = name
            this.age = age
        }
        fun sayHello(){
            println("$name, $age")
        }
    }
    User3("kim", 20).sayHello()//kim, 20

    //위 코드를 코틀린 스타일로.....
    //주 생성자의 매개변수에 한해서..var, val 추가 가능하고... 추가하면 그 즉시 멤버 변수가 된다.
    class User4(val name: String, val age: Int){
        fun sayHello(){
            println("$name, $age")
        }
    }
    User4("lee", 30).sayHello()//lee, 30



}