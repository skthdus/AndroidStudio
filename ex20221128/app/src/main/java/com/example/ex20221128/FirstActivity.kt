package com.example.ex20221128

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

//        val btnNext = findViewById<Button>(R.id.btnNext)

        // btnNext를 클릭했을 때, SecondActivity로 이동!
//        btnNext.setOnClickListener {
            // Activity로 이동하는 Intent (명시적 인텐트)
            // (시작Activity, 도착Activity)
            // (this, java class)
            // Kclass로 만들어진 Activity를 java class로 바꿔줘야 한다
            // 액티비티명::class.java ---> java class로 바뀜
//            var intent = Intent(this,
//                SecondActivity::class.java
//            )

            // 실행!!!!
//            startActivity(intent)
//        }


        val btnNext = findViewById<Button>(R.id.btnNext)

        //btnNext를 누루면 SecondActivity로 color 코드를 가지고 넘어간다
        btnNext.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}