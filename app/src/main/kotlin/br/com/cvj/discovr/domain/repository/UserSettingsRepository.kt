package br.com.cvj.discovr.domain.repository

import br.com.cvj.discovr.util.AppLanguage
import br.com.cvj.discovr.util.AppTheme
import kotlinx.coroutines.flow.Flow

interface UserSettingsRepository {
    fun getTheme(): Flow<AppTheme>
    suspend fun setTheme(theme: AppTheme)

    fun getLanguage(): Flow<AppLanguage>
    fun setLanguage(language: AppLanguage)
}
