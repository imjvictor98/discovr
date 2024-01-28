package br.com.cvj.discovr.di

import br.com.cvj.discovr.data.repository.UserSettingsRepositoryImpl
import br.com.cvj.discovr.domain.repository.UserSettingsRepository
import br.com.cvj.discovr.util.network.ConnectivityManagerNetworkMonitor
import br.com.cvj.discovr.util.network.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor
    ): NetworkMonitor

    @Binds
    abstract fun bindsUserSettingsRepository(
        userSettingsRepositoryImpl: UserSettingsRepositoryImpl
    ): UserSettingsRepository
}
