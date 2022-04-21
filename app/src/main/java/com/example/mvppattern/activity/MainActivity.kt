package com.example.mvppattern.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvppattern.R
import com.example.mvppattern.adapter.PostAdapter
import com.example.mvppattern.model.Post
import com.example.mvppattern.presenter.MainPresenter
import com.example.mvppattern.view.MainView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var recyclerView: RecyclerView
    lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        mainPresenter = MainPresenter(this)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        mainPresenter.apiPostList()
    }

    fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.setAdapter(adapter)
    }

    override fun onPostListSuccrss(posts: ArrayList<Post>?) {
        refreshAdapter(posts!!)
    }

    override fun opPostListFailure(error: String) {

    }

    override fun onPostDeleteSuccess(post: Post?) {
        mainPresenter.apiPostList()
    }

    override fun onPostDeleteFailure(error: String) {

    }
}