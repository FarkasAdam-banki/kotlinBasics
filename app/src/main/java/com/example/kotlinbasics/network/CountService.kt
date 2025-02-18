package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.CountMemberResponse
import com.example.kotlinbasics.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountService{

    @GET("controllers/api.php?count=true")
    fun getCount(): Call<CountMemberResponse>
}