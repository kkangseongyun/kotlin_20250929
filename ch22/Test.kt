package org.example.ch22

import com.google.gson.Gson
import java.io.File

//json 데이터를 파싱해서.. 데이터를 담기 위한 일종의 DTO
data class Data(val id: Int, val name: String, val addr: String, val age: String)

fun main() {
    val file = File("build/resources/main/test.json")
    val inputStream = file.inputStream()
    //읽어 들이기..
    val inputString = inputStream.bufferedReader().use { it.readText() }

    //json 은 애플리케이션에서 읽는 순간은 문자열에 지나지 않는다..
    //json parser로 파싱해서.. 우리가 원하는 데이터 추출..
    val gson = Gson()
    val list: List<Data> = gson.fromJson(inputString,
        Array<Data>::class.java).toList()

    //데이터 분석..
    list.filter { it.addr.equals("seoul") }//addr 이 seoul 인 데이터만..
        .groupBy { it.age }//그룹핑해서.. => map 으로 전달..
        .forEach {
            println("${it.key} - ${it.value.count()}")
            it.value.forEach {
                println("${it.name} - ${it.addr} - ${it.age}")
            }
        }
}