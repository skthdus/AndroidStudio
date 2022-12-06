package com.example.fullstackapplication.auth

import android.content.Intent
import android.graphics.Paint.Join
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fullstackapplication.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val btnIntroLogin = findViewById<Button>(R.id.btnIntroLogin)
        val btnIntroJoin = findViewById<Button>(R.id.btnIntroJoin)
        val btnIntroNo =findViewById<Button>(R.id.btnIntroNo)

        // login -> LoginActivity로 이동
        btnIntroLogin.setOnClickListener {
            val intent = Intent(this@IntroActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        // join -> JoinActivity로 이동
        btnIntroJoin.setOnClickListener {
            val intent = Intent(this@IntroActivity, JoinActivity::class.java)
            startActivity(intent)
        }

        // no -> Firebase에서 익명으로 접속할 수 있는 권한 받아와서
        // 성공 MainActivity로 이동
        btnIntroNo.setOnClickListener {

        }
    }
}