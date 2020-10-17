package com.example.arkanittestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(val users: List<DataUsers>): RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        return holder.bind(users[position])
    }

}

class UsersViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    private val name: TextView = itemView.findViewById(R.id.name)
    private val email:TextView = itemView.findViewById(R.id.email)

    fun bind(user: DataUsers) {
        name.text = "Name: "+user.name
        email.text = "E-mail: "+user.email

    }

}