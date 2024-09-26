package com.example.lab2

import kotlin.math.sin
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.TextView
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var label: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextNumberDecimal)
        button = findViewById(R.id.button2)
        label = findViewById(R.id.textView4)


        button.setOnClickListener { function_sin() }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun function_sin(){
        val N = editText.text.toString()
        val result = label
        val n = N.toInt()
        var tmp = 0.0
        var m = 0.0


        for (i in 1..n){
            m = 0.0
            for(j in 1..i){
                val transformJ = j.toDouble()
                m += sin(transformJ)


            }
            tmp += (1.0/m)
        }
        result.text = "Результат: $tmp"
    }
}