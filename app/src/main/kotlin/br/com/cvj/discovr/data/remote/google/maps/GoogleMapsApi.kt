package br.com.cvj.discovr.data.remote.google.maps

import br.com.cvj.discovr.domain.model.google.find.place.GoogleFindPlace
import br.com.cvj.discovr.domain.model.google.place.GooglePlacesError
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET

interface GoogleMapsApi {

// //    @GET("place/findplacefromtext/json")
// suspend fun findPlaceFromText(
//    @QueryMap options: Map<String, String> = GoogleMapsHelper.getQueryMap(),
//    @Query("input") nameToSearch: String,
// ): NetworkResponse<GoogleFindPlace, GooglePlacesError>

    @GET("http://demo4252717.mockable.io/findplacefromtext")
    suspend fun findPlaceFromText(): NetworkResponse<GoogleFindPlace, GooglePlacesError>
}
