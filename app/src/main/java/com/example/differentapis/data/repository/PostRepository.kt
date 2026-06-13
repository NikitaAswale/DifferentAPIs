package com.example.differentapis.data.repository

import com.example.differentapis.data.model.Post
import com.example.differentapis.data.remote.ApiService
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getPosts() = apiService.getPosts()
    suspend fun createPost(post: Post) = apiService.createPost(post)
    suspend fun updatePost(id: Int, post: Post) = apiService.updatePost(id, post)
    suspend fun deletePost(id: Int) = apiService.deletePost(id)
}
