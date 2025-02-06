package com.yoesuv.networkkotlin2

import com.yoesuv.networkkotlin2.di.NetworkModule
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.utils.JsonParser
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
//@UninstallModules(NetworkModule::class)
@RunWith(RobolectricTestRunner::class)
class GalleryUnitTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun response_isCorrect() {
        val response = JsonParser.stringToObject("gallery.json", GalleryModel::class.java)
        assertEquals(3, response.listData?.size)
    }

}