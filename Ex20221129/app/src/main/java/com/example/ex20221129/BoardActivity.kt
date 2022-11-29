package com.example.ex20221129

import android.app.Instrumentation.ActivityResult
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class BoardActivity : AppCompatActivity() {
    
    // 초기화를 나중에 하겠습니다 : lateinit
    // 전역 View로 사용이 가능한 상태
    lateinit var tvContent: TextView
    lateinit var btnWrite: Button
    lateinit var btnBoard : Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        tvContent = findViewById<TextView>(R.id.tvContent)
        btnWrite = findViewById<Button>(R.id.btnWrite)
        val btnLogin1 = findViewById<Button>(R.id.btnLogin1)
        val lv = findViewById<ListView>(R.id.lv)
        val etBoard = findViewById<EditText>(R.id.etBoard)
        btnBoard = findViewById<Button>(R.id.btnBoard)
        btnBoard.isEnabled = false

        lv.setOnItemClickListener { adapterView, view, i, l ->
            //adapterView : ListView에 대한 정보
            // view : ListView가 있는 현재 페이지에 대한 정보
            // i (position) -> 내가 클릭한 item 위치(index 0 ~)
            // l (id) : long -> 내가 클릭한 item의 고유한 값
            if(i == 0) {
                Toast.makeText(this, adapterView.adapter.getItem(i).toString(), Toast.LENGTH_SHORT).show()
            }

        }


        // 1. 로그인 버튼을 누르면 LoginActivity로 이동
        // (단, LoginActivity에서 받아올 결과 값이 있음 : 양방향)

        btnLogin1.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // 양방향 통신
            result.launch(intent)
        }

        // onCreate() 안쪽에

        // Adapter View를 사용하기 위한 6단계

        // 1. Container 결정
        // -> ListView의 위치를 결정!!


        // 2. Template 결정
        // -> 각 항목(Item)에 적용될 디자인을 결정!!
        // -> Layout패키지에 xml형태로 생성!!
        // board_list.xml 최상위 레이아웃 : TextView
        // 이때, id는 tvBoard


        // 3. Item 결정
        // VO 
        val data = ArrayList<String>()
        data.add("1. 오늘 날씨는 추움")
        data.add("2. 꾸리꾸리함")
        data.add("3. 집에 보내줘")

        // 4. Adapter 결정
        // Adapter : 디자인 (항목 뷰, 템플릿) + Item 결합해서
        // Adapter View에 동적으로 뿌려주는 역할!!

        // ArrayAdapter 를 사용하자
        // 조건) 템플릿이 TextView, 아이템 요소가 String
        // 생성자의 요소 4개
        // 1) 페이지 정보
        // 2) 템플릿 (항목 뷰)
        // 3) TextView의 id
        // 4) Item
        val adapter = ArrayAdapter<String>(this, R.layout.board_list, R.id.tvBoard, data)

        // 5. Container에 Adapter 부착
        lv.adapter = adapter

        // 6. Event 처리

        // 1) btnBoard를 클릭했을 때,
        btnBoard.setOnClickListener {
        // 2) etBoard의 값을 가져와서
        // 3) val input에 저장
            val input: String = etBoard.text.toString()
        // 4) data에 input을 추가!!
            data.add(input)

            // adapter를 새로고침하자!!
            adapter.notifyDataSetChanged()
            etBoard.text = null
        }

        lv.setOnItemClickListener { adapterView, view, i, l ->

            // AlertDialog 옵션 정보를 담는 builder 생성!
            val builder = AlertDialog.Builder(this)
            builder.setTitle("게시글 삭제")
            builder.setMessage("정말 삭제하시겠습니까?")
            builder.setPositiveButton("삭제",
                DialogInterface.OnClickListener{p0, p1 ->
                    data.removeAt(i)
                    adapter.notifyDataSetChanged()
                })

            builder.setNegativeButton("취소", null)

            // 주의
            // builder를 통해 옵션을 단 이후
            // 맨 마지막에는 무조건! show() 함수를 달아야 한다

            builder.show()



        }

        // AdapterView 만드는 법
        // 1. Container 결정 -> ListView의 위치 결정
        // 2. Template 결정 -> 항목 뷰 결정/디자인 !!
        // 3. Item 결정 -> ArrayList<String>
        // 4. Adapter 결정 -> ArrayAdapter
        // 5. Container에 Adapter 부착
        // 6. Event 처리


    }

    // intent 데이터 받아주는 callback 함수 생성
    val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        // it : resultCode, Intent
        // resultCode 상태를 확인 하자 ok, canceled
        if(it.resultCode == RESULT_OK){
            // btnWrite 활성화
            btnWrite.isEnabled = true
            btnBoard.isEnabled = true
            // tvContent에 로그인 성공
            tvContent.text = "로그인 성공"
        }else{
            // tvContent에 로그인 실패
            tvContent.text = "로그인 실패"
        }
    }


}