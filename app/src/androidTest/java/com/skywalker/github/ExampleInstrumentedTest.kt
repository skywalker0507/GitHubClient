package com.skywalker.github

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.skywalker.github", appContext.packageName)
    }


    fun hideTest(){

    }

    @Test
    fun printTest(){


        val clazz= Log::class.java
        //val t=clazz.methods
        //println(t)
        val method=clazz.getMethod("println",Int::class.java, String::class.java, String::class.java)
        method.invoke(null, 6,"123","abc")
    }
}
