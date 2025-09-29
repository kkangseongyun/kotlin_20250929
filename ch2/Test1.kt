//kt 파일이 있는 위치와 관련없는 가상 패키지 선언 가능하다..
package org.example.ch2.one

import java.util.Date


//top - level에 변수, 함수 선언이 가능하다..
//top level의 변수 함수가 자바로 변형시에는 파일명+Kt.class의 static 멤버가 된다.
var sum = 0

fun calSum(){
    for(i in 1..10){
        sum += i
    }
}

class User {
    val name = "kim"
    fun sayHello(){
        val date = Date()
        println("date : $date")
        println("Hello, $name")
    }
}

//jvm entry point..
fun main() {
    calSum()
    println(sum)
    User().sayHello()
}

