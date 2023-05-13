package com.example.clean_architecture.domain.repository

import com.example.clean_architecture.data.models.response.Post
import com.example.clean_architecture.domain.models.PostUiModel

interface Repository {
    suspend fun getPosts(id: Int): com.example.clean_architecture.data.common.Result<PostUiModel>
}