package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {

    private lateinit var textviewTemp: TextView  // TextView deklaráció
    private val apikey = "c9eb0a037a09902fbb9ce6afeaa9fba2"  // API kulcs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)

        // TextView inicializálás a layout-ból
        textviewTemp = findViewById(R.id.textview_temp)

        fetchWeatherData()  // Időjárás adatainak lekérése
    }

    private fun fetchWeatherData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")  // API alapkép URL
            .addConverterFactory(GsonConverterFactory.create())  // JSON konverter
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        // API hívás
        val call = weatherService.getWeather("Tatabánya", "metric", apikey)
        call.enqueue(object: Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        val weatherInfo = weatherResponse.main.temp
                        textviewTemp.text = weatherInfo.toString()  // Kiírás a TextView-ba
                    }
                } else {
                    Log.e("WeatherActivity", "Hibás válasz: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("WeatherActivity", "Hiba a hálózati kérés során: ${t.message}")
            }
        })
    }
}
