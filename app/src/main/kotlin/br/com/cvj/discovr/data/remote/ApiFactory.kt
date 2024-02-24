package br.com.cvj.discovr.data.remote

import android.content.Context
import br.com.cvj.discovr.BuildConfig
import br.com.cvj.discovr.R
import br.com.cvj.discovr.data.remote.google.maps.GoogleMapsApi
import br.com.cvj.discovr.data.remote.google.place.GooglePlacesApi
import br.com.cvj.discovr.util.helper.network.MoshiHelper
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    private val moshi = MoshiHelper.getInstance()

    fun getPlacesServices(context: Context): GooglePlacesApi {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original
                .newBuilder()
                .addHeader("X-Goog-Api-Key", BuildConfig.PLACES_API_KEY)
                .addHeader("Accept-Language", "pt-BR")
                .url(original.url)
                .build()

            chain.proceed(request)
        }

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        httpClient.addInterceptor(logging).callTimeout(10000, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.places_base_url))
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client((httpClient.build()))
            .build()
            .create(GooglePlacesApi::class.java)
    }

    fun getMapsServices(context: Context): GoogleMapsApi {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original
                .newBuilder()
                .addHeader("Accept-Language", "pt-BR")
                .url(original.url)
                .build()

            chain.proceed(request)
        }

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        httpClient.addInterceptor(logging).callTimeout(10000, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.maps_base_url))
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client((httpClient.build()))
            .build()
            .create(GoogleMapsApi::class.java)
    }
}
