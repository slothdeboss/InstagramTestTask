package com.slothdeboss.instagramtesttask.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slothdeboss.instagramtesttask.domain.entity.Post
import com.slothdeboss.instagramtesttask.domain.repository.Repository

class PostViewModel @ViewModelInject constructor(
    private val repository: Repository
): ViewModel() {

    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>>
        get() = _posts

    fun fetchPosts(filePath: String) {
        try {
            _posts.value = repository.fetchAllPosts(filePath = filePath)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}