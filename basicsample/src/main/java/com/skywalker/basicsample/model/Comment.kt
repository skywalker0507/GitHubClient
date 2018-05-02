package com.skywalker.basicsample.model

import java.util.*

interface Comment{
    fun getId():Int
    fun getProductId():Int
    fun getText():String
    fun getPostedAt():Date
}