package com.skywalker.github

import org.junit.Test

class Test{

    @Test
    fun test1(){
        val list= mutableListOf<Item>()
        repeat(10,{
            val item=Item()
            list.add(item)
        })

        println(Item.count)
    }

    class Item{

        companion object {
            private const val start=0
            var count= start
        }

        init {
            count+=1
        }

    }
}
