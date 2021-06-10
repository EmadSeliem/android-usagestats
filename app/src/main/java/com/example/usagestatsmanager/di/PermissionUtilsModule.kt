package com.example.usagestatsmanager.di

import android.content.Context
import com.example.usagestatsmanager.utils.PermissionUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PermissionUtilsModule {

    @Provides
    fun providePermissionUtils(@ApplicationContext context: Context): PermissionUtils {
        return PermissionUtils(context)
    }
}