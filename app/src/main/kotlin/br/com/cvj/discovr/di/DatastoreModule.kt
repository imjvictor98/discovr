package br.com.cvj.discovr.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import br.com.cvj.discovr.ProtoUserPreferences
import br.com.cvj.discovr.data.local.datastore.user.preferences.ProtoUserPreferencesSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    @Provides
    @Singleton
    fun providesUserPreferencesDatastore(
        @ApplicationContext context: Context,
        protoUserPreferencesSerializer: ProtoUserPreferencesSerializer,
    ): DataStore<ProtoUserPreferences> =
        DataStoreFactory.create(
            serializer = protoUserPreferencesSerializer,
            scope = CoroutineScope(SupervisorJob())
        ) {
            context.dataStoreFile("user_preferences.pb")
        }
}
