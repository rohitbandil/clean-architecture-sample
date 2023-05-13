package com.example.clean_architecture.domain.usecases

import com.example.clean_architecture.data.models.response.Post
import com.example.clean_architecture.domain.models.PostUiModel
import com.example.clean_architecture.domain.repository.Repository

class GetPost(private val repository: Repository) {
    suspend fun getPost(postId: Int): com.example.clean_architecture.data.common.Result<PostUiModel> {
        return repository.getPosts(postId)
    }
}