package com.slothdeboss.instagramtesttask.data.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.slothdeboss.instagramtesttask.domain.entity.Post
import java.lang.reflect.Type
import javax.inject.Inject

class GsonUtil @Inject constructor(
    private val context: Context,
    private val gson: Gson,
    private val assetUtil: AssetUtil
) {

    fun getPosts(filename: String): List<Post> {
        val json = assetUtil.getJsonDataFromAsset(context, filename)
        val token = getListToken()
        return gson.fromJson(json, token)
    }

    private fun getListToken(): Type {
        return object: TypeToken<List<Post>>() {}.type
    }

}