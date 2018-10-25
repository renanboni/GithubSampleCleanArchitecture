package com.boni.clean.mobile_ui.injection

import android.app.Application
import com.boni.clean.data.repository.ProjectsCache
import com.boni.clean.data.repository.ProjectsRemote
import com.boni.remote.service.GithubTrendingService
import com.example.cache.ProjectsCacheImpl
import com.example.cache.db.ProjectsDatabase
import com.nhaarman.mockito_kotlin.mock
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun provideGithubService(): GithubTrendingService {
        return mock()
    }

    @Provides
    @JvmStatic
    fun providesProjectsRemote(): ProjectsRemote {
        return mock()
    }
}