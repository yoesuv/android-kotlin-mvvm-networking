package com.yoesuv.networkkotlin2.di

import com.yoesuv.networkkotlin2.networks.GalleryRepository
import com.yoesuv.networkkotlin2.networks.GalleryRepositoryImpl
import com.yoesuv.networkkotlin2.networks.GalleryRepositoryMock
import com.yoesuv.networkkotlin2.networks.ListPlaceRepository
import com.yoesuv.networkkotlin2.networks.ListPlaceRepositoryImpl
import com.yoesuv.networkkotlin2.networks.ListPlaceRepositoryMock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideListPlaceRepository(): ListPlaceRepository {
        return ListPlaceRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideGalleryRepository() : GalleryRepository {
        return GalleryRepositoryImpl()
    }

}

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [NetworkModule::class])
object NetworkModuleMock {

    @Provides
    @Singleton
    fun provideListPlaceRepository(): ListPlaceRepository {
        return ListPlaceRepositoryMock()
    }

    @Provides
    @Singleton
    fun provideGalleryRepository() : GalleryRepository {
        return GalleryRepositoryMock()
    }

}