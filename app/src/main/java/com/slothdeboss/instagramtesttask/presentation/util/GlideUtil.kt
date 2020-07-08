package com.slothdeboss.instagramtesttask.presentation.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(uri: String) {
    Glide.with(this)
        .load(uri)
        .centerCrop()
        .into(this)
}
