package com.boni.clean.mobile_ui.injection

import android.app.Application
import com.boni.clean.data.repository.ProjectsCache
import com.boni.clean.domain.repository.ProjectsRepository
import com.example.cache.ProjectsCacheImpl
import com.example.cache.db.ProjectsDatabase
import com.nhaarman.mockito_kotlin.mock
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    fun providesDataRepository(): ProjectsRepository {
        return mock()
    }
}