package com.example.ex20221130_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        // 1. Container 설정
        val rvColor = findViewById<RecyclerView>(R.id.rvColor)

        // 2. Template 설정
        // color_list.xml

        // 3. Item 설정
        val colorList = ArrayList<ColorVO>()
        var color: String

        // "#" + red(16) + green(16) + blue(16)
        for(i in 0..255 step 20){
            var red:String = Integer.toHexString(i) //>16진수 인 값으로 변환

            for(j in 0..255 step 20){
                var green:String = Integer.toHexString(j)

                for(k in 0..255 step 20){
                    var blue:String = Integer.toHexString(k)

                    if(red.length == 1){red = "0"+ red}
                    if(green.length == 1){green = "0"+ green}
                    if(blue.length == 1){blue = "0"+ blue}

                    color = "#$red$green$blue"
                    colorList.add(ColorVO(color))
                }
            }
        }

//        colorList.add(ColorVO("#FF0000"))
//        colorList.add(ColorVO("#00FF00"))
//        colorList.add(ColorVO("#0000FF"))
//        colorList.add(ColorVO("#FFFFFF"))
//        colorList.add(ColorVO("#000000"))

        // 4. Adapter 설정
        val adapter = ColorAdapter(this, colorList)

        // 5. Container 에 Adapter 부착
        rvColor.adapter = adapter
//        rvColor.layoutManager = GridLayoutManager(this, 10)
//        rvColor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        rvColor.layoutManager = GridLayoutManager(this,30)

        rvColor.layoutManager = GridLayoutManager(this,40)
    }
}