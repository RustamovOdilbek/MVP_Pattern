package com.example.mvppattern.presenter

import com.example.mvppattern.model.Post
import com.example.mvppattern.network.RetrofitHttp
import com.example.mvppattern.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var mainView: MainView): MainPresenterImpl {

    override fun apiPostList() {
        RetrofitHttp.postService.listPost().enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>
            ) {
                mainView.onPostListSuccrss(response.body())
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                mainView.opPostListFailure(t.toString())
            }
        })
    }

    override fun apiPostDelete(post: Post) {
        RetrofitHttp.postService.deletePost(post.id).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                mainView.onPostDeleteSuccess(response.body())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                mainView.onPostDeleteFailure(t.toString())
            }
        })
    }
}