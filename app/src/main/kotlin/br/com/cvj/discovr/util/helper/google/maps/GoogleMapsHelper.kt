package br.com.cvj.discovr.util.helper.google.maps

import br.com.cvj.discovr.BuildConfig

object GoogleMapsHelper {
    fun getFields() = "formatted_address,name,geometry,photo,place_id"

    fun getQueryMap() = mapOf(
        "inputtype" to "textquery",
        "fields" to getFields(),
        "key" to BuildConfig.PLACES_API_KEY
    )
}
