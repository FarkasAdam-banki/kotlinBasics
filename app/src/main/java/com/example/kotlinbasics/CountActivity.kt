package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.model.CountMemberResponse
import com.example.kotlinbasics.network.CountService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountActivity : AppCompatActivity() {

    private lateinit var textview_count: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_count)
        textview_count = findViewById(R.id.textview_count)
        fetchCountFromApi()
    }


    private fun fetchCountFromApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://banki13.komarom.net/2024/farkasa/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val countService = retrofit.create(CountService::class.java)
        val call = countService.getCount()

        call.enqueue(object : Callback<CountMemberResponse> {
            override fun onResponse(call: Call<CountMemberResponse>, response: Response<CountMemberResponse>) {
                handleApiResponse(response)
            }

            override fun onFailure(call: Call<CountMemberResponse>, t: Throwable) {
                handleApiError(t)
            }
        })
    }


    private fun handleApiResponse(response: Response<CountMemberResponse>) {
        if (response.isSuccessful) {
            val countMemberResponse = response.body()
            countMemberResponse?.let {
                updateCountUI(it.count)
            } ?: run {
                Log.e("HIBA", "A válasz üres")
            }
        } else {
            Log.e("HIBA", "Hiba történt a válasz feldolgozása közben: ${response.message()}")
        }
    }
    private fun handleApiError(t: Throwable) {
        Log.e("HIBA", "Hiba az API kérés során", t)
    }

    private fun updateCountUI(count: Int) {
        Log.e("Count", "Received count: $count")
        textview_count.text = "Count: $count"
    }

}
