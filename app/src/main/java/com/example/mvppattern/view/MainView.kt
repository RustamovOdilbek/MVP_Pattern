package com.example.mvppattern.view

import com.example.mvppattern.model.Post

interface MainView {

    fun onPostListSuccrss(posts: ArrayList<Post>?)
    fun opPostListFailure(error: String)

    fun onPostDeleteSuccess(post: Post?)
    fun onPostDeleteFailure(error: String)
}