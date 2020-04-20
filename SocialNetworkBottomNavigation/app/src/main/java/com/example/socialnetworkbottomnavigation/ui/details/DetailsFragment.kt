package com.example.socialnetworkbottomnavigation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.socialnetworkbottomnavigation.R
import com.example.socialnetworkbottomnavigation.model.PostData
import com.example.socialnetworkbottomnavigation.ui.home.PostViewModel
import kotlin.properties.Delegates

class DetailsFragment : Fragment() {

    private lateinit var postLogo: ImageView
    private lateinit var postImage: ImageView
    private lateinit var postAuthor: TextView
    private lateinit var postDescription: TextView
    private lateinit var postLike: TextView
    private lateinit var postComments: TextView
    private lateinit var postTime: TextView
    private lateinit var postLikeButton: ImageButton
    private lateinit var postBackButton: ImageButton
    private var postLiked: Boolean? = false
    private var postId by Delegates.notNull<Int>()
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
         return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView(view)
        setData()
    }

    private fun bindView(view: View) = with(view) {
        postLogo = findViewById(R.id.postLogo)
        postImage = findViewById(R.id.postImage)
        postAuthor = findViewById(R.id.postAuthorTextView)
        postDescription = findViewById(R.id.postDescriptionTextView)
        postLike = findViewById(R.id.postLikeTextView)
        postComments = findViewById(R.id.postCommentsTextView)
        postTime = findViewById(R.id.postTimeTextView)
        postLikeButton = findViewById(R.id.postLikeImageButton)
        postBackButton = findViewById(R.id.backImageButton)
        postId = arguments?.getInt("post_id", 1)!!

        postBackButton.setOnClickListener {
            activity?.onBackPressed()
        }
        postLikeButton.setOnClickListener {
            if(postLiked!!) {
                postLikeButton.setBackgroundResource(R.drawable.heart)

            } else {
                postLikeButton.setBackgroundResource(R.drawable.pressed_heart_button)
            }
            postViewModel.setLikeStatus(postId, !postLiked!!)
        }
    }

    private fun setData() {
        postViewModel.searchPost(postId = postId)
        postViewModel.liveData.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is PostViewModel.State.SearchResult -> {
                    setView(result.post)
                }
            }
        })
    }

    private fun setView(postData: PostData) {
        postLogo.setImageResource(postData.postLogo)
        postImage.setImageResource(postData.postImage)
        postAuthor.text = postData.postAuthor
        postLike.text = "Нравиться: " + postData.postLike.toString()
        postDescription.text = postAuthor.text as String + " " + postData.postDescription
        postComments.text = postData.postComments
        postTime.text = postData.postTime
        postLiked = postData.postLiked
        if (postLiked!!) {
            postLikeButton.setBackgroundResource(R.drawable.pressed_heart_button)
        } else {
            postLikeButton.setBackgroundResource(R.drawable.heart)
        }
    }
}