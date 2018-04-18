package com.skywalker.github.model

data class UserItem(
        val login:String,
        val avatar_url:String,
        val url:String,
        val html_url:String,
        val repos_url:String,
        val type:String
)