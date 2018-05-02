package com.skywalker.architecture

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        "12" plus "234" plus ""
    }

    infix fun String.plus(name:String):String{
        return "$this fuck $name"
    }
}
