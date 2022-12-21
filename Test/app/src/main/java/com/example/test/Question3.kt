package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Question3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        val rvSong = findViewById<RecyclerView>(R.id.rvSong)

        val songList = ArrayList<Question3SongVO>()

        val s1 = Question3SongVO(R.drawable.newjeans, "Attention", "NewJeans")
        val s2 = Question3SongVO(R.drawable.newjeans, "Hype boy", "NewJeans")
        val s3 = Question3SongVO(R.drawable.newjeans, "Cookie", "NewJeans")
        val s4 = Question3SongVO(R.drawable.newjeans, "Hurt", "NewJeans")
        val s5 = Question3SongVO(R.drawable.lesserafim, "ANTIFRAGILE", "LE SSERAFIM")
        val s6 = Question3SongVO(R.drawable.idle,"Nxde", "(여자)아이들")
        val s7 = Question3SongVO(R.drawable.dream,"고래 (Dive Into You)", "NCT DREAM")
        val s8 = Question3SongVO(R.drawable.newjeans, "Attention", "NewJeans")
        val s9 = Question3SongVO(R.drawable.newjeans, "Hype boy", "NewJeans")
        val s10 = Question3SongVO(R.drawable.newjeans, "Cookie", "NewJeans")

        songList.add(s1)
        songList.add(s2)
        songList.add(s3)
        songList.add(s4)
        songList.add(s5)
        songList.add(s6)
        songList.add(s7)
        songList.add(s8)
        songList.add(s9)
        songList.add(s10)

        val adapter = Question3SongAdapter(this, songList)

        rvSong.adapter =adapter

        rvSong.layoutManager = LinearLayoutManager(this)


    }
}