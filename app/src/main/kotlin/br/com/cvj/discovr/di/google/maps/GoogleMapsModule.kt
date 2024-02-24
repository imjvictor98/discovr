package br.com.cvj.discovr.di.google.maps

import android.content.Context
import br.com.cvj.discovr.data.remote.ApiFactory
import br.com.cvj.discovr.data.remote.google.maps.GoogleMapsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
class GoogleMapsModule {

    @Provides
    fun provideContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }

    @Provides
    fun provideGoogleMapsApi(context: Context): GoogleMapsApi {
        return ApiFactory.getMapsServices(context)
    }

    @Provides
    fun provideCoroutineContext(): CoroutineContext {
        return Dispatchers.IO
    }
}
