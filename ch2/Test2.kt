package org.example.ch2

import org.example.ch2.one.User
import org.example.ch2.one.calSum
import org.example.ch2.one.sum

//Test1.kt 파일에 선언된 멤버를 다른 파일에서 이용하겠다..
//동일 패키지라면.. import 없이, 다른 패키지라면 import, 함수, 변수, 클래스..
fun main() {
    //Test1.kt 파일의 top level의 변수, 함수가 자바로 변형시.. Test1Kt.class에 들어가지만.
    //코틀린에서는 Test1Kt로 이용하는 것이 아니라.. 변수, 함수를 개별적으로 직접 이용..
    println(sum)
    calSum()
    User().sayHello()
}