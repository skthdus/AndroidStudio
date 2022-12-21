package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Question2 : AppCompatActivity() {
    val imgArray = intArrayOf(R.drawable.toys, R.drawable.poster, R.drawable.toystory)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        val btnPre = findViewById<Button>(R.id.btnPre)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val img = findViewById<ImageView>(R.id.img)

        var index = 0

        btnPre.setOnClickListener {
            index--
            if(index<0){
                index=2
            }
            img.setImageResource(imgArray[index])
        }

        btnNext.setOnClickListener {
            index++
            if(index>2){
                index=0
            }
            img.setImageResource(imgArray[index])
        }

    }
}