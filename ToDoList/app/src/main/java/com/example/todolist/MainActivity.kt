package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.EditText

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //lateinit var allows member variables to be assigned values later in code
    lateinit var  tdAdapter :ToDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rv = findViewById<RecyclerView>(R.id.rv)
        var editToDo= findViewById<EditText>(R.id.editToDo)
        var addBtn= findViewById<Button>(R.id.add_btn)
        var delBtn= findViewById<Button>(R.id.delete_btn)

      

        //assigning recyclerview from layout to variable
        //recyclerview will hold items in the to do list
//using 0dp in xml allows views to take all available space whether height or width


        tdAdapter =ToDoAdapter(mutableListOf())
        rv.adapter = tdAdapter
        //sets the type of list to be used in the recycler view
        rv.layoutManager= LinearLayoutManager(this)
        addBtn.setOnClickListener {
           val title = editToDo.text.toString()
            if(title.isNotEmpty()){
                val todo =ToDo(title)
                tdAdapter.addtoDo(todo)
                editToDo.text.clear()
            }
        }

        delBtn.setOnClickListener {

            tdAdapter.deleteCheckedTodos()
        }
    }


}