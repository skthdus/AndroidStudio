package com.example.a20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {

    val imgArray = intArrayOf(R.drawable.pink, R.drawable.black, R.drawable.blue,
        R.drawable.yellow, R.drawable.red)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        // View의 id값 다 찾아오기
        val img = findViewById<ImageView>(R.id.img)
        val btnPre = findViewById<Button>(R.id.btnPre)
        val btnNext = findViewById<Button>(R.id.btnNext)

//        img.setImageResource(R.drawable.pink)

        var index = 0

        // 1. Pre 버튼을 눌렀을 때 (setOnClickListener)
        // 1-1. index -1 감소
        // 해당 index에 있는 img의 id를 가져와서
        // ImageView에 set하자!
        // index의 조건 : 0보다 작으면 다시 index값을 size-1으로 돌리자

        btnPre.setOnClickListener {
            index--
            if(index < 0 )  index = imgArray.size -1

                img.setImageResource(imgArray[index])

        }


        // 2. Next 버튼을 눌렀을 때
        // 2-1. index +1 증가
        // 해당 index에 있는 img의 id를 가져와서
        // ImageView를 set하자
        // index의 조건 : size -1보다 크면 다시 index 값을 0 으로

        btnNext.setOnClickListener {
            index++
            if(index>imgArray.size -1) index = 0

            img.setImageResource(imgArray[index])
        }




    }
}