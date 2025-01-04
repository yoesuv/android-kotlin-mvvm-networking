package com.yoesuv.networkkotlin2.di

import com.yoesuv.networkkotlin2.networks.GalleryRepository
import com.yoesuv.networkkotlin2.networks.ListPlaceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideListPlaceRepository(): ListPlaceRepository {
        return ListPlaceRepository()
    }

    @Provides
    @Singleton
    fun provideGalleryRepository() : GalleryRepository {
        return GalleryRepository()
    }

}