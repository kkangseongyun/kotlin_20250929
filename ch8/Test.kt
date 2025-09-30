package org.example.ch8

var data1: String = "hello"//String + Non Null
var data2: String? = "hello"//String + nullable

fun main() {
//    data1 = null//error.. 절대 non-null type 에 null 대입 불가하다.. 컴파일러가 에러 발생한다.

    data2 = null//ok... 객체가 null 인 것이 문제가 되지는 않는다.. null인 상태에서 멤버 접근시 문제다

    //캐스팅... nullable 이 non-null type의 상위 타입이다..
    var data3: String? = data1 //String -> String?, 하위 -> 상위, 암시적 캐스팅..

    data2 = "hello"
//    var data4: String = data2 //error...String? -> String, 상위 -> 하위, 명시적 캐스팅
    var data4: String= data2 as String //ok..명시적 캐스팅.. runtime ok....

    data2 = null

    //nullable -> non-null 캐스팅은 명시적 캐스팅은 맞지만 만약 실제 null이면 NPE
//    data4 = data2 as String //compile ok... runtime error...java.lang.NullPointerException
    //nullable 을 non-null로 캐스팅할때.. NPE 가능성이 있음으로.. as?
    //as? null이 아니면 캐스팅하고.. null이면 캐스팅하지 마라...
    //null이면 캐스팅을 안하지만.. 전체 null이다..
    data4 = data2 as? String ?: ""

    //멤버접근........................................
    val length = data1.length
    val length2 = data2?.length//nullable 객체의 멤버 접근은 ?.
    println(length2)//null
    data2 = "hello"
    val length3 = data2?.length
    println(length3)//5


    //일치 연산자....................................................
    //일반 객체(기초데이터 객체가 아닌) ==, === 의 차이가 없다..
    //모두 객체 비교이다..
    //자바로 변형되도 객체이다.. 모두 객체 비교..
    class User

    val user1 = User()
    val user2 = User()
    println("${user1 == user2}, ${user1 === user2}")//false, false

    //기초데이터 객체 - non null
    //==, === 차이가 없다.. 모두 값 비교..
    //자바로 변형시에 primitive type으로 변형된다.. 객체가 아니다.. 값 비교 할수 밖에 없다..
    val a1: Int = 1000
    val a2: Int = 1000
    println("${a1 == a2}, ${a1 === a2}")//true, true

    //기초데이터 객체 - nullable
    //== 값비교.., === 객체비교..
    //nullable 선언하면 런타임시점에 null대입이 될 수도 있다. 자바 변형시.. Integer 로 변경된다..
    //기초 타입을 객체로 표현하기 위해서 int -> Integer, double -> Double 등을 Wrapper 클래스라 부른다.
    val b1: Int? = 1000
    val b2: Int? = 1000
    println("${b1 == b2}, ${b1 === b2}")//true, false
}











