package com.example.retrofit.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.Model.PostItem
import com.example.myapp.data.Repository.PostRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    val postResponse: MutableLiveData<Response<PostItem>> = MutableLiveData()
    val postNumberResponse: MutableLiveData<Response<PostItem>> = MutableLiveData()
    val customPostResponse: MutableLiveData<Response<List<PostItem>>> = MutableLiveData()
    fun getPosts() {
        viewModelScope.launch {
            val response: Response<PostItem> = repository.getPosts()
            postResponse.value = response
        }
    }
    fun getPostNumber(number: Int) {
            viewModelScope.launch {
                val response: Response<PostItem> = repository.getPosts()
                postNumberResponse.value = response
            }
        }
    fun getCustomPosts(userId: Int, sort: String, order: String) {
            viewModelScope.launch {
                val response = repository.getCustomPosts(userId, sort, order)
                customPostResponse.value = response
            }
        }
fun setPosts(postItem: PostItem){
    viewModelScope.launch {
        val response: Response<PostItem> = repository.setPost(postItem)
        postResponse.value = response
    }
}
}



