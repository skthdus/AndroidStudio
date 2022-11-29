package com.example.ex20221129

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etId = findViewById<EditText>(R.id.etId)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin2 = findViewById<Button>(R.id.btnLogin2)


        btnLogin2.setOnClickListener {
            // EditText에 적혀있는 내용을 가져온다 (변수에 저장)
            val id = etId.text.toString()
            val pw = etPw.text.toString()

            // id, pw가 skthdus, 12345인지 확인 (판단)
            val intent = Intent()
            if(id == "skthdus" && pw == "12345"){
                // RESULT_OK
                setResult(RESULT_OK, intent)
//              finish()
             } else{
                // RESULT_CANCELED
                 setResult(RESULT_CANCELED, intent)
//               finish()
            }
            finish()
        }
        // setResult(resultCode, intent)
    }
}