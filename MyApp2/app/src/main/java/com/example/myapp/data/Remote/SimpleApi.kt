package com.example.myapp.data.Remote


import com.example.myapp.data.Model.PostItem
import com.example.myapp.utils.Constance
import com.example.myapp.utils.Constance.End_Point
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi  {
    @GET(value= End_Point)
    suspend fun GetPosts(): Response<PostItem>
    @GET(value= Constance.END_POINT_PATH)
    suspend fun GetPostNumber(@Path("Post Number") number:Int):Response<PostItem>
    @GET(value = "posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<PostItem>>
    @POST("Posts")
    suspend fun pushPost(@Body postItem: PostItem):Response<PostItem>
}