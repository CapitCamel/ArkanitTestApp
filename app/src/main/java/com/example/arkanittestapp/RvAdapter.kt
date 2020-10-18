package com.example.arkanittestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
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
    private val arrow: ImageButton = itemView.findViewById(R.id.arrow)
    private var isExpanded: Boolean = true

    fun bind(user: DataUsers) {
        name.text = "Name: "+user.name
        email.text = "E-mail: "+user.email

        itemView.setOnClickListener {
            if (isExpanded) {
                arrow.animate().setDuration(200).rotation(180f)
                isExpanded = false
            } else {
                arrow.animate().setDuration(200).rotation(0f)
                isExpanded = true
            }
        }

    }

}