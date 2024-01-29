package br.com.cvj.discovr.ui.screen.addplace

sealed interface AddPlaceUiState {
    data object Loading : AddPlaceUiState

    data class Error(
        val error: String? = null
    ) : AddPlaceUiState

    data class Success(
        val ok: Boolean
    )
}
