package com.example.clean_architecture.data.repositories

import com.example.clean_architecture.data.models.response.Post
import com.example.clean_architecture.domain.models.PostUiModel
import com.example.clean_architecture.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {

    override suspend fun getPosts(id: Int): com.example.clean_architecture.data.common.Result<PostUiModel> {
        return remoteDataSource.getPosts(id)
    }
}