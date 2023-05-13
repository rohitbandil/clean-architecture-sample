package com.example.clean_architecture.ui.viewmodel

import androidx.lifecycle.*
import com.example.clean_architecture.data.models.response.Post
import com.example.clean_architecture.domain.models.PostUiModel
import com.example.clean_architecture.domain.usecases.GetPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPost: GetPost): ViewModel() {

    private val _post = MutableLiveData<PostUiModel>()
    val post: LiveData<PostUiModel> = _post

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getPost(postId: Int) {
        viewModelScope.launch {
            when(val post = getPost.getPost(postId)) {
                is com.example.clean_architecture.data.common.Result.Success -> {
                    _post.postValue(post.data!!)
                }
                is com.example.clean_architecture.data.common.Result.Error -> {
                    _error.postValue(post.exception.message)
                }
            }
        }
    }
}