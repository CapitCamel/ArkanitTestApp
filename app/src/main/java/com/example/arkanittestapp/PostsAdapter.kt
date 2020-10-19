package com.example.arkanittestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_item.view.*

class PostsAdapter(val posts: List<DataPost>, val userID: Int): RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        return holder.bind(posts[position], userID)
    }
}

class PostsViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    fun bind(post: DataPost, usId: Int) = with(itemView) {
        if (post.userId == usId){
            post_title.text = "Title: "+post.title
            post_body.text = "Body: "+post.body
            cardview.visibility = View.VISIBLE
        }
    }

}