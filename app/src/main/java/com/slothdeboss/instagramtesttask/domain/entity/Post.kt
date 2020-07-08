package com.slothdeboss.instagramtesttask.domain.entity

data class Post(
    val username: String,
    val location: String,
    val imageUrl: String,
    val likes: List<String>,
    val description: String
)