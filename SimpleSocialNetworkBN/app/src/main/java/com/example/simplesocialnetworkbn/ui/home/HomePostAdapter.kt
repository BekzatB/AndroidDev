package com.example.simplesocialnetworkbn.ui.home

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplesocialnetworkbn.R
import com.example.simplesocialnetworkbn.base.OnItemClickListener
import com.example.simplesocialnetworkbn.model.PostData

class HomePostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var postList: ArrayList<PostData> = ArrayList()
    var itemClickListener: OnItemClickListener? = null

    fun addItems(items: ArrayList<PostData>) {
        this.postList.addAll(items)
        reload()
    }

    fun clear() {
        this.postList.clear()
        reload()
    }

    fun changeItem(item: PostData) {
        this.postList.forEach {
            if (it.postId == item.postId) {
                it.postLiked = item.postLiked
                return reload()
            }
        }
    }

    fun getItem(position: Int): PostData? {
        return this.postList.get(position)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    override fun getItemCount(): Int = postList.size

    private fun reload() {
        Handler(Looper.getMainLooper()).post { notifyDataSetChanged() }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_posts, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myHolder = holder as PostViewHolder
        getItem(position)?.let { myHolder.bindView(postData = it) }
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var postLogo = itemView.findViewById<ImageView>(R.id.postLogo)
        private var postImage = itemView.findViewById<ImageView>(R.id.postImage)
        private var postAuthor = itemView.findViewById<TextView>(R.id.postAuthorTextView)
        private var postLike = itemView.findViewById<TextView>(R.id.postLikeTextView)
        private var postDescription = itemView.findViewById<TextView>(R.id.postDescriptionTextView)
        private var postComments = itemView.findViewById<TextView>(R.id.postCommentsTextView)
        private var postTime = itemView.findViewById<TextView>(R.id.postTimeTextView)
        private var postLikeButton = itemView.findViewById<ImageButton>(R.id.postLikeImageButton)

        init {
            itemView.setOnClickListener(this)
            postLikeButton.setOnClickListener(this)
        }

        fun bindView(postData: PostData) {
            postLogo.setImageResource(postData.postLogo)
            postImage.setImageResource(postData.postImage)
            postAuthor.text = postData.postAuthor
            postLike.text = "Нравиться: " + postData.postLike.toString()
            postDescription.text = postAuthor.text as String + " " + postData.postDescription
            postComments.text = postData.postComments
            postTime.text = postData.postTime

            if (postData.postLiked!!) {
                postLikeButton.setBackgroundResource(R.drawable.pressed_heart_button)
            } else {
                postLikeButton.setBackgroundResource(R.drawable.heart)
            }
        }

        override fun onClick(v: View?) {
            if (v != null) {
                if (v.id == postLikeButton.id) {
                    itemClickListener?.onHeartClick(adapterPosition, v)
                } else {
                    itemClickListener?.onItemClick(adapterPosition, v)
                }
            }
        }
    }
}