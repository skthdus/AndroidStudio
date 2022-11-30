package com.example.ex20221130

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var phoneList = ArrayList<PhoneVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = findViewById<ListView>(R.id.lv)

        // 1. 화면에서 ListView의 위치 정해주기 (xml 파일)

        // 2. ListView 한 칸에 들어갈 디자인 정해주기 (xml 파일)

        // 3. ListView에 들어갈 데이터 만들기 -> 하나의 자료형 (PhoneVO)
        // 이미지뷰에 들어갈 Image의 ID값 (Int)
        // 이름, 전화번호 (String)
        val p1 = PhoneVO(R.drawable.img1, "채수민", "010-1234-5678")
        val p2 = PhoneVO(R.drawable.img2,"김동원","010-2345-6789")
        val p3 = PhoneVO(R.drawable.img3, "강예진", "010-3456-7890")
        val p4 = PhoneVO(R.drawable.img4,"선영표","010-4567-8901")
        val p5 = PhoneVO(R.drawable.img5,"조자연","010-5678-9012")

        phoneList.add(p1)
        //phoneList.add(PhoneVO(R.drawable.img1, "채수민", "010-1234-5678"))
        phoneList.add(p2)
        phoneList.add(p3)
        phoneList.add(p4)
        phoneList.add(p5)

        // 4. Adapter 만들기
        // 데이터의 자료형이 내가 만든 자료형 (vo)이기 때문에
        // 안드로이드에서 기본적으로 제공하는 ArrayAdapter는 사용이 불가능
        // Adapter : 데이터랑 템플릿을 합쳐서 ListView에 적재시켜주는 역할
        val adapter = PhoneAdapter(applicationContext, R.layout.phone_list, phoneList)

        // 5. ListView에 Adapter 적용
        lv.adapter = adapter

        // 6. 이벤트 달아주기




    }
}