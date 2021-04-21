package com.doe.compshop.di

import android.app.Application
import com.doe.compshop.data.datastore.AuthDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)

@Module
object DatastoreModule {

    @Provides
    @Singleton
    fun providesAuthDatastore(application: Application): AuthDataStore {
        return AuthDataStore(application)
    }

}