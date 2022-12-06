package com.example.ex221205

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class DoActivity : AppCompatActivity() {

    var isPlaying : Boolean = true

    var score : Int = 0 // 점수를 저장하는 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_do)

        val tvScore = findViewById<TextView>(R.id.tvScore)
        val btnStart  = findViewById<Button>(R.id.btnStart)
        val tvTime = findViewById<TextView>(R.id.tvTime)

        val imgViews = ArrayList<ImageView>()

        for(i in 1 .. 9 ){

            val resId = resources.getIdentifier("imageView$i", "id", packageName)
            val imgView = findViewById<ImageView>(resId)
            imgViews.add(imgView)
            imgView.visibility = View.INVISIBLE

        }


        btnStart.setOnClickListener {

            val thread2 = TimeThread(tvTime)
            thread2.start()

            for(i in 0 until imgViews.size){
                val imgView = imgViews.get(i)
                imgView.visibility = View.VISIBLE
                // 각 이미지뷰의 tag는 최초 0이다
                // 여기서 0은 두더지가 앉아 있음을 의미한다!!
                imgView.tag = 0

                val thread = DoThread(imgView)
                thread.start()

                imgView.setOnClickListener {
                    if(imgView.tag == 1){
                        score++
                    }else{
                        score--
                        if(score<0){
                            score = 0
                        }
                    }
                    tvScore.setText("현재 점수 : $score")
                }
            }

        }

    } // onCreate() 끝

    val handler2 = object : Handler(Looper.getMainLooper()){
        // Ctrl+ O : handleMessage
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val time = msg.arg1
            val tv = msg.obj as TextView
            tv.setText(time.toString())

        }
    }

    inner class TimeThread(val tv: TextView) : Thread() {
        // Ctrl O : run()
        override fun run() {
            super.run()

            for(i in 30 downTo 0){

                val message = Message()
                message.arg1 = i
                message.obj = tv

                handler2.sendMessage(message)

                Thread.sleep(1000)

            }
            isPlaying = false
//            val intent = Intent(this@DoActivity, MainActivity::class.java)
//            startActivity(intent)
        }
    }

    val handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val imgView = msg.obj as ImageView // 어떤 이미지뷰에 적용될 건지??
            val img = msg.arg1 // on이미지인지 off이미지인지 (이미지 정보를 담고 있는 리소스)
            val tag = msg.arg2 // 현재 이미지의 상태!! 1이라면 일어나있음, 0이라면 앉아 있음
            imgView.setImageResource(img)
            imgView.tag = tag
        }
    }

    inner class DoThread(val imgView: ImageView) : Thread(){
        override fun run() {
            super.run()


            while (isPlaying){

                var level = score * 20
                if(score >= 40){
                    level = 800
                }

                // 랜덤하기 0 ~ 5초후에 일어나게!!
                val onTime = Random.nextInt(5 * (1000-level))

                Thread.sleep(onTime.toLong())

                val message = Message()
                message.arg1 = R.drawable.on
                message.arg2 = 1 // 두더지가 일어남을 의미!!
                message.obj = imgView

                handler.sendMessage(message)

                // 랜덤하기 0 ~ 5초후에 일어나게!!
                val offTime = Random.nextInt(3 * (1000-level))

                Thread.sleep(offTime.toLong())

                val message2 = Message()
                message2.arg1 = R.drawable.off
                message2.arg2 = 0 // 두더지가 앉아있음을 의미
                message2.obj = imgView

                handler.sendMessage(message2)

            }
        }
    }


}