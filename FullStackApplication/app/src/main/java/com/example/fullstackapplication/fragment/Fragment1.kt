package com.example.fullstackapplication.fragment

import com.example.fullstackapplication.ContactVO

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fullstackapplication.R
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val tvMsg = view.findViewById<TextView>(R.id.tvMsg)
        val clHome = view.findViewById<ConstraintLayout>(R.id.clHome)

        val etName = view.findViewById<EditText>(R.id.etContactName)
        val btnSend = view.findViewById<Button>(R.id.btnSend)

        val etContactName = view.findViewById<EditText>(R.id.etContactName)
        val etContactAge = view.findViewById<EditText>(R.id.etContactAge)
        val etContactTel = view.findViewById<EditText>(R.id.etContactTel)
        val btnContact = view.findViewById<Button>(R.id.btnContact)


        val yehoUrl = "https://android-project-yeho-default-rtdb.firebaseio.com/"
        val yehoDb = Firebase.database(yehoUrl)
        val nsy = yehoDb.getReference("나소연")

        btnSend.setOnClickListener {
            val input = etName.text.toString()
            nsy.setValue(input)
        }


        // firebase에서 데이터를 실시간으로 읽고/ 쓸 수 있는
        // RealTime DataBase
        // NoSQL
        // - Key : Value

        // Write a message to the database
        val database = Firebase.database

        val contact = database.getReference("contact2")

        btnContact.setOnClickListener {
            val name = etContactName.text.toString()
            val age = etContactAge.text.toString().toInt()
            val tel = etContactTel.text.toString()

            contact.push().setValue(ContactVO(name, age, tel))

        }

        val myRef = database.getReference("message")

        val color = database.getReference("color")

        color.addValueEventListener(object  : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val bgColor = snapshot.getValue<String>()

                if(bgColor != null){
                    try {
                        clHome.setBackgroundColor(Color.parseColor(bgColor))
                    } catch (e : IllegalArgumentException){
                        clHome.setBackgroundColor(Color.parseColor("yellow"))
                    } catch (e : StringIndexOutOfBoundsException){
                        clHome.setBackgroundColor(Color.parseColor("red"))
                    }
                }else{
                    clHome.setBackgroundColor(Color.parseColor("white"))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        myRef.setValue("Hello, World!")

        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val message = snapshot.getValue<String>()
                tvMsg.setText(message)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        contact.addChildEventListener(object : ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val webContact = snapshot.getValue<ContactVO>()
                Log.d("연락처", webContact.toString())
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


        return view
    }


}