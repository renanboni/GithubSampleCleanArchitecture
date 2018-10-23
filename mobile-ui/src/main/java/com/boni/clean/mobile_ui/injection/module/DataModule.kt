package com.boni.clean.mobile_ui.injection.module

import com.boni.clean.data.ProjectsDataRepository
import com.boni.clean.domain.repository.ProjectsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindDataRepository(dataRepository: ProjectsDataRepository) : ProjectsRepository
}