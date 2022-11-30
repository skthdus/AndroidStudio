package com.example.ex221131

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokeAdapter2(val context: Context, val pokeList: ArrayList<PokeVO>)
    : RecyclerView.Adapter<PokeAdapter2.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imgPoke : ImageView
        val tvPokeLevel : TextView
        val tvPokeName : TextView
        val tvPokeType : TextView

        init {
            imgPoke = itemView.findViewById(R.id.imgPoke)
            tvPokeLevel = itemView.findViewById(R.id.tvPokeLevel)
            tvPokeName = itemView.findViewById(R.id.tvPokeName)
            tvPokeType = itemView.findViewById(R.id.tvPokeType)
        }

    }

    // itemView가 없을 때, ViewHolder 생성!
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.poke_list, null)

        return ViewHolder(view)
    }

    // 만들어진 ViewHolder가 있다면, 꺼내서 쓰는 곳!!
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imgPoke.setImageResource(pokeList.get(position).img)
        holder.tvPokeLevel.setText("Level : " + pokeList.get(position).level)
        holder.tvPokeName.setText(pokeList.get(position).name)
        holder.tvPokeType.setText("타입 : " + pokeList.get(position).type)

    }

    override fun getItemCount(): Int {
        return pokeList.size
    }
}