package com.example.arkanittestapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

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
    private val title: TextView = itemView.findViewById(R.id.post_title)
    private val body: TextView = itemView.findViewById(R.id.post_body)
    private val cardView: CardView = itemView.findViewById(R.id.cardview)

    fun bind(post: DataPost, usId: Int) {
        if (post.userId == usId){
            title.text = "Title: "+post.title
            body.text = "Body: "+post.body
            cardView.visibility = View.VISIBLE
        }
    }

}