package com.slothdeboss.instagramtesttask.di

import android.content.Context
import com.google.gson.Gson
import com.slothdeboss.instagramtesttask.data.util.AssetUtil
import com.slothdeboss.instagramtesttask.data.util.GsonUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ApplicationComponent::class)
@Module
class UtilModule {

    @Provides
    fun provideAssetUtil() = AssetUtil()

    @Provides
    fun provideGson() = Gson()

    @Provides
    fun providesGsonUtil(
        @ApplicationContext context: Context,
        gson: Gson,
        assetUtil: AssetUtil
    ): GsonUtil {
        return GsonUtil(context, gson, assetUtil)
    }

}