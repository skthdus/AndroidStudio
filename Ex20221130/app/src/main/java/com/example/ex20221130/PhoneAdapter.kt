package com.example.ex20221130

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PhoneAdapter(val context: Context, val layout: Int, val data: ArrayList<PhoneVO> ) : BaseAdapter() {

    // 프로퍼티 : 필드
    // 멤버 : 메서드

    // Activity의 힘(Context)을 빌려서 Inflate를 할 수 있는 Inflater를 가져오자
    var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
    // getSystemService는 하드웨어(핸드폰)에 담겨있는 센서들이나, Inflater를
    // 추출할 수 있는 메서드
    // 많은 센서들이 담겨있고 각각의 리턴값을 설정해주기 힘듬
    // Any 타입으로 리턴하고 있는데 내가 Inflater를 빼면 Inflater로 형변환


    override fun getCount(): Int {
        // ListView의 항목의 개수 > 몇 칸인지?
        return data.size
    }

    override fun getItem(p0: Int): Any {
        // p0 : position
        // position에 위치한 data를 반환
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        // position 번쨰 id값을 반환
        return p0.toLong()
    }

    // ☆☆☆☆☆
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // 데이터 + 템플릿을 합친 뷰를 return 해주자

        // findViewById, setContentView : Activity만 할 수 있는 일
        // 여기는 Class 위에 뷰를 찾아오는 메서드 사용이 불가능
        // Activity의 힘을 빌릴 수 있다 ----> inflate
        // Inflate : 코드로 있는 xml 파일을 눈에 보이는 뷰로 바꿔주는 작업
        // inflater는 Inflate를 할 수 있는 친구

        var view = p1
        // p1 : value 라서 아래에서 다른 값을 넣을 수 없음
        
        // p0 : 항목의 번호 (position)
        // p1 : 이전에 만들어진 View (xml을 눈에 보이는 형태로 바꾼거)
        // p2 : 모든 뷰(항목)을 담고있는 ListView

        if(view == null){
            view = inflater?.inflate(layout, p2, false)
        }
        // 코드로 존재하는 layout을 눈에 보이는 View 객체로 바꿔주자

        // layout, 누가 이 템플릿을 포함할껀지, false
        val tvName = view?.findViewById<TextView>(R.id.tvName)
        val tvTel = view?.findViewById<TextView>(R.id.tvTel)
        val img = view?.findViewById<ImageView>(R.id.img)
        val btnCall = view?.findViewById<Button>(R.id.btnCall)

        // ArrayList ---> data ---> (id, name, tel)
        tvName?.text = data[p0].name
        tvTel?.text = data[p0].tel
        img?.setImageResource(data[p0].imgId)
        btnCall?.setOnClickListener {
            // 전화번호를 가져와서 ACTION_DIAL이 실행되게 만들자
            // 액션, 데이터(URi tel:)
            var tel =Uri.parse("tel:${tvTel?.text.toString()}")
            val intent = Intent(Intent.ACTION_DIAL, tel)

            // 새로운 Task(Stack 통)을 만들어서 실행
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            // Activity의 힘을 빌려서 Start할 예정
            // Activity의 힘 : context
            context.startActivity(intent)

        }

        // inflate가 된 view를 리턴 ( 데이터 + 템플릿 )
        return view!!

    }


}