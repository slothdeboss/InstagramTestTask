package com.slothdeboss.instagramtesttask.domain.repository

import com.slothdeboss.instagramtesttask.domain.entity.Post

interface Repository {
    fun fetchAllPosts(filePath: String): List<Post>
}