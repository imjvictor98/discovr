package br.com.cvj.discovr.ui.screen.addplace

import br.com.cvj.discovr.domain.model.google.place.GooglePlaces

sealed interface AddPlaceUiState {
    data object InitialState : AddPlaceUiState

    data object Loading : AddPlaceUiState

    data class Error(
        val error: String? = null
    ) : AddPlaceUiState

    data class Success(
        val places: List<GooglePlaces.Place>
    ) : AddPlaceUiState

    data object IsEmpty : AddPlaceUiState
}
