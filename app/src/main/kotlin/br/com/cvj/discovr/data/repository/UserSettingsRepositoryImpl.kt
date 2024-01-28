package br.com.cvj.discovr.data.repository

import br.com.cvj.discovr.data.local.LanguageLocalDataSource
import br.com.cvj.discovr.data.local.datastore.user.preferences.UserPreferencesLocalDataSource
import br.com.cvj.discovr.data.mapper.toAppLanguage
import br.com.cvj.discovr.data.mapper.toLocal
import br.com.cvj.discovr.data.mapper.toProto
import br.com.cvj.discovr.domain.repository.UserSettingsRepository
import br.com.cvj.discovr.util.AppLanguage
import br.com.cvj.discovr.util.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserSettingsRepositoryImpl @Inject constructor(
    private val userPreferencesLocalDataSource: UserPreferencesLocalDataSource,
    private val languageLocalDataSource: LanguageLocalDataSource
) : UserSettingsRepository {

    override fun getTheme(): Flow<AppTheme> {
        return userPreferencesLocalDataSource.getProtoTheme().map { it.toLocal() }
    }

    override suspend fun setTheme(theme: AppTheme) {
        userPreferencesLocalDataSource.setProtoTheme(theme.toProto())
    }

    override fun getLanguage(): Flow<AppLanguage> {
        return languageLocalDataSource.getLocale().map { it.toAppLanguage() }
    }

    override fun setLanguage(language: AppLanguage) {
        languageLocalDataSource.setLocale(language.locale)
    }
}
