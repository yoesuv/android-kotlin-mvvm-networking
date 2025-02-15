package com.yoesuv.networkkotlin2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.menu.gallery.viewmodels.MainGalleryViewModel
import com.yoesuv.networkkotlin2.networks.GalleryRepositoryMock
import com.yoesuv.networkkotlin2.utils.JsonParser
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class GalleryUnitTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private lateinit var viewModel: MainGalleryViewModel

    @Before
    fun setUp() {
        viewModel = MainGalleryViewModel(
            galleryRepository = GalleryRepositoryMock()
        )
    }

    @Test
    fun `response is correct`() {
        val response = JsonParser.stringToObject("gallery.json", GalleryModel::class.java)
        assertEquals(3, response.listData?.size)
    }

    @Test
    fun `request list gallery`() {
        viewModel.requestListGallery()
        val result = viewModel.liveDataGallery.getOrAwaitValue()
        assertEquals(3, result?.listData?.size)
    }

}