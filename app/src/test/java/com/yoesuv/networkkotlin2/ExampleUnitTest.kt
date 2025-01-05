package com.yoesuv.networkkotlin2

import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val response = JsonParser.stringToObject("list_place.json", ListPlaceModel::class.java)
        println("Response # ${response.data?.size}")
        assertEquals(3, response.data?.size)
    }
}
