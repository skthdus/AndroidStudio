package com.example.ex20221129

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class LunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)
        
        // Adapter View 만드는 6단계
        
        // 1. Container 결정 (위치 결정)
        val lvLunch = findViewById<ListView>(R.id.lvLunch)
        val etAdd = findViewById<EditText>(R.id.etAdd)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnResult = findViewById<Button>(R.id.btnResult)
        val tvLunch = findViewById<TextView>(R.id.tvLunch)
        // viewBinding 기법 -> 초기화를 해결

        // 2. Template 결정 (아이템 디자인)
        // lunch_list.xml

        // 3. Item 결정 (만약, 자료형이 여러 개라면 VO class 생성!)
        val data = ArrayList<String>()
        data.add("돈까스")
        data.add("제육볶음")

        // 4. Adapter 결정
        // (만약, TextView와 ArrayList<String> 사용한다면 ArrayAdapter 사용 가능)
        // 1) 페이지 정보
        // 2) 항목 뷰 디자인
        // 3) TextView의 id
        // 4) data
        val adapter = ArrayAdapter<String>(this, R.layout.lunch_list, R.id.tvMenu, data)

        // 5. Container 에 Adapter 부착
        lvLunch.adapter = adapter

        // 6. Event 처리
        // 1) btnAdd를 눌렀을 때, etAdd의 값을 가져와서
        // 2) data에 추가!!
        // 3) adapter 새로고침

        btnAdd.text = "추가"
        btnAdd.setTextSize(18F)

        btnAdd.setOnClickListener {
            data.add(etAdd.text.toString())
            adapter.notifyDataSetChanged()
            etAdd.text=null
        }

        btnResult.setOnClickListener {

            val rd = java.util.Random()
            val menu = rd.nextInt(data.size)
            tvLunch.text = data.get(menu)
        }

    }
}