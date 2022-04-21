package com.example.mvppattern.presenter

import com.example.mvppattern.model.Post

interface MainPresenterImpl {
    fun apiPostList()
    fun apiPostDelete(post: Post)
}