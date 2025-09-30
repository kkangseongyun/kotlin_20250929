package org.example.ch10

//보조 생성자 테스트...................................
fun main() {
    //보조 생성자는 클래스 바디에... 매개변수를 다르게 해서.. 여러개 선언 가능..
    class User1 {
        constructor(){}
        constructor(name: String){}
        constructor(name: String, age: Int){}
    }
    User1()
    User1("kim")
    User1("kim", 20)

    //보조생성자 - init....
    class User2 {
        init {
            println("init.....")
        }
        constructor(){
            println("constructor...")
        }
    }
    User2()
    //init.....
    //constructor...
    //==> init 블록이 있다면.. 보조생성자로 객체를 생성해도 실행된다..
    //init 이 먼저 실행되고.. 보조생성자 영역이 실행..
    //==>init 은 주로 주 생성자로 객체를 생성할 때 실행시킬 로직을 담기위해서..

    //보조 생성자와.. 클래스 멤버 변수....................................
//    class User3 {
//        //보조 생성자의 매개변수는 생성자의 지역 변수이다..
//        constructor(val name: String, var age: Int){//error... 보조생성자의 매개변수에..
//            //var, val 추가 불가능하다..
//            println("$name, $age")
//        }
//        init {
//            println("init : $name, $age")//error..
//        }
//        fun sayHello(){
//            println("sayHello : $name, $age")//error...
//        }
//    }

}