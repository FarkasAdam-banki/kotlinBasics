package com.example.kotlinbasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.model.User

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_list)
        val users = listOf(
            User("Gipsz Jakab", "gj@email.com", R.drawable.user),
            User("Kovács Béla", "kb@email.com", R.drawable.user),
            User("Nagy Anna", "na@email.com", R.drawable.user),
            User("Tóth Zoltán", "tz@email.com", R.drawable.user),
            User("Szabó Laura", "sl@email.com", R.drawable.user),
            User("Varga Gábor", "vg@email.com", R.drawable.user),
            User("Kiss Petra", "kp@email.com", R.drawable.user),
            User("Horváth Péter", "hp@email.com", R.drawable.user),
            User("Molnár Emese", "me@email.com", R.drawable.user),
            User("Farkas Tamás", "ft@email.com", R.drawable.user),
            User("Papp Klára", "pk@email.com", R.drawable.user),
            User("Juhász Viktor", "jv@email.com", R.drawable.user),
            User("Balogh Mária", "bm@email.com", R.drawable.user),
            User("Sipos Dániel", "sd@email.com", R.drawable.user)
        )
        val recyclerView:RecyclerView = findViewById(R.id.userListRecyclerView)


    }
}