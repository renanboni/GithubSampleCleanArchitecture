package com.boni.clean.mobile_ui.injection.module

import com.boni.clean.data.repository.ProjectsRemote
import com.boni.clean.mobile_ui.BuildConfig
import com.boni.remote.ProjectsRemoteImpl
import com.boni.remote.service.GithubTrendingService
import com.boni.remote.service.GithubTrendingServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    companion object {

        @Provides
        @JvmStatic
        fun provideGithubService(): GithubTrendingService {
            return GithubTrendingServiceFactory.makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindProjectsRemote(projectsRemote: ProjectsRemoteImpl): ProjectsRemote
}