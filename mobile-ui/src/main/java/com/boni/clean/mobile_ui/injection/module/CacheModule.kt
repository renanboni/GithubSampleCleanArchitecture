package com.boni.clean.mobile_ui.injection.module

import android.app.Application
import com.boni.clean.data.repository.ProjectsCache
import com.example.cache.ProjectsCacheImpl
import com.example.cache.db.ProjectsDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CacheModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideDataBase(application: Application): ProjectsDatabase {
            return ProjectsDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindProjectsCache(projectsCache: ProjectsCacheImpl): ProjectsCache
}