package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class ToDoAdapter(
//list of todo items of type ToDO dataclass as argument to primary constructor
    private val todos: MutableList<ToDo>
    //extends adapter and takes a type of OUR viewholder
):RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){
    fun addtoDo(todo: ToDo){
        todos.add(todo)
       notifyItemInserted(todos.size-1)
//communicate with recyclerview that an item has been added and the exact position to add

    }
    fun deleteCheckedTodos(){
        todos.removeAll {
            toDo -> (toDo.isChecked)
        }
        notifyDataSetChanged()

    }


//view holder primary constructor taking argument of View which is the todoItem layout
class ToDoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val titleTodo = itemView.findViewById<TextView>(R.id.etToDo)
    val cbOne  = itemView.findViewById<CheckBox>(R.id.cbOne)

    fun toggleStrikeThrough(title: TextView,isChecked: Boolean){
        if(isChecked){
            title.paintFlags= title.paintFlags or STRIKE_THRU_TEXT_FLAG
        }
        else
        {
            title.paintFlags = title.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }


    }

}



// unction to strike text that has been checked

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        //using Layoutinflater to inflate xml file to a view

        return ToDoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.todo_item,parent,false)

        )

    }
//function that connects data on the recycler view to the list of todos
//binds data from list to recyclerview items as list is  recycled
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {

        val onItem = todos[position]
        holder.titleTodo.text = onItem.Title
        holder.cbOne.isChecked =onItem.isChecked
    //checks initially to see if item on list has been checked
       holder.toggleStrikeThrough(holder.titleTodo, onItem.isChecked)
    //listener on checkbox to add strikethrough
        holder.cbOne.setOnCheckedChangeListener {_, isChecked ->
            holder.toggleStrikeThrough(holder.titleTodo,isChecked)
        onItem.isChecked = !onItem.isChecked
        }

    }

    override fun getItemCount(): Int {
        return todos.size

    }
}