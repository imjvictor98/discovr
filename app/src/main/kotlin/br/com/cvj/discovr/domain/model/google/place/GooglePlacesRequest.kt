package br.com.cvj.discovr.domain.model.google.place

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class GooglePlacesRequest(
    @Json(name = "includedTypes")
    val includedTypes: List<String>,
    @Json(name = "locationRestriction")
    val locationRestriction: PlaceLocationRestriction,
    @Json(name = "maxResultCount")
    val maxResultCount: Int
) : Serializable

@JsonClass(generateAdapter = true)
data class PlaceLocationRestriction(
    @Json(name = "circle")
    val circle: PlaceCircle
)

@JsonClass(generateAdapter = true)
data class PlaceCenter(
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "longitude")
    val longitude: Double
)

@JsonClass(generateAdapter = true)
data class PlaceCircle(
    @Json(name = "center")
    val center: PlaceCenter,
    @Json(name = "radius")
    val radius: Double
)
