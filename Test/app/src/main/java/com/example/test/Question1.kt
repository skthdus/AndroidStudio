package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Question1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question1)

        val btnFirst = findViewById<Button>(R.id.btnFirst)
        val btnSecond = findViewById<Button>(R.id.btnSecond)
        val btnThird = findViewById<Button>(R.id.btnThird)

        btnFirst.setOnClickListener {
            btnFirst.setText("1ST BUTTON!")
        }

        btnSecond.setOnClickListener {
            btnSecond.setText("2ND BUTTON!")
        }

        btnThird.setOnClickListener {
            btnThird.setText("3RD BUTTON!")
        }
    }
}