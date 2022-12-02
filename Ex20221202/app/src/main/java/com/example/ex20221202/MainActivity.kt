package com.example.ex20221202

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View들의 Id값 찾아오기
        val btnLog = findViewById<Button>(R.id.btnLog)
        val bnv = findViewById<BottomNavigationView>(R.id.bnv)
        val fl = findViewById<FrameLayout>(R.id.fl)

        // Fragment 구현
        // bnv에서 선택한 메뉴에 따라 fl에 표시할 Fragment를 갈아끼운다

        bnv.setOnItemSelectedListener {
            // item -> 내가 선택한 메뉴의 정보
            Log.d("id", it.itemId.toString())
            when(it.itemId){

                R.id.tap1 ->{
                    Toast.makeText(applicationContext, "첫번째 탭입니다",Toast.LENGTH_SHORT).show()
                    // beginTransaction() : 프래그먼트의 추가/변경/삭제
                    // 1) fragment가 들어갈 위치
                    // 2) 내가 갈아끼울 Fragment 객체
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment1()
                    ).commit()
                }
                R.id.tap2 -> {
                    Toast.makeText(this, "두번째 탭입니다",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment2()
                    ).commit()

                }
                R.id.tap3 -> {
                    Toast.makeText(applicationContext, "세번째 탭입니다",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment3()
                    ).commit()
                }
                R.id.tap4 -> {
                    Toast.makeText(applicationContext, "네번째 탭입니다",Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        Fragment4()
                    ).commit()
                }

            }

            //false : 이벤트가 끝나지 않음
            // 클릭이 안 먹힘
            // true : 이벤트 종료를 감지해야 됨
            true

        }
    }
}