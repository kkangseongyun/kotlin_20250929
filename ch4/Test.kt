package org.example.ch4

fun main() {
    //single expression function.................................
    fun some1(a: Int, b: Int): Int {
        return a + b
    }
    fun some2(a: Int, b: Int) = a + b //리턴 타입은 자동으로 Int

    //optional, named argument....
    //매개변수에 기본값이 선언되어 있으면 옵셔널이다.. 즉 호출자가 매개변수를 생략할 수 있다..
    fun sayHello(name: String = "kim", no: Int){

    }
    //순서에 맞춰서..
    sayHello("lee", 10)
    //이름을 명시해서.. 매개변수 지정..
    sayHello(name = "lee", no = 20)
    //이름을 명시하면 순서가 의미가 없다.. 순서 맞추기 않고.. 가능..
    sayHello(no = 30, name = "park")
    sayHello(no = 40)//optional은 생략이 가능하고..
}

fun myFun1(no: Int = 1, count: Int = 1){
    println("myFun1...")
    return if(no == count) return else myFun1(no - 1, count)
}

//꼬리 재귀함수에 한해서..tailrec를 추가하면 컴파일러가 자바로 변형시 재귀알고리즘을 해제한다..
tailrec fun myFun2(no: Int = 1, count: Int = 1){
    println("myFun1...")
    return if(no == count) return else myFun2(no - 1, count)
}