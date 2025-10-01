package org.example.ch12

// 1. 주 생성자가 있다면.. 보조 생성자에서는 주 생성자 호출되어야 한다..
// 2. 하위 객체 생성시에 상위 생성자는 호출이 되어야 한다...

open class Super(no: Int) {
    var a = 10
    constructor(no: Int, name: String): this(no){
        println("Super...constructor(no: Int, name: String)")
    }
    init {
        println("Super...init")
    }
}

class Sub(no: Int): Super(no, "kim") {
    var b = 20
    constructor(no: Int, name: String): this(no){
        println("Sub...constructor(no: Int, name: String)")
    }
    init {
        println("Sub...init")
    }
}

fun main() {
    val obj = Sub(10, "lee")
    obj.a = 100
    obj.b = 200
    //Super...init
    //Super...constructor(no: Int, name: String)
    //Sub...init
    //Sub...constructor(no: Int, name: String)

    //casting.............................
    val obj2: Sub = Sub(10)
    val obj3: Super = obj2//하위->상위
    val obj4: Sub = obj3 as Sub//하위 -> 상위-> 하위

    val obj5: Sub = Super(10) as Sub//java.lang.ClassCastException 상위 -> 하위
}