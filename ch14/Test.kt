package org.example.ch14

//클래스내에 abstract로 선언된 멤버가 하나라도 있다면.. 클래스도 abstract 로 선언되어야 한다..
abstract class Super {
    //추상 프로퍼티 선언...
    //프로퍼티는 상위에서 선언한다.. 구체적인 값은 하위에서 오버라이드 받아서 지정하라..
    //자바 변형시에.. getter/setter가 추상형이 된다..
    abstract val data1: String

    //추상 클래스라고 해서.. 모든 멤버가 추상형일 필요는 없다.. 하나이상의 추상 멤버가 있다면..
    //그 클래스도 추상형이다..
    open fun some1(){ }

    abstract fun some2()

    open fun some3(){}
}

//변수, 함수를 묶을 수는 있지만 생성자는 추가 안된다..
//클래스 아니다..
//인터페이스의 기본 목적은 추상형임으로 abstract 예약어를 추가하지 않아도 자동 추가된다..
interface Interface1 {
    //프로퍼티의 기본은 추상형이다..
    val data1: String

    //프로퍼티를 직접 값 대입시킬 수 없다..
    //custom accessor 추가해서.. 추상형이 아닌 프로퍼티를 만들 수 있지만.. field 예약어 사용 못한다
    //자바 변형시에 정상 데이터를 가지는 변수가 선언되지 못한다..
//    val data2: Int = 10//error...

    //추상형이 아닌 프로퍼티를 인터페이스 내에 선언한다면 아래처럼..
    val data2: Int
        get() = 10

    var data3: Int
        get() = 10
        set(value){
            println("set...")
        }

    //인터페이스내에 정상 로직의 함수 추가 가능....
    fun some1(){}
    fun some2()//추상형...
    fun some3()
}

interface Interface2

//클래스를 선언하면서 상위 클래스 상속(1개만), 인터페이스 구현(여러개)
//순서는 없다..
//상위, 구현에 추상함수만 없다면 오버라이드는 클래스 선언자가 필요하면..
//추상함수가 있다면 무조건..오버라이드..
class Sub: Interface1, Super(), Interface2 {
    //이름이 여러곳에 선언되어 있지만 모두 추상형인 경우..
    //오버라이드 받으면 끝...
    override fun some2() {

    }
    //모두 구현함수.. 오버라이드 받을 수는 있지만.. 이 곳에서 상위 함수를 호출하고 싶은경우..
    //이름이 중복됨으로 타입을 명시해서..
    override fun some1() {
        super<Interface1>.some1()
        super<Super>.some1()
    }
    //하나가 추상, 하나는 구현함수.. 추상형이 있음으로 무조건 오버라이드..
    override fun some3() {
        super.some3()
    }

    override val data1: String ="hello"
}

fun main() {
//    val obj = Super()//추상 클래스는 객체 생성 이용 불가능..

//    val obj = Interface1()//인터페이스는 클래스는 아니다.. 생성 안된다..

    val obj1: Sub = Sub()
    val obj2: Super = Sub()
    val obj3: Interface1 = Sub()//인터페이스가 클래스는 아니지만 타입으로는 이용된다..
}