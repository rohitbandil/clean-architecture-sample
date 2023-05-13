package com.example.clean_architecture.data.mappers

import com.example.clean_architecture.data.models.response.Post
import com.example.clean_architecture.domain.models.PostUiModel
import javax.inject.Inject

class Mappers @Inject constructor() {
    fun toPostUiModel(post: Post) : PostUiModel = PostUiModel(post.userId, post.id, post.title, post.body)
}