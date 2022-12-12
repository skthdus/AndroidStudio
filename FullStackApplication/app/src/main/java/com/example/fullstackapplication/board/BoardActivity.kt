package com.example.fullstackapplication.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.example.fullstackapplication.R

class BoardActivity : AppCompatActivity() {

    lateinit var imgLoad : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        // id값 다 찾아오기
        imgLoad = findViewById<ImageView>(R.id.imgLoad)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etContent = findViewById<EditText>(R.id.etContent)
        val imgWrite = findViewById<ImageView>(R.id.imgWrite)
    }
}