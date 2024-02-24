package br.com.cvj.discovr.domain.repository.google.maps

import br.com.cvj.discovr.data.remote.google.maps.GoogleMapsApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GoogleMapsRepository @Inject constructor(
    private val googleMapsApi: GoogleMapsApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun findPlaceFromText(nameToSearch: String) = withContext(dispatcher) {
        googleMapsApi.findPlaceFromText(
            nameToSearch = nameToSearch
        )
    }
}
