package com.example.differentapis.presentation.delete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.differentapis.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _isDeleted = MutableStateFlow(false)
    val isDeleted: StateFlow<Boolean> = _isDeleted

    fun deletePost(postId: String) {
        viewModelScope.launch {
            try {
                val id = postId.toIntOrNull() ?: 0
                repository.deletePost(id)
                _isDeleted.value = true
            } catch (e: Exception) {
                // Ignore errors as per user request
            }
        }
    }
}
