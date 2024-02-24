package br.com.cvj.discovr.domain.model.google.find.place

import br.com.cvj.discovr.domain.model.google.place.GooglePlaces
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoogleFindPlace(
    @Json(name = "candidates") val candidates: List<GooglePlaces.Place>? = null,
    @Json(name = "status") val status: String
)
