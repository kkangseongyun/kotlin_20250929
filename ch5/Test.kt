package org.example.ch5

fun main() {
    //배열 선언... 선언과 동시에 값 대입이 가능한 경우..
    val array1 = arrayOf(10, true, "hello")//사이즈 3으로 고정...
    //타입으로 []을 사용하지는 않지만.. 데이터 이용시 index값 지정에는 사용..
    array1[0] = 20
    println("arra1 : ${array1.size}, ${array1[0]}, ${array1.get(0)}")

    //타입을 한정 짓고 싶다면... 제네릭으로..
    val array2 = arrayOf<Int>(10, 20, 30)
    //기초 타입에 한해.. xxxArrayOf 함수도 제공.. 자바 호환성을 위해 제공하는 것이다..
    val array3 = intArrayOf(10, 20, 30)

    //사이즈를 지정하고.. 나중에 데이터....할당.....
    val array4 = Array<Int>(3, { 0 })
    array4[0] = 10
    val array5 = IntArray(3, { 0 })

    //list................................................
    val list1 = listOf<Int>(10, 20)//immutable...
//    list1.add(30)//error...
    val list2 = mutableListOf<Int>(10, 20)//mutable....
    list2.add(30)
    list2.forEach { println(it) }

    //map..... key - value...
    val map = mapOf<String, String>("one" to "hello", "two" to "world")
    println("${map.get("one")}, ${map["two"]}")//hello, world

    val map2 = mapOf<Int, String>(Pair(1, "hello"), Pair(2, "world"))
    println("${map2[1]}, ${map2[2]}")//hello, world
}