package com.example.kotlinbasics.model


data class WeatherResponse(
    val main: Main,
    val wind: Wind
)

data class Main(
    val temp: Float,
    val humidity: Float
)

data class Wind(
    val speed: Float
)


