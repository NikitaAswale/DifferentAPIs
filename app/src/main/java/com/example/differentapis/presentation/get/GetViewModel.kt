package com.example.differentapis.presentation.get

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
class GetViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _posts.value = repository.getPosts()
            } catch (e: Exception) {
                // Ignore errors as per user request
            }
        }
    }
}
