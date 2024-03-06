package br.com.cvj.discovr.ui.screen.addplace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cvj.discovr.domain.repository.google.maps.GoogleMapsRepository
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AddPlaceViewModel @Inject constructor(
    private val mapsRepository: GoogleMapsRepository,
) : ViewModel() {

    private val _addPlaceUiState: MutableStateFlow<AddPlaceUiState> =
        MutableStateFlow(AddPlaceUiState.InitialState)

    val addPlaceUiState: StateFlow<AddPlaceUiState>
        get() = _addPlaceUiState

    fun searchPlaces(name: String) {
        viewModelScope.launch {
            try {
                _addPlaceUiState.value = AddPlaceUiState.Loading
                when (val response = mapsRepository.findPlaceFromText(name)) {
                    is NetworkResponse.Success -> {
                        if (response.body.candidates?.isNotEmpty() == true) {
                            _addPlaceUiState.value = AddPlaceUiState.Success(response.body.candidates!!)
                        } else {
                            _addPlaceUiState.value = AddPlaceUiState.IsEmpty
                        }
                        Timber.d("Fetch Places Api returns: %s", response.body)
                    }

                    is NetworkResponse.NetworkError -> {
                        throw Error(response.error.message)
                    }

                    is NetworkResponse.ServerError -> {
                        _addPlaceUiState.value = AddPlaceUiState.Error(response.body?.error?.message ?: "Server Error")
                        throw Error(response.body?.error?.message)
                    }

                    is NetworkResponse.UnknownError -> {
                        throw Error("Unknown Error")
                    }

                    else -> {
                        throw Error("Network Error")
                    }
                }
            } catch (e: Error) {
                _addPlaceUiState.value = AddPlaceUiState.Error("Network Error")
                Timber.e(e)
            }
        }
    }
}
