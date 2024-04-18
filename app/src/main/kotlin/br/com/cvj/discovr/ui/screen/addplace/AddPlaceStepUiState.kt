package br.com.cvj.discovr.ui.screen.addplace

import br.com.cvj.discovr.domain.model.google.place.GooglePlaces

interface AddPlaceStepUiState {
    object InitialState : AddPlaceStepUiState

    data class PlaceSelected(val place: GooglePlaces.Place) : AddPlaceStepUiState
}
