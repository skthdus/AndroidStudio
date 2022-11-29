package com.example.ex20221129

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View의 id 값 찾아오기
        tvResult = findViewById<TextView>(R.id.tvResult)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // btnNext를 눌렀을 때
        btnNext.setOnClickListener { 
            // Intent 생성
            val intent = Intent(this@MainActivity, SubActivity::class.java)
            // Intent 실행 (SubActivity 이동 및 요청)
//            startActivityForResult(intent, 1004)
            // requestCode : 결과값을 보내 줘야하는 Activity를 구분하기 위한 코드
            launcher.launch(intent)
            // 실행하려면 Launch() 키워드가 붙어줘야 함 전달인자로 내가 생성한 intent 넣어주기
        }
    } // OnCreate 밖

    // Intent 통해서 받아온 결과값을 처리할 수 있도록 도와주는 함수
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 1) requestCode : (1004) 내가 보낸 요청코드를 받아오는 매개변수
        // 2) resultCode : RESULT_OK 받아온 결과 값의 상태
        // 3) Intent? data : str(문구)가 붙어있는 Intent를 받아오는 매개변수

        // 내가 보냈던 요청이 맞는지 == 요청코드가 1004가 맞나요?
        if(requestCode == 1004){
            // resultCode도 내가 원하는 결과값이 맞는지 (RESULT_OK가 맞는지?)
            if(resultCode== RESULT_OK){
                // 두 가지 다 만족하면 받아온 결과값을 처리하겠습니다
                // tvResult의 text를 받아온 str로 바꾸자
                // 1. str 꺼내기
                val str = data?.getStringExtra("content")
                // 2. TextView 내용을 str로 바꾸기
                tvResult.text = str
            }
        }
    }

    // callback 함수
    // 1. 다른 함수의 인자로 사용되는 함수
    // 2. 어떤 이벤트에 의해 호출되어지는 함수
    // -> 버튼 클릭하면 Intent 실행되면서 호출

    // ActivityResultLauncher 를 사용
    // : 액티비티에서 데이터를 받아오기 위해 사용하는 함수
    // : Fragment(부분화면)에서도 데이터를 주고받을 때 사용할 수 있음
    // 기존에 ActivityForResult는 메모리가 너무 작음 -> 프로세스, 액티비티 소멸될 수 있다
    // 런처는 메모리부족으로 소멸되었다가 재생성해도 결과값을 받아온다

    // Contract자료형, 콜백메서드
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        // 실제로 ActivityResultContracts를 타고 들어가면
        // 1) createIntent ---> StartActivityForResult 대체
        // 2) parseResult ---> onActivityResult 대체 (resultCode랑 Intent만 받아온다)
        // 런처를 사용하게 되면 요청을 보낸 Activity를 구분할 필요가 없다
        // requestCode가 필요없습니다!

        // it에서 resultCode랑 data를 추출
//        Log.d("data",it.toString())
        Log.d("data",it.data.toString())
        Log.d("data",it.resultCode.toString())

        // ResultCode가 RESULT_OK인지 확인
        if(it.resultCode == RESULT_OK){
            tvResult.text = it.data?.getStringExtra("content" )
            // it.data ---> Intent?의 리턴값을 가지고 있다
        }

    }

}