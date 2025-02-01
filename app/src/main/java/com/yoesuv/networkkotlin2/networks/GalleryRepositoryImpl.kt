package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.data.EndPoint
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.utils.IdlingResource
import com.yoesuv.networkkotlin2.utils.forTest
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.encodedPath
import kotlinx.coroutines.flow.flow

class GalleryRepositoryImpl: GalleryRepository {

    override fun getListGallery() = flow<Resource<GalleryModel>> {
        try {
            if (forTest()) IdlingResource.increment()
            emit(Resource.Loading())
            val result = client.get {
                url {
                    encodedPath = EndPoint.LIST_GALLERY
                }
            }
            if (forTest()) {
                if (!IdlingResource.idlingresource.isIdleNow) {
                    IdlingResource.decrement()
                }
            }
            emit(Resource.Success(result.body()))
        } catch (e: Exception) {
            if (forTest()) {
                if (!IdlingResource.idlingresource.isIdleNow) {
                    IdlingResource.decrement()
                }
            }
            emit(Resource.Error("Failed get galleries", e))
        }
    }

}