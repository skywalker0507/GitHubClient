package com.skywalker.github

import android.util.Log
import okio.Okio
import org.junit.Test
import java.io.File
import java.nio.ByteBuffer

class OkioTest{

    @Test
    fun readFileTest(){
        val file=File("")
        val buffer=Okio.buffer(Okio.source(file))
        val byteBuffer=ByteBuffer.allocate(10)
        val content=buffer.read(byteBuffer)

    }





}