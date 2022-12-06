package com.example.fullstackapplication.auth

import android.content.Intent
import android.graphics.Paint.Join
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.fullstackapplication.MainActivity
import com.example.fullstackapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class IntroActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        auth = Firebase.auth

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
            auth.signInAnonymously().addOnCompleteListener(this) {task ->
                if(task.isSuccessful){
                    // 익명 로그인 성공
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    // 익명으로 로그인 성공하면 MainActivity로 이동
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else{
                    // 익명 로그인 실패
                    // 서버 문제
                }
            }

        }
    }
}