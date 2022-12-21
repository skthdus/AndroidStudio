package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Question3SongAdapter(val context: Context, val songList :ArrayList<Question3SongVO>) : RecyclerView.Adapter<Question3SongAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgCover : ImageView
        val tvTitle : TextView
        val tvSinger : TextView


        init {
            imgCover = itemView.findViewById(R.id.imgCover)
            tvTitle = itemView.findViewById(R.id.tvTitle)
            tvSinger = itemView.findViewById(R.id.tvSinger)

            var imgHeart = itemView.findViewById<ImageView>(R.id.imgHeart)
            var Heart = imgHeart.tag.toString()

            imgHeart.setOnClickListener {
                if (Heart.equals(false)){
                    imgHeart.setImageResource(R.drawable.heart)
                    imgHeart.setTag("true")
                } else {
                    imgHeart.setImageResource(R.drawable.colorheart)
                    imgHeart.setTag("false")
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.song_list, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgCover.setImageResource(songList.get(position).img)
        holder.tvTitle.setText(songList.get(position).title)
        holder.tvSinger.setText(songList.get(position).singer)
    }

    override fun getItemCount(): Int {
        return songList.size
    }


}