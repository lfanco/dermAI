package com.example.fanconic.dermAI.retrofit

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import kotlin.String as String1


private var protocol: String1 = "http://"
// insert backend address here.
private var address: String1 = "ec2-52-14-79-236.us-east-2.compute.amazonaws.com"
private var port = 80
private var urlString = "$protocol$address:$port"

class APIKindaStuff {
    interface APIService {
        @GET("/users/{user}")
        fun greetUser(@Path("user") user: String1): Call<ResponseBody>

        @Headers("Content-type: application/json")
        @POST("/api/mole_prediction")
        fun getVectors(@Body body: JsonObject): Call<ResponseBody>
    }
    companion object {
        private val retrofit = Retrofit.Builder()
                .baseUrl(urlString)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        var service: APIService = retrofit.create(APIService::class.java)
    }
}