package com.example.a20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

// : Kotlin에서 상속
class ConstraintActivity : AppCompatActivity() {
    // OnCreate() 는 Activity가 실행될 때 최초 딱 한번(가장 먼저) 호출되는 메서드
    // : Activity 생명주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ***** xml 이랑 KtClass랑 연결하는 코드 없으면 화면 안 뜸 *****
        setContentView(R.layout.activity_constraint)

        // 1. xml의 View에 id를 지정
        // 2. id값을 이용해서 view를 찾아온다 (findViewById)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        // id값은 문자열로 정해줬는데 받아오는 값이 Int
        // R 폴더에 모든 뷰(리소스)들의 id값이 저장되는데 주소값이 저장
        // 16진수 상수형태로 저장이 되어있다(Int)

    }
}