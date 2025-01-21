package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
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

    private lateinit var textviewTemp: TextView
    private lateinit var textviewTempMin: TextView
    private lateinit var textviewSpeed: TextView
    private lateinit var editTextCity: EditText
    private lateinit var buttonGetWeather: Button
    private val apikey = "c9eb0a037a09902fbb9ce6afeaa9fba2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)


        textviewTemp = findViewById(R.id.textview_temp)
        textviewTempMin = findViewById(R.id.textview_tempmin)
        textviewSpeed = findViewById(R.id.textview_windSpeed)
        editTextCity = findViewById(R.id.editTextCity)
        buttonGetWeather = findViewById(R.id.button_getWeather)


        buttonGetWeather.setOnClickListener {
            val city = editTextCity.text.toString()
            if (city.isNotEmpty()) {
                fetchWeatherData(city)
            } else {
               
                textviewTemp.text = "Kérjük, adjon meg egy várost!"
            }
        }
    }

    private fun fetchWeatherData(city: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherService = retrofit.create(WeatherService::class.java)

        val call = weatherService.getWeather(city, "metric", apikey)
        call.enqueue(object: Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        val weatherInfo = weatherResponse.main.temp
                        val weatherInfoMin = weatherResponse.main.humidity
                        val weatherInfoSpeed = weatherResponse.wind.speed

                        textviewTemp.text = "Aktuális hőmérséklet: ${weatherInfo}°C"
                        textviewTempMin.text = "Páratartalom: ${weatherInfoMin}%"
                        textviewSpeed.text = "Szél sebessége: ${weatherInfoSpeed} km/h"
                    }
                } else {
                    Log.e("WeatherActivity", "Hibás válasz: ${response.code()}")
                    textviewTemp.text = "Hiba történt a város keresésekor."
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("WeatherActivity", "Hiba a hálózati kérés során: ${t.message}")
                textviewTemp.text = "Hiba történt a hálózati kérés során."
            }
        })
    }
}
