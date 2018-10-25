package com.boni.clean.mobile_ui.injection

import android.app.Application
import com.boni.clean.data.repository.ProjectsCache
import com.example.cache.ProjectsCacheImpl
import com.example.cache.db.ProjectsDatabase
import com.nhaarman.mockito_kotlin.mock
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
object TestCacheModule {

    @Provides
    @JvmStatic
    fun provideDataBase(application: Application): ProjectsDatabase {
        return ProjectsDatabase.getInstance(application)
    }

    @Provides
    @JvmStatic
    fun providesProjectsCache(): ProjectsCache {
        return mock()
    }
}