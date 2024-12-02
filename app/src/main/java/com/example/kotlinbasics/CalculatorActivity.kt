package com.example.kotlinbasics

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    private lateinit var firstNumEditText: EditText
    private lateinit var secondNumEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var addButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)


        firstNumEditText = findViewById(R.id.firstNum)
        secondNumEditText = findViewById(R.id.secondNum)
        resultTextView = findViewById(R.id.eredmenyText)
        addButton = findViewById(R.id.addButton)
        deleteButton = findViewById(R.id.deleteButton)

        addButton.setOnClickListener {
            val  firstNum = firstNumEditText.text.toString()
            val  secondNum = secondNumEditText.text.toString()

            if (firstNum.isNotEmpty() && secondNum.isNotEmpty()) {
                    val num1 = firstNum.toInt()
                    val num2 = secondNum.toInt()
                    val result = num1 + num2
                    resultTextView.text = "Eredmény: $result"
               } else {
                Toast.makeText(this, "kérem töltse ki mindkét mezőt!", Toast.LENGTH_SHORT).show()
            }
        }
        deleteButton.setOnClickListener {
            firstNumEditText.text.clear()
            secondNumEditText.text.clear()
            resultTextView.text = "Eredmény:"
        }
    }
}
