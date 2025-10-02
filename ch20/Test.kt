package org.example.ch20

fun main() {
    //List<Int> 데이터를 매개변수로 받아서 데이터를 조건에 맞게 필터링해서 리턴한다..
    //조건은 10보다 큰 수, 혹은 홀수, 혹은 3의 배수등 다양화 될 수 있다.
    //외부에서 조건을 함수로 전달해서.. 그 함수 이용한다..
    fun myFilter(list: List<Int>, argFun: (Int) -> Boolean): List<Int>{
        val resultList = mutableListOf<Int>()

        val iterator = list.iterator()
        while (iterator.hasNext()){
            val no = iterator.next()
            //매개변수의 함수에 전달해서 그 함수의 조건에 맞는지 판단...
            val result = argFun(no)
            if(result)
                resultList.add(no)
        }
        return resultList
    }

    val testList = listOf<Int>(10, 3, 13, 6, 20)
    val resultList = myFilter(testList, { it > 10 })
    resultList.forEach { println(it) }

    //run, let, apply, with.........
    class User {
        var name: String? = ""
        var age: Int = 0
        fun sayHello() {}
    }

    //동시에 객체의 맴버에 여러번 접근..
    val obj = User()
    obj.name = "kim"
    obj.age = 20
    obj.sayHello()

    obj.run {
        name = "lee"
        age = 20
        sayHello()
    }

}