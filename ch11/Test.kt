package org.example.ch11

class User {
    //field 는 accessor 내에서의 예약어.. 프로퍼티의 값 자체를 지칭..
    var id: Int = 0
//        get(){
//            return field
//        }
//        set(value) { field = value}
        set(value){
            if(value < 0) field = 0
            else field = value
        }

    var name: String? = null
        get() { return field?.uppercase() }

    //property => 자바 변형시에.. private 변수, public getter/setter 함수가 만들어진다..
    //koltin
    //var name: String= "hello"
    //java
    //private String name = "hello"
    //public void setName(String name) { this.name = name }
    //public String getName() { return name }

    //custom accessor를 추가하면서 field 예약어를 사용하지 않았다면..
    //자바 변형시에 private 변수가 만들어지지 않는다.. getter/setter만 만들어진다..
    //초기값을 줄 수 없다.. accessor 내에서 초기값을 주어야 한다..
    val data1: String //= "hello"
        get() = "kim"

    //var 이다..get/set 이다.. get()만 customizing... set()은 기본이 적용된다..
    // set() 내에 field 가 있다.
    var data2: String = "hello"
        get() = "kim"
}

//초기화 미루기................................................
lateinit var data3: String

class MyClass {
    val data1: Int
    var data2: String

    init {
        data1 = 10
        data2 = "hello"
        println("in init....")
    }

    lateinit var data3: String
    val data4: Int by lazy {
        println("in by lazy....")
        10
    }
}

fun main() {
    val obj = User()
    obj.name = "kim"
    obj.id = -1
    println("${obj.name}, ${obj.id}")

    val obj2 = MyClass()
    println("before...")
    println(obj2.data4)
    println("after...")
    println(obj2.data4)
    println(obj2.data4)
    //in init....
    //before...
    //in by lazy....
    //10
    //after...
    //10
    //10
}