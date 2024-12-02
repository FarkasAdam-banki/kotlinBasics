package com.example.kotlinbasics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GreetingsActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText;
    private lateinit var greetingButton: Button;
    private lateinit var resultTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greetings)
        // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //  insets
        //}

        nameEditText = findViewById(R.id.nameEditText)
        greetingButton = findViewById(R.id.greetingButton)
        resultTextView = findViewById(R.id.resultTextView)

        greetingButton.setOnClickListener(){
            val name = nameEditText.text
            if(name.isNotEmpty()){

                val greetingText = when{
                    name.length <= 3 -> "Hello $name! fe rövid neved van"
                    name.length >= 10 -> "Hello $name! de hosszu neved van"
                    else -> "hello $name!"
                }
                resultTextView.text = greetingText
                hideKeyboard()
                nameEditText.text.clear()

            }else{
                Toast.makeText(this, "kérlek add meg a neved",Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(nameEditText.windowToken, 0)
    }
}