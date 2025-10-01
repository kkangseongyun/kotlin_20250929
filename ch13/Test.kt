package org.example.ch13

open class Shape {
    open fun print(){
        println("Shape...print")
    }
}
class Circle1: Shape(){
    override fun print(){
        println("Circle..print")
    }
}
class Rect: Shape(){
    override fun print() {
        println("Rect..print")
    }
}

fun drawScreen(shapes: Array<Shape>){
    shapes.forEach { shape: Shape ->
        shape.print()
    }
    //Circle..print
    //Rect..print
    //다형성..
    //Shape 의 print() 함수를 두번 호출했다..
    //Shape 의 함수가 호출된 것이 아니라.. Circle, Rect 의 print() 함수가 호출되었다..
    //결국 Rect, Circle을 이용하기는 하지만.. 이 코드에서는 Circle, Rect와 직접 결합되지 않는다.

    //상속 + 오버라이드 + 캐스팅
}

class MyClass {
    private var data1 = 10
    var data2 = 20
        private set(value){//setter만 접근 범위를 줄이겠다.. 줄이는 것만 된다.. 늘리는 것은 안된다..
            field = value
        }
}

fun main() {
    val array = arrayOf<Shape>(Circle1(), Rect())
    drawScreen(array)

    val obj = MyClass()
//    println(obj.data1)
//    obj.data1 = 1

    println(obj.data2)
//    obj.data2 = 2
}