package com.example.arkanittestapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*
import kotlinx.coroutines.Dispatchers.Main


class RvAdapter(val users: List<DataUsers>, val posts: List<DataPost>, private val activity: MainActivity, val listener: Listener): RecyclerView.Adapter<UsersViewHolder>() {

    interface Listener{
        fun onItemClick(uri: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        return holder.bind(users[position], posts, activity, listener)
    }

}

class UsersViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    private var isExpanded: Boolean = true

    init {
        itemView.run {
            setOnClickListener{
                if (isExpanded) {
                    arrow.animate().setDuration(200).rotation(180f)
                    rv_posts.visibility = View.VISIBLE
                    isExpanded = false
                } else {
                    arrow.animate().setDuration(200).rotation(0f)
                    rv_posts.visibility = View.GONE
                    isExpanded = true
                }
            }
        }


    }

    fun bind(user: DataUsers, responsePost: List<DataPost>, activity: MainActivity, listener: RvAdapter.Listener) = with(itemView) {
        name.text = "Name: "+user.name
        email.text = "E-mail: "+user.email
        rv_posts.adapter = PostsAdapter(responsePost, user.id)

        website.setOnClickListener {
            listener.onItemClick("https://"+user.website)
        }
    }

}