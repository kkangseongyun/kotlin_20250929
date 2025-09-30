package org.example.ch6

fun main() {
    //if...... expression..................
    val a = 5

    if(a > 10) "hello"//ok......

    //if가 expresion 으로 활용이 된다면 else 생략이 불가하다..
    val result = if(a > 10) "hello" else "world"

    val result2 = if(a > 10) 10
    else if(a > 20) 20
    else 0

    //expression 으로 활용이 되면 결과 값은 마지막 라인의 실행 결과 값...
    val result3 = if(a < 10){
        println("hello")
        10 + 20
    }else {
        println("world")
        20 + 30
    }
    println("if result : $result3")

    //when.............................................
    when(a){//단순 값으로 조건...
        1 -> println("1...")
        2 -> println("2...")
        else -> println("else....")
    }

    //or....
    when(a){
        1,2 -> println("1,2...")
        3,4 -> println("3,4...")
    }

    //범위 지정..
    when(a){
        in 1..10 -> println("1..10")
        in 11..20 -> println("11..20")
    }

    //집합데이터에 있는 데이터라면..
    val list = listOf<Int>(1,2,3,4)
    when(a){
        in list -> println("in list")
        else -> println("else...")
    }

    //when 도 expression 으로 활용 가능..
    //else 생략 불가하다...
    val result4 = when(a){
        1 -> "hello"
        2 -> "world"
        else -> "none"
    }


    //for........................
    for(i in 1..5){
        print("$i ")//1 2 3 4 5
    }

    println()

    for(i in 1 until 5){
        print("$i ")//1 2 3 4
    }

    println()

    for(i in 1..10 step 2){
        print("$i ")//1 3 5 7 9
    }

    println()

    for(i in 10 downTo 1 step 2){
        print("$i ")//10 8 6 4 2
    }

    println()

    val array = arrayOf("hello", "world")
    //반복하면서 컬렉션 데이터를 이용하는 경우..
    for(value in array){
        print("$value ")//hello world
    }

    println()

    //반복하면서 index값 이용...
    for(index in array.indices){
        print("$index ")//0 1
    }

    println()

    //반복하면서 값과 index 모두 이용하는 경우..
    //(index, value) - 변수명은 마음대로.. 순서가 중요하다. index, value
    for((index, value) in array.withIndex()){
        print("$index $value ")//0 hello 1 world 
    }
}