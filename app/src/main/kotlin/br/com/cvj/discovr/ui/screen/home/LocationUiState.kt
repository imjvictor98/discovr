package br.com.cvj.discovr.ui.screen.home

import br.com.cvj.discovr.domain.model.google.place.GooglePlaces

sealed class LocationUiState {
    object Initial : LocationUiState()
    data class Success(val places: List<GooglePlaces.Place>) : LocationUiState()
}
