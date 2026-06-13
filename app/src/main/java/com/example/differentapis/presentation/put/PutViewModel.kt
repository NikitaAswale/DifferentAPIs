package com.example.differentapis.presentation.put

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
class PutViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _updatedPost = MutableStateFlow<Post?>(null)
    val updatedPost: StateFlow<Post?> = _updatedPost

    fun updatePost(postId: String, title: String, body: String) {
        viewModelScope.launch {
            try {
                val id = postId.toIntOrNull() ?: 0
                val post = Post(userId = 1, id = id, title = title, body = body)
                _updatedPost.value = repository.updatePost(id, post)
            } catch (e: Exception) {
                // Ignore errors as per user request
            }
        }
    }
}
