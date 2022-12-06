package com.example.ex221205

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_do)

        val tvScore = findViewById<TextView>(R.id.tvScore)
        val btnStart  = findViewById<Button>(R.id.btnStart)

        val imgViews = ArrayList<ImageView>()

        for(i in 1 .. 9 ){

            val resId = resources.getIdentifier("imageView$i", "id", packageName)
            val imgView = findViewById<ImageView>(resId)
            imgViews.add(imgView)
            imgView.visibility = View.INVISIBLE

        }

        btnStart.setOnClickListener {

            for(i in 0 until imgViews.size){
                val imgView = imgViews.get(i)
                imgView.visibility = View.VISIBLE

                val thread = DoThread(imgView)
                thread.start()
            }

        }

    } // onCreate() 끝

    val handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val imgView = msg.obj as ImageView
            imgView.setImageResource(R.drawable.on)
        }
    }

    inner class DoThread(val imgView: ImageView) : Thread(){
        override fun run() {
            super.run()

            // 랜덤하기 0 ~ 5초후에 일어나게!!
            val onTime = Random.nextInt(5000)

            Thread.sleep(onTime.toLong())

            val message = Message()
            message.obj = imgView
            handler.sendMessage(message)

        }
    }


}