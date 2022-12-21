package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.EditText

class Question4 : AppCompatActivity() {

    lateinit var etTime : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)

        etTime = findViewById(R.id.etTime)
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            val thread = TimerThread(etTime)
            thread.start()
        }
    }

    val handler = object : Handler(Looper.getMainLooper()){

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            val time = msg.arg1
            val et = msg.obj as EditText
            et.setText(time.toString())
        }
    }
    inner class TimerThread(val et:EditText) : Thread(){
        override fun run() {
            super.run()
            val time = et.text.toString().toInt()
            for(i in time downTo 0){
                val message= Message()

                message.arg1 = i
                message.obj = et

                handler.sendMessage(message)
                Thread.sleep(1000)
            }
        }
    }

}