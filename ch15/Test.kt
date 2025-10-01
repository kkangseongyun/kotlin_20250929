package org.example.ch15

import org.example.ch3.data1

class User(val no: Int, val name: String)

data class UserData(val no: Int, val name: String){
    var email: String? = null
    constructor(no: Int, name: String, email: String): this(no, name){
        this.email = email
    }
}

fun main() {
    val user1 = User(1, "kim")
    val user2 = User(1, "kim")
    val user3 = UserData(1, "kim")
    val user4 = UserData(1, "kim")

    //equals..................................
    //false, true, false
    //일반 클래스의 equals 는 Any 의 equals - 주소 비교..
    //data 클래스의 equals 는 오버라이드 받아서. - 값 비교..
    //타입이 다르면 false
    println("${user1.equals(user2)}, ${user3.equals(user4)}, ${user3.equals(user1)}")

    val user5 = UserData(1, "kim", "a@a.com")
    val user6 = UserData(1, "kim", "b@b.com")
    //true, true
    //data 클래스의 equals 는 주 생성자의 매개변수만 비교한다..
    println("${user5.equals(user6)}, ${user5.equals(user3)}")

    //값이 아닌 객체를 비교 하고 싶다면..
    //false, false, true, false
    //일반 클래스는 ==, === 모두 객체 비교..
    //data 클래스 == =>equals() 로 변형.. 값 비교.. , === 주소 비교..
    println("${user1 == user2}, ${user1 === user2}, ${user3 == user4}, ${user3 === user4}")

    //toString().............................................
    //org.example.ch15.User@7cc355be, UserData(no=1, name=kim), UserData(no=1, name=kim)
    //일반 클래스는 Any 의 toString() - 타입+hash
    //data 클래스 - toString 오버라이드.. 자신의 값을 문자열로..
    //주 생성자의 매개변수 데이터만..
    println("${user1.toString()}, ${user3.toString()}, ${user5.toString()}")

    //구조분해할당..(destructing assignment) - 객체의 구조(변수)를 몰라도.. 데이터 획득..
    val no1 = user3.component1()
    val name1 = user3.component2()//주 생성자 매개변수 갯수만큼 순서대로..
    println("$no1, $name1")//1, kim

    //data class에 멤버 변수 많다.. 한꺼번에 여러개를 획득하고 싶다..
    val (a1, a2) = user3
    println("$a1, $a2")//1, kim

    //여러 데이터를 뽑기는 할건데.. 몇개를 선별적으로..
    //_ : 변수명 아니다.. 받기 싫은 데이터 순서때문에..
    val (_, b1) = user3
    println("$b1")//kim

    //list...
    val list = listOf(1,2,3,4,5)
    val (c1, c2, c3) = list
    println("$c1, $c2, $c3")//1, 2, 3

    val (_, d1, _, d2) = list
    println("$d1, $d2")//2, 4


    //함수의 리턴값... 한꺼번에 여러 데이터를 리턴하고 싶을 때...
    //tuple 기법이라고 하는데.. kotlin 은 지원하지 않는다..
    //data 클래스를 이용해 비슷하게 작성은 된다..
//    fun some(): (Int, Int, Int){
//        return (10, 20, 30)
//    }
//    val (e1, e2, e3) = some()

    data class Data1(val data1: Int, val data2: Int, val data3: Int)
    fun some(): Data1 {
        return Data1(1,2,3)
    }
    val (e1, e2, e3) = some()
}