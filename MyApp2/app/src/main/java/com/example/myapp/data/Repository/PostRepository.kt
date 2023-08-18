package com.example.myapp.data.Repository
import com.example.myapp.data.Model.PostItem
import com.example.myapp.data.Remote.RetrofitInstance
import retrofit2.Response

class PostRepository {
    suspend fun getPosts():Response<PostItem> = RetrofitInstance.api.GetPosts()
    suspend fun getPostNumber(Number:Int):Response<PostItem> = RetrofitInstance.api.GetPostNumber(Number)
    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<PostItem>> =
        RetrofitInstance.api.getCustomPost(userId, sort, order)
    suspend fun setPost(postItem: PostItem):Response<PostItem> = RetrofitInstance.api.pushPost(postItem)
}