package com.example.a20221124

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// : Kotlin에서 상속
class ConstraintActivity : AppCompatActivity() {

    // 전역변수(뷰)로 만들기
        lateinit var tvResult: TextView
        // 뷰에 대해서는 선언만 하는 것은 불가능! 초기화가 꼭 이루어져야 한다
        // 그런데 lateinit 이라는 키워드로 나중에 꼭 초기화를 하곘다
        // 라는 약속을 할 수 있다!
        lateinit var etNum1: EditText
        lateinit var etNum2: EditText



    // OnCreate() 는 Activity가 실행될 때 최초 딱 한번(가장 먼저) 호출되는 메서드
    // : Activity 생명주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ***** xml 이랑 KtClass랑 연결하는 코드 없으면 화면 안 뜸 *****
        setContentView(R.layout.activity_constraint)

        // 1. xml의 View에 id를 지정
        // 2. id값을 이용해서 view를 찾아온다 (findViewById)
//        tvResult = findViewById<TextView>(R.id.tvResult)
        tvResult = findViewById(R.id.tvResult)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        //  btnMul, btnDiv, etNum1, etNum2
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)

        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)

        // id값은 문자열로 정해줬는데 받아오는 값이 Int
        // R 폴더에 모든 뷰(리소스)들의 id값이 저장되는데 주소값이 저장
        // 16진수 상수형태로 저장이 되어있다(Int)

        // ** setContentView 위로 find할 수 없다! **
        tvResult.setTextColor(Color.BLUE)
        tvResult.setTextColor((Color.parseColor("#ff9999")))

        //textSize에는 Float 자료형이 들어가야 한다! (f: 형변환)
        tvResult.textSize = 40.0f
        tvResult.text = "안녕하세요!"
        // charSequence 인터페이스 - String은 CharSequence 인터페이스 상속받는 중

        // - 더하기 버튼을 눌렀을 때  "더하기 버튼이 눌렸습니다"라는
        // Toast 를 띄워 주자!
        // 이벤트를 주는 방법
        // 1) 이벤트 메소드 설계 후 뷰에 연결하기
        // 2) innerClass (Listener onClick 구현)
        btnMinus.setOnClickListener {
            // {}안에다가 기능 구현만 하면 됨!
            // 버튼을 눌렀을 때 "마이너스 버튼이 눌렸습니다" 토스트 띄우기
            Toast.makeText(this,"빼기 버튼이 눌렸습니다", Toast.LENGTH_LONG).show()


            // findViewById 하고 나서~

            // 1. EditText에 적혀있는 내용 가져오기
            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()
            // etNum1, etNum2 에 있는 내용  변수 num1, num2에 저장
            // 실제로 getText --> Editable ---> 문자열로 형변환 ---> 정수형
            // 2. num1, num2 연산 결과를 tvResult에 set 해주세요!
            // : num1, num2 연산결과를 문자열로 바꿔서 set 해주세요
//            var minus = num1-num2
//            tvResult.setText("연산 결과 : $minus")
            tvResult.text = ("연산결과 : ${num1-num2}")
        }


        btnMul.setOnClickListener {
            Toast.makeText(this, "곱하기 버튼을 눌렀습니다",Toast.LENGTH_SHORT).show()

            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()

            var mul = num1*num2
            tvResult.setText("연산 결과 : $mul")


        }

        btnDiv.setOnClickListener {
            Toast.makeText(this, "나누기 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show()

            var num1 = etNum1.text.toString().toInt()
            var num2 = etNum2.text.toString().toInt()

            var div = num1/num2
            tvResult.setText("연산 결과 : $div")
        }

        // 3) interface를 상속받게 만들어서 OnClick 구현

    } // oncreate 밖

    // 이벤트 리스너는 무조건 View 매개변수를 가지고 있어야 한다.
    fun myClick(view: View){
        // Toast 띄우기
        // 1) this , ConstraintActivity.this : Toast를 띄울 화면 정보
        // 2) 문구 (무조건 String, Int가 허용되는 경우는 id값 만)
        // 3) Toast에 Short(3초), Long(5초) 속성 사용 : 지속시간
        Toast.makeText(this,"더하기 버튼이 눌렸습니다",Toast.LENGTH_SHORT).show()

        var num1 = etNum1.text.toString().toInt()
        // Emulator를 처음 실행시키면 EditText에는 아무 값도 없음
        // **.toInt() NUmberFormatException
        // 버튼을 눌렀을 때 적혀있는 값을 가지고 와줘야 함!!
        var num2 = etNum2.text.toString().toInt()
        var result = num1 + num2
        tvResult.text = "연산 결과 : $result"
    }

}