package com.example.arkanittestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.*

class RvAdapter(val users: List<DataUsers>, val posts: List<DataPost>): RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        return holder.bind(users[position], posts)
    }

}

class UsersViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    private val name: TextView = itemView.findViewById(R.id.name)
    private val email:TextView = itemView.findViewById(R.id.email)
    private val arrow: ImageView = itemView.findViewById(R.id.arrow)
    private val recyclerPost: RecyclerView = itemView.findViewById(R.id.rv_posts)
    private var isExpanded: Boolean = true


    fun bind(user: DataUsers, responsePost: List<DataPost>) {
        name.text = "Name: "+user.name
        email.text = "E-mail: "+user.email

        recyclerPost.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = PostsAdapter(responsePost, user.id)
        }

        itemView.setOnClickListener {
            if (isExpanded) {
                arrow.animate().setDuration(200).rotation(180f)
                recyclerPost.visibility = View.VISIBLE
                isExpanded = false
            } else {
                arrow.animate().setDuration(200).rotation(0f)
                recyclerPost.visibility = View.GONE
                isExpanded = true
            }
        }

    }

}