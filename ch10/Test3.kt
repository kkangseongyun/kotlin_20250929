package org.example.ch10

//주 생성자가 선언이 되었다면.. 보조생성자로 객체 생성 시점에 주 생성자는 호출되어야 한다..
class User(name: String){
    init {
        println("init.......")
    }
    constructor(name: String, age: Int): this(name){
        println("constructor(name: String, age: Int)")
    }
    constructor(name: String, age: Int, email: String ): this(name, age){
        println("constructor(name: String, age: Int, email: String )")
    }
}

fun main() {
    User("kim", 20, "a@a.com")
    //init.......
    //constructor(name: String, age: Int)
    //constructor(name: String, age: Int, email: String )
    //객체 생성시에 여러 생성자가 호출된다고 하더라도.. init 은 가장 먼저 한번..

    //문법
    //- 주 생성자만 var, val 로 매개변수를 멤버변수로 가능..
    //- 보조 생성자에서는 무조건 주 생성자 호출해야 한다..

    // - 주
    // - 보조
    // - 주 , 보조...

    //==>생성자를 하나만 정의해도 된다면.. 주 생성자..
    //==>여러개 선언해야 한다면.. 공통 매개변수를 주 생성자에 선언하고.. this() 로 연결..
}