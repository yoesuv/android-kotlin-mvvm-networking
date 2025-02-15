package com.yoesuv.networkkotlin2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.MainListPlaceViewModel
import com.yoesuv.networkkotlin2.networks.ListPlaceRepositoryMock
import com.yoesuv.networkkotlin2.utils.JsonParser
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ListPlaceUnitTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    private lateinit var viewModel: MainListPlaceViewModel

    @Before
    fun setup() {
        viewModel = MainListPlaceViewModel(
            listPlaceRepository = ListPlaceRepositoryMock()
        )
    }

    @Test
    fun `response is correct`() {
        val response = JsonParser.stringToObject("list_place.json", ListPlaceModel::class.java)
        assertEquals(3, response.data?.size)
    }

    @Test
    fun `request list place`() {
        viewModel.requestListPlace()
        val result = viewModel.listData.getOrAwaitValue()
        assertEquals(3, result?.data?.size)
    }

}
