package com.example.fullstackapplication.tip

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.fullstackapplication.R
import java.util.zip.Inflater

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // 받아온 Url값을 꺼내서
        // 해당 웹페이지가 WebView에 뜨게 만들자
        // Fragment 1202


        val wv = findViewById<WebView>(R.id.wv)
        // String? 타입으로 받아 옴
        val address = intent.getStringExtra("url")

        // WebView에 원하는 웹 페이지 띄우기
        // 1. 주소준비

        // 2. 설정변경 ( JavaScript 지원 )
        val ws = wv.settings
        ws.javaScriptEnabled = true

        // 3. webView에 Client 설정!
        wv.webViewClient = WebViewClient()

        // 4. 주소 적용
        // intent로 부터 값을 무조건 받아오는 이유
        // 값이 없으면 RecyclerView에서 안 보임 (실행이 안됨)
        wv.loadUrl(address!!)
    }
}