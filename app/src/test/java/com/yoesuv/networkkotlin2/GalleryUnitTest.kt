package com.yoesuv.networkkotlin2

import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.utils.JsonParser
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class GalleryUnitTest {

    @Test
    fun response_isCorrect() {
        val response = JsonParser.stringToObject("gallery.json", GalleryModel::class.java)
        assertEquals(3, response.listData?.size)
    }

}