package com.slothdeboss.instagramtesttask.data.repository

import com.slothdeboss.instagramtesttask.data.util.GsonUtil
import com.slothdeboss.instagramtesttask.domain.entity.Post
import com.slothdeboss.instagramtesttask.domain.repository.Repository
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val gsonUtil: GsonUtil
): Repository {

    override fun fetchAllPosts(filePath: String): List<Post> {
        return gsonUtil.getPosts(filePath)
    }
}