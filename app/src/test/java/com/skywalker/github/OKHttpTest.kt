package com.skywalker.github

import com.skywalker.github.api.SearchRepositories
import okhttp3.*
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import retrofit2.adapter.rxjava2.Result.response



class OKHttpTest{

    private val httpClient=OkHttpClient.Builder().addInterceptor(LoggingInterceptor()).build()
    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    @Test
    fun test1(){
        val repositories = retrofit.create(SearchRepositories::class.java)
        val body1 = repositories.repositories("anko",1,2).execute()
        println(body1.body())
    }

    @Test
    fun fakeTest(){
        val client=OkHttpClient.Builder().addInterceptor(FakeInterceptor()).build()
        val request=Request.Builder().url("http://www.skywalker.com").build()
        val response=client.newCall(request).execute()
        println(response.body()?.string())
    }
}


class LoggingInterceptor :Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()
        val t1=System.nanoTime()
        println("Send request ${request.url()} on ${chain.connection()} ${request.headers()}")
        val response=chain.proceed(request)
        val t2=System.nanoTime()
        println("Received response for ${response.request().url()} in ${t2-t1} ${response.headers()}")

        return response
    }
}

class FakeInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var response:Response
        response = if (chain.request().url().toString().equals("http://www.skywalker.com/")){
            val json = "{\"code\": 200, \"message\": \"success\"}"
            Response.Builder()
                    .code(200)
                    .addHeader("Content-Type", "application/json")
                    .body(ResponseBody.create(MediaType.parse("application/json"), json))
                    .message(json)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_2)
                    .build()
        }else{
            chain.proceed(chain.request())
        }

        return response
    }
}

class TestInterceptor:Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val original=chain.request()
        val response:Response
        val request=original.newBuilder().url("http://www.fake.com").build()
        if (true){
            response=chain.proceed(request)
        }else{
            response=Response.Builder()
                    .code(404)
                    .body(ResponseBody.create(MediaType.parse("application/json"),"hello world"))
                    .message("hello message")
                    .request(request)
                    .protocol(Protocol.QUIC)
                    .build()
        }

        return response
    }

}

