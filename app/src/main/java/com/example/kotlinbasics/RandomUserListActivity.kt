package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.adapter.UserAdapter
import com.example.kotlinbasics.model.RandomUserResponse
import com.example.kotlinbasics.network.RandomUserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_random_user)

        fetchRandomUserList()
    }

    private fun fetchRandomUserList() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val randomUserService = retrofit.create(RandomUserService::class.java)

        val call = randomUserService.getRandomUser(10);
        call.enqueue(object : Callback<RandomUserResponse> {
            override fun onResponse(call: Call<RandomUserResponse>, response: Response<RandomUserResponse>) {
                if (response.isSuccessful) {
                    val randomUserResponse = response.body()
                    if (randomUserResponse != null) {
                        Log.e("Eredmény", randomUserResponse.results.toString())

                    }
                }
            }

            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {
                Log.e("HIBA", "Hiba az API kérés során", t)
            }
        })
    }
}
