package br.com.cvj.discovr.domain.repository.google.place

import br.com.cvj.discovr.data.remote.google.place.GooglePlacesApi
import br.com.cvj.discovr.domain.model.google.place.GooglePlacesRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GooglePlacesRepository @Inject constructor(
    private val placeServices: GooglePlacesApi,

    private val dispatcher: CoroutineContext = Dispatchers.IO
) {
    suspend fun getPlacesNearby(
        placeDescription: GooglePlacesRequest
    ) = withContext(dispatcher) {
        placeServices.searchNearby(body = placeDescription)
    }
}
