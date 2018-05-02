package com.skywalker.github.model

data class Repositories(val total_count:Int,val items:List<Repository>)
data class Repository(
        val name:String,
        val full_name:String,
        val owner: Owner,
        val html_url:String,
        val description:String,
        val url:String,
        val stargazers_count:Int,
        val watchers_count:Int,
        val forks_count:Int,
        val language:String,
        val default_branch:String

)

data class Owner(val avatar_url:String,val html_url:String)