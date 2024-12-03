package com.example.kotlinbasics.model


data class WeatherResponse(
    val main: Main,
)

data class Main(
    val temp: Float,
    val temp_min: Float
)


