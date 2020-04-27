package com.example.simplesocialnetwork.ui

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simplesocialnetwork.R
import com.example.simplesocialnetwork.model.PostData
import com.example.simplesocialnetwork.model.PostList
import kotlin.properties.Delegates

class DetailsActivity : AppCompatActivity() {
    private lateinit var postLogo: ImageView
    private lateinit var postImage: ImageView
    private lateinit var postAuthor: TextView
    private lateinit var postDescription: TextView
    private lateinit var postLike: TextView
    private lateinit var postComments: TextView
    private lateinit var postTime: TextView
    private lateinit var backButton: ImageButton
    private var postId by Delegates.notNull<Int>()
    private val postList = PostList.postList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postId = intent.getIntExtra("post_id", 1)
        bindView()
        setData()
    }

    private fun bindView() {
        postLogo = findViewById(R.id.postLogo)
        postImage = findViewById(R.id.postImage)
        postAuthor = findViewById(R.id.postAuthorTextView)
        postDescription = findViewById(R.id.postDescriptionTextView)
        postLike = findViewById(R.id.postLikeTextView)
        postComments = findViewById(R.id.postCommentsTextView)
        postTime = findViewById(R.id.postTimeTextView)
        backButton = findViewById(R.id.backImageButton)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setData() {
        postList.forEach {
            if (it.postId == postId) {
                setView(it)
            }
        }
    }

    private fun setView(postData: PostData) {
        postLogo.setImageResource(postData.postLogo)
        postImage.setImageResource(postData.postImage)
        postAuthor.text = postData.postAuthor
        postLike.text = "Нравиться: " + postData.postLike.toString()
        postDescription.text = postAuthor.text as String + " " + postData.postDescription
        postComments.text = postData.postComments
        postTime.text = postData.postTime
    }
}