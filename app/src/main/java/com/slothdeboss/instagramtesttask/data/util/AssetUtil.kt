package com.slothdeboss.instagramtesttask.data.util

import android.content.Context
import java.io.IOException
import javax.inject.Inject

class AssetUtil @Inject constructor() {

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val json: String
        try {
            json = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return json
    }

}