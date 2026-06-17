package com.example.differentapis.presentation.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.differentapis.data.model.Post
import com.example.differentapis.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _createdPost = MutableStateFlow<Post?>(null)
    val createdPost: StateFlow<Post?> = _createdPost

    fun createPost(userId: Int, id: Int, title: String, body: String) {
        viewModelScope.launch {
            try {
                val post = Post(userId = userId, id = id, title = title, body = body)
                _createdPost.value = repository.createPost(post)
            } catch (e: Exception) {
                // Ignore errors as per user request
            }
        }
    }
}
