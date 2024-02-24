package br.com.cvj.discovr.data.remote.google.place

import br.com.cvj.discovr.domain.model.google.place.GooglePlaces
import br.com.cvj.discovr.domain.model.google.place.GooglePlacesError
import br.com.cvj.discovr.domain.model.google.place.GooglePlacesRequest
import br.com.cvj.discovr.util.helper.google.place.GooglePlaceHelper
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface GooglePlacesApi {
    @POST("v1/places:searchNearby")
    suspend fun searchNearby(
        @Header("X-Goog-FieldMask") masksAsString: String = GooglePlaceHelper.getFieldsMask(),
        @Body body: GooglePlacesRequest,
    ): NetworkResponse<GooglePlaces, GooglePlacesError>
}
