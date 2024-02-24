package br.com.cvj.discovr.di.google.places

import android.content.Context
import br.com.cvj.discovr.data.remote.ApiFactory
import br.com.cvj.discovr.data.remote.google.place.GooglePlacesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class GooglePlacesModule {

    @Provides
    fun provideGooglePlacesApi(context: Context): GooglePlacesApi {
        return ApiFactory.getPlacesServices(context)
    }
}
