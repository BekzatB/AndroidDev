package com.example.simplesocialnetworkbn.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplesocialnetworkbn.R
import com.example.simplesocialnetworkbn.base.OnItemClickListener
import com.example.simplesocialnetworkbn.model.PostList

class HomeFragment : Fragment() {

    private lateinit var homePostRecyclerView: RecyclerView
    private lateinit var navController: NavController
    private var homePostAdapter: HomePostAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.show()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView(view)
        setAdapter()
        setData()
    }

    private fun bindView(view: View) = with(view) {
        homePostRecyclerView = findViewById(R.id.postRecyclerView)
        navController = Navigation.findNavController(this)
        homePostRecyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun setAdapter() {
        homePostAdapter = HomePostAdapter()
        homePostRecyclerView.adapter = homePostAdapter

        homePostAdapter?.setOnItemClickListener(onItemClickListener = object :
            OnItemClickListener {
            override fun onItemClick(position: Int, view: View) {
                val postId = homePostAdapter?.getItem(position)?.postId
                val bundle = Bundle()
                if (postId != null) {
                    bundle.putInt("post_id", postId)
                }
                navController.navigate(
                    R.id.action_homeFragment_to_detailsFragment,
                    bundle
                )
            }

            override fun onHeartClick(position: Int, view: View) {
                val postId = homePostAdapter?.getItem(position)?.postId
                val likeStatus = homePostAdapter?.getItem(position)?.postLiked
                val post = homePostAdapter?.getItem(position)
                if (postId != null) {
                    if (likeStatus != null) {
                        setLikeStatus(postId, !likeStatus)
                    }
                    if (post != null) {
                        homePostAdapter?.changeItem(post)
                    }
                }
                homePostAdapter?.clear()
                homePostAdapter?.addItems(PostList.postList)
            }
        })
    }

    private fun setData() {
        homePostAdapter?.clear()
        homePostAdapter?.addItems(PostList.postList)
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