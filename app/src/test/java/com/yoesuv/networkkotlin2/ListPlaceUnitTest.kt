package com.yoesuv.networkkotlin2

import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.runners.MethodSorters

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ListPlaceUnitTest {

    @Test
    fun response_isCorrect() {
        val response = JsonParser.stringToObject("list_place.json", ListPlaceModel::class.java)
        assertEquals(3, response.data?.size)
    }

}
