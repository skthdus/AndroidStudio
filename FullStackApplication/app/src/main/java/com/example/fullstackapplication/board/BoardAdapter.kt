package com.example.fullstackapplication.board

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fullstackapplication.R

// Fragment3 에 있는 boardRV에 적용될 Adapter
class BoardAdapter(var context: Context, var boardList : ArrayList<BoardVO>)
    : RecyclerView.Adapter<BoardAdapter.ViewHolder>(){



    // 리스너 커스텀
    interface OnItemClickListener{
        fun onItemClick(view : View, position: Int){

        }
    }

    // 객체 저장 변수 선언
    lateinit var mOnItemClickListener : OnItemClickListener

    // 객체 전달 메서드
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        mOnItemClickListener = onItemClickListener
    }


        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            val tvRvTitle : TextView
            val tvRvContent : TextView
            val tvRvTime : TextView

            init {
                tvRvTitle = itemView.findViewById(R.id.tvRvTitle)
                tvRvContent = itemView.findViewById(R.id.tvRvContent)
                tvRvTime = itemView.findViewById(R.id.tvRvTime)

                itemView.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        mOnItemClickListener.onItemClick(itemView, position)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.board_template, null)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvRvTitle.setText(boardList[position].title)
        holder.tvRvContent.text = boardList[position].content
        holder.tvRvTime.text = boardList[position].time

    }

    override fun getItemCount(): Int {
        return boardList.size
    }
}