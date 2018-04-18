package com.skywalker.github


import com.skywalker.github.api.SearchRepositories

import org.junit.Test

import java.io.IOException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class APITest {
    @Test
    fun testSearch() {

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val repositories = retrofit.create(SearchRepositories::class.java)
        val body = repositories.repositories("anko",1,2)
        body.subscribe(object : Observer<ResponseBody> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(responseBody: ResponseBody) {
                try {
                    println(responseBody.string())
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

            override fun onError(e: Throwable) {
                println(e.message)
            }

            override fun onComplete() {

            }
        })
    }
}
