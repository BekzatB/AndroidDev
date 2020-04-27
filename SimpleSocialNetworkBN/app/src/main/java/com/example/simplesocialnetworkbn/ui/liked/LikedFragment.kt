package com.example.simplesocialnetworkbn.ui.liked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplesocialnetworkbn.R
import com.example.simplesocialnetworkbn.base.OnItemClickListener
import com.example.simplesocialnetworkbn.model.PostData
import com.example.simplesocialnetworkbn.model.PostList

class LikedFragment : Fragment() {

    private lateinit var likedPostRecyclerView: RecyclerView
    private lateinit var navController: NavController
    private var likedPostAdapter: LikedPostAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        return inflater.inflate(R.layout.fragment_liked, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView(view)
        setAdapter()
        setData()
    }

    private fun bindView(view: View) = with(view) {
        likedPostRecyclerView = findViewById(R.id.likedPostRecyclerView)
        navController = Navigation.findNavController(view)
        likedPostRecyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setAdapter() {
        likedPostAdapter = LikedPostAdapter()
        likedPostRecyclerView.adapter = likedPostAdapter

        likedPostAdapter?.setOnItemClickListener(onItemClickListener = object :
            OnItemClickListener {
            override fun onItemClick(position: Int, view: View) {
                val postId = likedPostAdapter?.getItem(position)?.postId
                val bundle = Bundle()
                if (postId != null) {
                    bundle.putInt("post_id", postId)
                }
                navController.navigate(
                    R.id.action_likedFragment_to_detailsFragment,
                    bundle
                )
            }

            override fun onHeartClick(position: Int, view: View) {
                val postId = likedPostAdapter?.getItem(position)?.postId
                val likeStatus = likedPostAdapter?.getItem(position)?.postLiked
                val post = likedPostAdapter?.getItem(position)
                if (postId != null) {
                 setLikeStatus(postId, !likeStatus!!)
                    if (post != null) {
                        likedPostAdapter!!.changeItem(post)
                    }
                }
                likedPostAdapter?.clear()
                likedPostAdapter?.addItems(PostList.postList)
            }
        })
    }

    private fun setData() {
        likedPostAdapter?.clear()
        var likeList: ArrayList<PostData> = ArrayList()
        PostList.postList.forEach {
            if (it.postLiked != null) {
                if (it.postLiked!!) {
                    likeList.add(it)
                }
            }
        }
        likedPostAdapter?.addItems(likeList)
    }

    private fun setLikeStatus(postId: Int, likeStatus: Boolean) {
        PostList.postList.forEach {
            if (postId == it.postId) {
                it.postLiked = likeStatus
                return
            }
        }
    }
}