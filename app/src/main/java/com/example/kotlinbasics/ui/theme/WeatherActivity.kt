package com.example.kotlinbasics.ui.theme

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbasics.R
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.WearherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {

    private lateinit var textviewTemp: TextView
    private val apikey = "c9eb0a037a09902fbb9ce6afeaa9fba2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)

    fetchWeatherData()




    }

    private fun fetchWeatherData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val wearherService = retrofit.create(WearherService::class.java)

        val call = wearherService.getWeather("Tatabánya","metric",apikey)
        call.enqueue(object: Callback<WeatherResponse>{
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful){
                    val weatherResponse = response.body()
                    if(weatherResponse!=null){
                        val weatherInfo = weatherResponse.main.temp
                        textviewTemp.text = weatherInfo.toString()
                    }
                }

            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("HIBA","Hiba az alo kérés során")
            }
        })

    }


}