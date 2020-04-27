package com.example.simplesocialnetwork.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplesocialnetwork.R
import com.example.simplesocialnetwork.base.OnItemClickListener
import com.example.simplesocialnetwork.model.PostList

class MainActivity : AppCompatActivity() {

    private lateinit var postRecyclerView: RecyclerView
    private var postAdapter: PostAdapter? = null
    private val postList = PostList.postList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        setData()
    }

    private fun bindView() {
        postRecyclerView = findViewById(R.id.postRecyclerView)
        postRecyclerView.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        )

        postAdapter = PostAdapter()
        postRecyclerView.adapter = postAdapter
        postAdapter?.setOnItemClickListener(onItemClickListener = object :
                OnItemClickListener {
            override fun onItemClick(position: Int, view: View) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun setData() {
        postAdapter?.addItems(postList)
    }
}
