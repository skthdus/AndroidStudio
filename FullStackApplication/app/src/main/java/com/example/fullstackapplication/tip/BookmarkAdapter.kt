package com.example.fullstackapplication.tip

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fullstackapplication.R
import java.util.zip.Inflater

class BookmarkAdapter(
    var context: Context,
    var data: ArrayList<ListVO>,
    var keyData: ArrayList<String>,
    var bookmarkList: ArrayList<String>)
    : RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgContent : ImageView
        val tvTitle : TextView
        val imgBookmark : ImageView
        init {
            imgContent = itemView.findViewById(R.id.imgContent)
            tvTitle = itemView.findViewById(R.id.tvTitle)
            imgBookmark = itemView.findViewById(R.id.imgBookmark)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // list_template.xml을 눈에 보이는 View객체로 바꾼다
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.list_template, null)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 북마크 데이터에 포함되어있는지를 판단해서
        // view + data 합쳐주는 작업을 진행
//        if (bookmarkList.contains(keyData[position])){
            holder.tvTitle.text = data[position].title
            Glide.with(context)
                .load(data[position].imgId)
                .into(holder.imgContent)
            // Glide : 웹에 있는 이미지를 가져와서 세팅
            // imgId => 이미지 주소값
//        }
//        if(bookmarkList.contains(keyData[position])){
            holder.imgBookmark.setImageResource(R.drawable.bookmark_color)
//        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}