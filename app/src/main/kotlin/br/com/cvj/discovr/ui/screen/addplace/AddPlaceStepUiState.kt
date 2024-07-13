package br.com.cvj.discovr.ui.screen.addplace

import br.com.cvj.discovr.domain.model.detail.DetailsPlace

interface AddPlaceStepUiState {
    object InitialState : AddPlaceStepUiState

    data class PlaceSelected(val detailsPlace: DetailsPlace) : AddPlaceStepUiState
}
