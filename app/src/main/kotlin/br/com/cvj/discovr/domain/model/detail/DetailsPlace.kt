package br.com.cvj.discovr.domain.model.detail

import br.com.cvj.discovr.domain.model.google.place.GooglePlaces

data class DetailsPlace(
    val place: GooglePlaces.Place,
    val instagram: String? = null,
)
