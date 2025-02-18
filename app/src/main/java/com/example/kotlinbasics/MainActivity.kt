package com.example.kotlinbasics


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    private lateinit var openGreetingButton:Button;
    private lateinit var openCalculatorButton: Button;
    private lateinit var openWeatherButton: Button;
    private lateinit var openUserListButton: Button;
    private lateinit var randomOpenUserListButton:Button;
    private lateinit var seatPlan:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
          //  insets
        //}

        openGreetingButton = findViewById(R.id.openGreetingButton)
        openCalculatorButton = findViewById(R.id.openCalculatorButton)
        openWeatherButton = findViewById(R.id.openWeatherButton)
        openUserListButton = findViewById(R.id.openUserListButton)
        randomOpenUserListButton = findViewById(R.id.randomOpenUserListButton)
        seatPlan =findViewById(R.id.seatPlan);
        openGreetingButton.setOnClickListener(){
            val intent = Intent(this,GreetingsActivity::class.java)
            startActivity(intent)
        }
        openCalculatorButton.setOnClickListener(){
            val intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }

        openWeatherButton.setOnClickListener(){
            val intent = Intent(this,WeatherActivity::class.java)
            startActivity(intent)
        }
        openUserListButton.setOnClickListener(){
            val intent = Intent(this,UserListActivity::class.java)
            startActivity(intent)
        }
        randomOpenUserListButton.setOnClickListener(){
            val intent = Intent(this,RandomUserListActivity::class.java)
            startActivity(intent)
        }
        seatPlan.setOnClickListener(){
            val intent = Intent(this,CountActivity::class.java)
            startActivity(intent)
        }
   }

}