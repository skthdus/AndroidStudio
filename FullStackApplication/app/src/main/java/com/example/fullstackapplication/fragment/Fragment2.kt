package com.example.fullstackapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.fullstackapplication.R
import com.example.fullstackapplication.tip.ListActivity


class Fragment2 : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_2, container, false)

        val imgAll = view.findViewById<ImageView>(R.id.imgAll)
        val imgCook = view.findViewById<ImageView>(R.id.imgCook)
        val imgLife = view.findViewById<ImageView>(R.id.imgLife)

        imgAll.setOnClickListener {
            // ListActivity로 넘어가자
            val intent = Intent(view.context, ListActivity::class.java)
            intent.putExtra("cate", "all")
            // 클릭한 imgView에 달려있는 tag 내용을 가지고 이동
            intent.putExtra("category", imgAll.tag.toString())
            startActivity(intent)
        }

        imgCook.setOnClickListener{
            val intent = Intent(view.context, ListActivity::class.java)
            intent.putExtra("cate", "cook")
            intent.putExtra("category", imgCook.tag.toString())
            startActivity(intent)
        }
        imgLife.setOnClickListener{
            val intent = Intent(view.context, ListActivity::class.java)
            intent.putExtra("cate", "life")
            intent.putExtra("category", imgLife.tag.toString())
            startActivity(intent)
        }

        return view
    }
           }


