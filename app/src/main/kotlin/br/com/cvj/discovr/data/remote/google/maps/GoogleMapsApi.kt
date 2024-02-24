package br.com.cvj.discovr.data.remote.google.maps

import br.com.cvj.discovr.domain.model.google.find.place.GoogleFindPlace
import br.com.cvj.discovr.domain.model.google.place.GooglePlacesError
import br.com.cvj.discovr.util.helper.google.maps.GoogleMapsHelper
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface GoogleMapsApi {

    @GET("place/findplacefromtext/json")
    suspend fun findPlaceFromText(
        @QueryMap options: Map<String, String> = GoogleMapsHelper.getQueryMap(),
        @Query("input") nameToSearch: String,
    ): NetworkResponse<GoogleFindPlace, GooglePlacesError>
}
