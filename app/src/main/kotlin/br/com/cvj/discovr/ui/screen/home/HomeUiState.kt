package br.com.cvj.discovr.ui.screen.home

import br.com.cvj.discovr.util.AppLanguage
import br.com.cvj.discovr.util.AppTheme

sealed interface HomeUiState {
    data object Loading : HomeUiState

    data class Error(
        val error: String? = null
    ) : HomeUiState

    data class Success(
        val language: AppLanguage,
        val theme: AppTheme
    ) : HomeUiState
}
