package com.example.a20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1. View들의 id값을 찾아오자 (findViewById)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPw = findViewById<TextInputEditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 2. Button에 Event 달아주기 (setOnClickListener)

        btnLogin.setOnClickListener {

        // 2-1. EditText에 적혀있는 email, password값을 가져오기
        // (email, pw : 변수 ) ---> 문자열로 형변환

            var email = etEmail.text.toString()
            var pw = etPw.text.toString()

        // 2-2. 가져온 emai, pw가 smhrd@smhrd.or.kr, qwer1234 가
        // 맞는지 판단 (조건식)
        // 맞다면 Toast로 "로그인 성공"
        // 틀리면 Toast로 "로그인 실패"를 띄워주세요!!

          if(email=="smhrd@smhrd.or.kr" && pw=="qwer1234"){
            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
          }else{
            Toast.makeText(this,"로그인 실패", Toast.LENGTH_SHORT).show()
          }
        }




    }
}