package com.example.socialnetworkbottomnavigation.base

import android.view.View

interface OnItemClickListener {
    fun onItemClick(position: Int, view: View)
    fun onHeartClick(position: Int, view: View)
}