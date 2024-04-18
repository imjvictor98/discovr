package br.com.cvj.discovr.ui.screen.addplace.step

import androidx.lifecycle.ViewModel
import br.com.cvj.discovr.domain.repository.google.maps.GoogleMapsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddPlaceStepViewModel @Inject constructor(private val mapsRepository: GoogleMapsRepository) :
    ViewModel()
