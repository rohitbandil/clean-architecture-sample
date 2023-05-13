package com.example.clean_architecture.data.api

import com.example.clean_architecture.data.models.response.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts/{postId}")
    suspend fun getPosts(@Path("postId") postId: Int): Response<Post>
}