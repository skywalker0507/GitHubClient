package com.skywalker.github


import com.skywalker.github.api.GetTree
import com.skywalker.github.api.SearchRepositories
import com.skywalker.github.api.SearchTopics

import org.junit.Test

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APITest {

    private val retrofit1:Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Test
    fun testSearch1() {

        val repositories = retrofit1.create(SearchRepositories::class.java)
        val body1 = repositories.repositories("anko",1,2).execute()
        println(body1.body())

    }

    @Test
    fun testSearch2() {

        val retrofit2 = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(SearchTopics.httpClient)
                .build()
        val topics=retrofit2.create(SearchTopics::class.java)
        val body2 = topics.topics("ruby",1,2)
        println(body2.value)
    }

    @Test
    fun testTree(){
        val tree=retrofit1.create(GetTree::class.java)
        val body3=tree.tree("skywalker0507","iDouban")
        body3.subscribe {
            println(it.string())
        }
    }
}
