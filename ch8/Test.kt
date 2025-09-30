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
}