package com.skywalker.basicsample.view

import com.skywalker.basicsample.model.Comment

interface CommentClickCallback{
    fun onClick(comment: Comment)
}