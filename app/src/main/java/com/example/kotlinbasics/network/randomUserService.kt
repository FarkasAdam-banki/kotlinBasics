package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import javax.xml.transform.Result

interface RandomUserService {

    @GET("/api/")
    fun getRandomUser(
        @Query("results") result: Int,
    ): Call<RandomUserResponse>
}
