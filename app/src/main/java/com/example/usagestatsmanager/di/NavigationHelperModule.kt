package com.example.usagestatsmanager.di

import android.content.Context
import com.example.usagestatsmanager.utils.NavigationHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationHelperModule {

    @Singleton
    @Provides
    fun provideNavigationHelper(@ApplicationContext context: Context): NavigationHelper {
        return NavigationHelper(context)
    }
}