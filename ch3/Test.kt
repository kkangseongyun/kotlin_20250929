package org.example.ch3

import kotlin.random.Random

//top level, class member 변수는 선언과 동시에 초기화 해야 한다.. default 초기화 지원하지 않는다.
val data1: Int = 0
var data2: Int = 0

class MyClass {

    val data3: Int = 0
    var data4: Int = 0

    fun someFun(){
        //local variable은 선언과 동시에 초기화 하지 않아도 된다..
        val data5: Int
        var data6: Int

        data5 = 10
        data6 = 20

        //변수를 이용하기 전에는 초기화 해야 한다..
        val result = data5 + data6
    }
}

//자바와 다르게 코틀린의 변수는 프로퍼티여서.. 내장 getter/setter를 가진다..
//개발자가 getter/setter를 customizing 해버리면.. 값 변경은 안되지만.. 동일 값이 참조된다고
//보장할 수 없기 때문에.. 상수변수가 아니다..
val valData: Int
    get() {
        return Random.nextInt(0, 100)
    }


var varData = 10


//const.........................
//상수 변수는 const 예약어로...
const val myConst = 10
//const var myConst2 = 10//error... const 에 var 불가능..

class MyClass2 {
//    const val myConst3 = 10//error..클래스 멤버 변수는 const로 선언 불가..

    object A {
        const val myConst4 = 10//object 클래스 내부에 한해서는 const 변수 선언 가능..
    }
}

fun main() {
//    valData = 20//error...
    varData = 20//ok...

    //val, 초기화 후에 값 변경은 불가능하지만.. 그렇다고 상수는 아니다..
    println(valData)
    println(valData)
}