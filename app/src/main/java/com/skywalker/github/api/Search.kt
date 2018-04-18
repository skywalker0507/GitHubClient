package com.skywalker.github.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRepositories{
    @GET("/search/repositories")
    fun repositories(
            @Query("q") keywords:String,
            //@Query("sort")type:String="stars",
            @Query("page")page:Int,
            @Query("per_page")itemsPerPage: Int
    ):Observable<ResponseBody>

    @GET("/search/repositories")
    fun repositories(@Query("q") keywords:String): Observable<ResponseBody>
}

interface SearchUsers{
    @GET("/search/users")
    fun users(@Query("q") keywords:String)
}
