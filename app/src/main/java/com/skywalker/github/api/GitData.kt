package com.skywalker.github.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.github.com/repos/octocat/Hello-World/git/trees/master
interface GetTree{
    @GET("repos/{owner}/{repo}/git/trees/{sha}")
    fun tree(@Path("owner")owner:String,@Path("repo")repo:String,@Path("sha")sha:String="master"):Observable<ResponseBody>
}