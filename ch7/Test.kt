package org.example.ch7

fun main() {
    //전개 연산자.... 배열의 데이터를 풀어서 어딘가 대입하고자 할때...
    val array1 = arrayOf(1,2,3)
    val array2 = arrayOf(10, 20, 30)
    //두 배열의 데이터를 하나로 결합시켜 사용..
    val array3 = arrayOf(*array1, *array2)
    //collection type 의 함수로.. collection type의 데이터 갯수 만큼 forEach 부분이 실행..
    array3.forEach { println(it) }

    //연산자 재정의...............................
    //숫자 값을 유지하는 클래스인데.. 값의 더하기 연산을 알고리즘대로 동작하게 하고 싶다..
    class MyClass(val no: Int) {
        operator fun plus(arg: Int): Int {
            return no - arg
        }
    }
    //연산자 재정의는 객체의 멤버 함수... extension 함수..
    operator fun MyClass.minus(arg: Int): Int {
        return no + arg
    }

    val obj = MyClass(10)
    val result1 = obj + 5
    val result2 = obj - 10

    println("$result1, $result2")//5, 20
}