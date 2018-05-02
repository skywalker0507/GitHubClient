package com.skywalker.github

import org.jetbrains.anko.doAsync
import org.junit.Test
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty

class RegexTest(){
    @Test
    fun test1(){
        val list= mutableListOf(1,2,3,4,5,"6",7.0)
        val s="010011101001110101011"
        val regex=Regex("1+")
        val results=regex.findAll(s)
        results.map {
            if (it.value.length==1){
                return@map "${it.range.first} "
            }else{
                return@map "(${it.range.first} - ${it.range.last})"
            }
        }.forEach {
            println(it)
        }

        list.filter { it is Int }.slice(IntRange(1,10))

        results.toList().flatMap { it.value.split("1")}

        val id:String by object {
            operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
                return "$thisRef, thank you for delegating '${property.name}' to me!"
            }
        }

        var name:String by object {
            operator fun getValue(thisRef:Any?,property: KProperty<*>):String{
                return "hello world"
            }

            operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
                println("$value has been assigned to '${property.name} in $thisRef.'")
            }
        }

        val item:Int by lazy {
            return@lazy 1
        }
    }
}
