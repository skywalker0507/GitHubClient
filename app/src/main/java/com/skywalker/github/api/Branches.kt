package com.skywalker.github.api

import android.arch.lifecycle.LiveData
import com.skywalker.github.model.Branch
import retrofit2.http.GET
import retrofit2.http.Path

interface ListBranches{
    @GET("/repos/{owner}/{repo}/branches")
    fun branches(@Path("owner")owner:String,@Path("repo")repo:String):LiveData<List<Branch>>
}