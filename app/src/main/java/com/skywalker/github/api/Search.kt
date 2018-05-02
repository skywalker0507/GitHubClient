package com.skywalker.github.api

import android.arch.lifecycle.LiveData
import com.skywalker.github.model.Repositories
import com.skywalker.github.model.UserItem
import com.skywalker.github.model.Repository
import com.skywalker.github.model.TopicsItem
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRepositories{
    @GET("/search/repositories")
    fun repositories(
            @Query("q") keywords:String,
            @Query("page")page:Int,
            @Query("per_page")itemsPerPage: Int,
            @Query("sort")type:String="stars"
    ): Call<Repositories>

}

interface SearchUsers{
    @GET("/search/users")
    fun users(@Query("q") keywords:String):LiveData<List<UserItem>>
}

interface SearchTopics{
    @GET("/search/topics")
    fun topics(
            @Query("q")keywords:String,
            @Query("page")page:Int,
            @Query("per_page")itemsPerPage: Int
    ):LiveData<List<TopicsItem>>

    companion object {
        val httpClient:OkHttpClient= OkHttpClient.Builder().addInterceptor {
            val original = it.request()
            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                    .header("Accept", "application/vnd.github.mercy-preview+json") // <-- this is the important line

            val request = requestBuilder.build()
            println("before")

            return@addInterceptor it.proceed(request)

        }.build()
    }

}
