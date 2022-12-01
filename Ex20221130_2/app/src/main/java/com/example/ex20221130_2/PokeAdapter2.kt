package com.example.ex20221130_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PokeAdapter2 (val context: Context, val pokeList: ArrayList<PokeVO>)
    : RecyclerView.Adapter<PokeAdapter2.ViewHolder>(){

    // Java에서는 OnClickEvent를 구현한다!! (Interface 형태로)

    // inner class 명시를 해야
    // outer class의 member에 접근할 수 있다
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imgPoke : ImageButton
        val tvPokeLevel : TextView
        val tvPokeName : TextView
        val tvPokeType : TextView

        init {
            imgPoke = itemView.findViewById(R.id.imgPoke)
            tvPokeLevel = itemView.findViewById(R.id.tvPokeLevel)
            tvPokeName = itemView.findViewById(R.id.tvPokeName)
            tvPokeType = itemView.findViewById(R.id.tvPokeType)

            // 1. ListView의 setOnItemClickListener
            itemView.setOnClickListener {
                // 해당 아이템의 position 정보가 필요함!! -> adapterPosition
                val position: Int = adapterPosition
                pokeList.removeAt(position)
                notifyDataSetChanged()
            }

            imgPoke.setOnClickListener{
                // 피카츄 -> 피카츄입니다!!
                val position: Int = adapterPosition
                // "Lv : 1 / 피카츄 / 타입 : 전기 "
                val level: String = pokeList.get(position).level
                val name: String = pokeList.get(position).name
                val type: String = pokeList.get(position).type

                val result : String = "Lv : $level / $name / 타입 : $type"



//                Toast.makeText(context, pokeList.get(position).name + "입니다.",Toast.LENGTH_LONG).show()
                Toast.makeText(context, result, Toast.LENGTH_LONG).show()
            }


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