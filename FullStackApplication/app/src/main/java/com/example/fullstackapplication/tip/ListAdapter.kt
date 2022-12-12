package com.example.fullstackapplication.tip

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fullstackapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ListAdapter (val context: Context, val itemList: ArrayList<ListVO>,
                   var keyData : ArrayList<String>, var bookmarkList : ArrayList<String>)
    : RecyclerView.Adapter<ListAdapter.ViewHolder>(){

    val database = Firebase.database
    val auth : FirebaseAuth = Firebase.auth

    // BaseAdapter ---> 일반 ListView
    // RecyclerView ---> RecyclerViewAdapter 상속

    inner class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        val imgId : ImageView
        val tvTitle : TextView
        val imgBookmark : ImageView

        init {
            imgId = itemView.findViewById(R.id.imgContent)
            tvTitle = itemView.findViewById(R.id.tvTitle)
            imgBookmark = itemView.findViewById(R.id.imgBookmark)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate : xml코드를 눈에 보이는 View 객체로 바꿔서 ViewHolder로 보내주는 역할
        val layoutInflater = LayoutInflater.from(context)
        // getSystemService <--- 하드웨어가 가지고 있는 많은 센서 서비스들이 담겨있음
        val view = layoutInflater.inflate(R.layout.list_template, null)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.imgId.setImageResource(itemList.get(position).imgId)
        holder.tvTitle.setText(itemList.get(position).title)
        Glide.with(context).load(itemList[position].imgId).into(holder.imgId)



        // imgView를 클릭했을 때
        // url값을 가지고 WebViewActivity로 이동
        holder.imgId.setOnClickListener {

            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", itemList[position].url)

            context.startActivity(intent)

        }

        // 클릭했을 때 색깔을 바꾸면 기존에 있던 북마크는 색이 안 칠해져 있음
        // adapter가 실행이 되는 순간 북마크로 있던 데이터들은 바로 색칠될 수 있게
        if (bookmarkList.contains(keyData[position])){
            holder.imgBookmark.setImageResource(R.drawable.bookmark_color)
        }else{
            holder.imgBookmark.setImageResource(R.drawable.bookmark_white)
        }


        // 북마크 모양의 이미지를 클릭했을 때
        // 해당 게시물의 uid 값이 bookmarkList 경로로 들어가야 함
        holder.imgBookmark.setOnClickListener {

            // Firebase에 있는 bookmarkList 경로로 접근
            val bookmarkRef = database.getReference("bookmarkList")
            bookmarkRef.child(auth.currentUser!!.uid).child(keyData[position]).setValue("good")

            // 이미 저장이 되어있는 게시물인지 아닌지
            // bookmarkList 에 해당 게시물이 포함되어 있는지
            if (bookmarkList.contains(keyData[position])){
                // 북마크를 취소
                // database에서 해당 keyData를 삭제
                bookmarkRef.child(auth.currentUser!!.uid).child(keyData[position]).removeValue()
                // imgBookmark 를 하얗게 만들자
                holder.imgBookmark.setImageResource(R.drawable.bookmark_white)

            } else{
                // 북마크를 추가
                // database에 해당 keyData를 추가
                bookmarkRef.child(auth.currentUser!!.uid).child(keyData[position]).setValue("good")
                // imgBookmark 를 까맣게 만들지
                // holder.imgBookmark.setImageResource(R.drawable.bookmark_color)
            }

        }



    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}