package org.example.ch16


enum class Direction1 {
    NORTH, SOUTH
}

//enum 상수에 데이터를 담고 싶다면..
enum class Direction2(val no: Int) {
    NORTH(10), SOUTH(20)
}

//enum 상수에.. 로직의 함수까지 추가하고 싶다면..
enum class Direction3 {
    NORTH {
        override fun some() {
            println("north some..")
        }
    }, SOUTH {
        override fun some() {
            println("south some..")
        }
    }
    ;
    abstract fun some()
}

fun main() {
    val data: Direction1 = Direction1.NORTH
    println("${data.name}, ${data.ordinal}")//NORTH, 0

    val data2: Direction2 = Direction2.NORTH
    println("${data2.no}")//10

    val data3: Direction3 = Direction3.NORTH
    data3.some()//north some..
}