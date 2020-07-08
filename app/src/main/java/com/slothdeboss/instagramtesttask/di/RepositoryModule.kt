package com.slothdeboss.instagramtesttask.di

import com.slothdeboss.instagramtesttask.data.repository.PostRepository
import com.slothdeboss.instagramtesttask.data.util.GsonUtil
import com.slothdeboss.instagramtesttask.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideRepository(gsonUtil: GsonUtil): Repository {
        return PostRepository(gsonUtil)
    }

}
