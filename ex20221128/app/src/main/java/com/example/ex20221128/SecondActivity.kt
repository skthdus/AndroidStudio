package com.example.ex20221128

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnPre = findViewById<Button>(R.id.btnPre)

        // btnPre를 눌렀을 때 이전 페이지 (FirstActivity로 돌아간다)
        btnPre.setOnClickListener {
            var intent = Intent(this, FirstActivity::class.java)
            startActivity(intent) // stack에 Activity를 넣는다
            finish() // stack 구조에서 out 시키기
        }
    }
}