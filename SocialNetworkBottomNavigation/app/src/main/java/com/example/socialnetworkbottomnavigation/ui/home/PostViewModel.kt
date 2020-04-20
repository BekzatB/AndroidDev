package com.example.socialnetworkbottomnavigation.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.socialnetworkbottomnavigation.model.PostData
import com.example.socialnetworkbottomnavigation.model.SetPostData

class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val _liveData = MutableLiveData<State>()
    val liveData: LiveData<State>
        get() = _liveData

    private val postList: ArrayList<PostData> = ArrayList(
        listOf(
            SetPostData.firstPostData,
            SetPostData.secondPostData, SetPostData.thirdPostData, SetPostData.fourthPostData,
            SetPostData.fifthPostData, SetPostData.sixthPostData, SetPostData.seventhPostData,
            SetPostData.eighthPostData, SetPostData.ninthPostData, SetPostData.tenthPostData,
            SetPostData.eleventhPostData, SetPostData.twelfthPostData,
            SetPostData.thirteenthPostData, SetPostData.fourteenthPostData,
            SetPostData.fifteenthPostData, SetPostData.sixteenthPostData,
            SetPostData.seventeenthPostData, SetPostData.eighteenthPostData,
            SetPostData.nineteenthPostData, SetPostData.twentiethPostData
        )
    )

    fun loadPost() {
        _liveData.value =
            State.Result(
                postList
            )
    }

    fun searchPost(postId: Int) {
        postList.forEach {
            if (postId == it.postId) {
                _liveData.value =
                    State.SearchResult(
                        it
                    )
                return
            }
        }
    }

    fun setLikeStatus(postId: Int, likeStatus: Boolean) {
        postList.forEach {
            if (postId == it.postId) {
                it.postLiked = likeStatus
                _liveData.value =
                    State.LikeStatusResult(
                        it
                    )
                return
            }
        }
    }

    fun getLikedPosts() {
        var likeList: ArrayList<PostData> = ArrayList()
        var check = false
        postList.forEach {
            if (it.postLiked!!) {
                likeList.add(it)
                check = true
            }
        }
        if (check) {
            _liveData.value =
                State.LikedPostsResult(
                    likeList
                )
        }
    }

    sealed class State {
        data class Result(val postList: ArrayList<PostData>) : State()
        data class SearchResult(val post: PostData) : State()
        data class LikeStatusResult(val post: PostData) : State()
        data class LikedPostsResult(val postList: ArrayList<PostData>) : State()
    }
}