package com.example.clean_architecture.data.repositories

import com.example.clean_architecture.data.api.ApiService
import com.example.clean_architecture.data.mappers.Mappers
import com.example.clean_architecture.data.models.response.Post
import com.example.clean_architecture.domain.models.PostUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
    protected val mappers: Mappers
) {

    suspend fun getPosts(postId: Int): com.example.clean_architecture.data.common.Result<PostUiModel> =
        withContext(Dispatchers.IO) {
            val response = apiService.getPosts(postId)
            if (response.isSuccessful) {
                return@withContext com.example.clean_architecture.data.common.Result.Success(
                    mappers.toPostUiModel(
                        response.body()!!
                    )
                )
            } else {
                return@withContext com.example.clean_architecture.data.common.Result.Error(
                    Exception(
                        response.message()
                    )
                )
            }
        }

}