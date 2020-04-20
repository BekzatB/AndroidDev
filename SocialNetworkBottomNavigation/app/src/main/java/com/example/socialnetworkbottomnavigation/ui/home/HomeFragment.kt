package com.example.socialnetworkbottomnavigation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialnetworkbottomnavigation.R
import com.example.socialnetworkbottomnavigation.base.OnItemClickListener

class HomeFragment : Fragment() {

    private lateinit var homePostRecyclerView: RecyclerView
    private lateinit var navController: NavController
    private var homePostAdapter: HomePostAdapter? = null
    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateComponent()
    }

    private fun onCreateComponent() {
        homePostAdapter = HomePostAdapter()
    }

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
                    postViewModel.setLikeStatus(postId, !likeStatus!!)
                    if (post != null) {
                        homePostAdapter!!.changeItem(post)
                    }
                }
                postViewModel.getLikedPosts()
            }
        })
    }

    private fun setData() {
        homePostAdapter?.clear()
        postViewModel.loadPost()

        postViewModel.liveData.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is PostViewModel.State.Result -> {
                    homePostAdapter?.addItems(result.postList)
                }
            }
        })
    }
}