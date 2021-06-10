package com.example.usagestatsmanager.di

import com.example.usagestatsmanager.adapters.AppListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class AdapterModule {

    @Provides
    fun providesAppListAdapters(): AppListAdapter {
        return AppListAdapter()
    }
}