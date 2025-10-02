package org.example.ch17

open class Super {
    fun superFun(){ }
}

class Outer {
    val data1: Int = 10

    //익명 클래스.. 이름이 없음으로 선언과 동시에 객체 생성, 변수에 대입
    private val obj = object {
        val data2: Int = 20
        fun some2(){
            //outer 멤버 접근 가능하다..
            println("$data1")
        }
    }

    fun some1(){
        //object { } 는 클래스의 객체이지만.. 클래스명이 없어서.. Any 타입으로 유추된다..
        //Any 라는 클래스에는 data2, some2() 멤버가 없다..
        //private 예약어로 선언해서.. Outer 내부에서만 사용된다고 보장만 하면..
        //컴파일러 기법으로.. object 멤버 접근 가능하게.. 코드를 바꾼다..
        println("${obj.data2}")
        obj.some2()
    }

    //이름은 없지만.. Super를 상속받은 클래스를 선언, 선언과 동시에 객체 생성..
    val obj2 = object: Super() {
        fun subFun() {}
    }

    fun some2() {
        //익명 클래스이지만 상위 클래스 혹은 인터페이스를 구현했다면..
        //상위 타입, 인터페이스타입으로 이용..
        obj2.superFun()
//        obj2.subFun()//error... 타입.. Super 타입이다.. 실제 객체에는 subFun() 이 선언되어 있지만..
        //Super 타입으로 이용되고.. Super에는 subFun() 이 없다..
    }

    //MyObject 은 객체명..
    //컴파일러 기법으로 이름 있는 객체로 만들기는 하지만.. 이곳에서밖에 생성은 안된다..
    //singleton 클래스 만들때 주로 사용..
    object MyObject {
        fun some3(){}
    }
    fun some3() {
        MyObject.some3()
    }

    //자바의 static 멤버는 코틀린에서 top level에...
    //static 멤버가 특정 클래스와 밀접한 관련이 있어서.. 자바의 static 효과.. 즉 클래스명.멤버명
    //이렇게 쓰고 싶을때..
    companion object AAA {
        val companionData = 10
        fun companionFun() {}
    }
}

fun main() {
//    println(Outer.data1)//object 멤버, 객체 생성하고.. 객체로 접근..
    Outer.AAA.companionData
    Outer.AAA.companionFun()

    Outer.companionFun()
    Outer.companionData
}