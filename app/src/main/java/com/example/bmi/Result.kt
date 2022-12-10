package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlin.Result

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val genderView = findViewById<TextView>(R.id.Gender)
        val ResultView = findViewById<TextView>(R.id.Result)
        val AgeView = findViewById<TextView>(R.id.Age)


        var extras = intent.extras
        var age =extras?.getInt("age" , 0)
        var gender =extras?.getString("gender" , "")
        var result = extras?.getDouble("Result" , 0.00)

        genderView.setText("Gender : ${gender}")
        ResultView.setText("Result : ${result.toString()}")
        AgeView.setText("Age : ${age}")

    }
}