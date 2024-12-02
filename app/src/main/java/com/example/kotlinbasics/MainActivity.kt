package com.example.kotlinbasics


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


//gitről
    

    private lateinit var openGreetingButton:Button;
    private lateinit var openCalculatorButton: Button;

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

        openGreetingButton.setOnClickListener(){
            val intent = Intent(this,GreetingsActivity::class.java)
            startActivity(intent)
        }
        openCalculatorButton.setOnClickListener(){
            val intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
   }

}
