package br.com.cvj.discovr.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cvj.discovr.domain.model.google.place.GooglePlacesRequest
import br.com.cvj.discovr.domain.model.google.place.PlaceCenter
import br.com.cvj.discovr.domain.model.google.place.PlaceCircle
import br.com.cvj.discovr.domain.model.google.place.PlaceLocationRestriction
import br.com.cvj.discovr.domain.repository.UserSettingsRepository
import br.com.cvj.discovr.domain.repository.google.maps.GoogleMapsRepository
import br.com.cvj.discovr.domain.repository.google.place.GooglePlacesRepository
import br.com.cvj.discovr.util.AppLanguage
import br.com.cvj.discovr.util.AppTheme
import br.com.cvj.discovr.util.Result
import br.com.cvj.discovr.util.asResult
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userSettingsRepository: UserSettingsRepository,
    private val placesRepository: GooglePlacesRepository,
    private val mapsRepository: GoogleMapsRepository,
) : ViewModel() {

    val uiState = combine(
        userSettingsRepository.getLanguage(),
        userSettingsRepository.getTheme(),
        ::Pair
    ).asResult()
        .map { result ->
            when (result) {
                Result.Loading -> HomeUiState.Loading
                is Result.Success -> {
                    val (language, theme) = result.data

                    HomeUiState.Success(
                        language = language,
                        theme = theme
                    )
                }

                is Result.Error -> HomeUiState.Error()
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState.Loading
        )

    private val _locationUiState: MutableStateFlow<LocationUiState> =
        MutableStateFlow(LocationUiState.Initial)

    val locationUiState: StateFlow<LocationUiState> =
        _locationUiState

    fun updateTheme(theme: AppTheme) {
        viewModelScope.launch {
            userSettingsRepository.setTheme(theme)
        }
    }

    fun updateLanguage(language: AppLanguage) {
        viewModelScope.launch {
            userSettingsRepository.setLanguage(language)
        }
    }

    fun getPlacesNearby(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            when (
                val response = placesRepository.getPlacesNearby(
                    GooglePlacesRequest(
                        includedTypes = listOf("restaurant"),
                        maxResultCount = 20,
                        locationRestriction = PlaceLocationRestriction(
                            circle = PlaceCircle(
                                center = PlaceCenter(
                                    latitude = latitude,
                                    longitude = longitude
                                ),
                                radius = 3000.0
                            )
                        )
                    )
                )
            ) {
                is NetworkResponse.Success -> {
                    if (response.body.places?.isNotEmpty() == true) {
                        _locationUiState.value = LocationUiState.Success(response.body.places!!)
                    }
                    Timber.d("Fetch Places Api returns: %s", response.body.places)
                }
                is NetworkResponse.NetworkError -> {
                    Timber.e(response.error, "Error to make request to places API: %s", response.toString())
                }
                is NetworkResponse.ServerError -> {
                    Timber.d("Error to make request to places API: %s", response.body?.error?.message)
                }
                is NetworkResponse.UnknownError -> {
                    Timber.e(response.error, "Error to make request to places API")
                }
                else -> {
                    // TODO: handle network error
                    Timber.e("Error to make request to places API")
                }
            }
        }
    }

    fun getFindPlaces(name: String) {
        viewModelScope.launch {
            when (val response = mapsRepository.findPlaceFromText(name)) {
                is NetworkResponse.Success -> {
                    if (response.body.candidates?.isNotEmpty() == true) {
//                        _locationUiState.value = LocationUiState.Success(response.body.places!!)
                    }
                    Timber.d("Fetch Places Api returns: %s", response.body)
                }
                is NetworkResponse.NetworkError -> {
                    Timber.e(response.error, "Error to make request to places API: %s", response.toString())
                }
                is NetworkResponse.ServerError -> {
                    Timber.d("Error to make request to places API: %s", response.body?.error?.message)
                }
                is NetworkResponse.UnknownError -> {
                    Timber.e(response.error, "Error to make request to places API")
                }
                else -> {
                    // TODO: handle network error
                    Timber.e("Error to make request to places API")
                }
            }
        }
    }
}
