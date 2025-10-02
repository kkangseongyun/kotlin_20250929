package org.example.ch21

fun some1(fun1: (Int, Int) -> Int, fun2: (Int) -> Int): Int {
    val result1 = fun1(10, 20)
    val result2 = fun2(result1)
    println("some1....")
    return result2
}

inline fun some2(fun1: (Int, Int) -> Int, fun2: (Int) -> Int): Int {
    val result1 = fun1(10, 20)
    val result2 = fun2(result1)
    println("some1....")
    return result2
}

//람다함수의 리턴
//local return - 람다함수가 종료..
//non local return - 람다함수가 선언된 outer 함수가 종료..

//로컬 리턴은.. 라벨만 명시하면 inline 이 선언되든 되지 않든.. return 사용 가능..
//라벨로 리턴시키면 로컬 리턴이다.. 즉 람다가 종료된다..
fun localReturnTestFun() {
    //inline 으로 선언되지 않은 함수를 호출하면서.. 람다에서 return 을 사용했다..
    some1({arg1, arg2 -> arg1 * arg2}){ result ->
        if(result < 0) return@some1 0
        else return@some1 result
    }
    println("test1...")

    ////inline 으로 선언된 함수를 호출하면서.. 람다에서 return 을 사용했다..
    some2({arg1, arg2 -> arg1 * arg2}){ result ->
        if(result < 0) return@some2 0
        else return@some2 result
    }
    println("test2...")
}

//non local return - nonLocalReturnTestFun() 함수가 종료되게 하고 싶다..
fun nonLocalReturnTestFun(): Int {
    //inline 으로 선언되지 않은 함수를 호출하면서.. 람다에서 return 을 사용했다..
    //일반함수를 호출하는 람다에서 non - local return 은 허용하지 않는다..
//    some1({arg1, arg2 -> arg1 * arg2}){ result ->
//        if(result < 0) return 0
//        else return result
//    }
//    println("test1...")

    ////inline 으로 선언된 함수를 호출하면서.. 람다에서 return 을 사용했다..
    //inline 함수에 전달되는 람다함수에서는 non - local return 가능..
    some2({arg1, arg2 -> arg1 * arg2}){ result ->
        if(result < 0) return 0
        else return result
    }
    println("test2...")
    return 0
}

fun main() {
//    localReturnTestFun()
    //some1....
    //test1...
    //some1....
    //test2...
    //==>test1, test2가 찍혔다..localReturnTestFun() 이 종료된 것이 아니라.. 람다함수가 종료된거다
    //==>로컬리턴.

    nonLocalReturnTestFun()
}