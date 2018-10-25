package com.boni.clean.mobile_ui.injection

import android.app.Application
import com.boni.clean.domain.repository.ProjectsRepository
import com.boni.clean.mobile_ui.TestApplication
import com.boni.clean.mobile_ui.injection.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
                      TestApplicationModule::class,
                      UiModule::class,
                      PresentationModule::class,
                      TestDataModule::class,
                      TestCacheModule::class,
                      TestRemoteModule::class])
interface TestApplicationComponent {

    fun projectsRepository(): ProjectsRepository

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestApplicationComponent
    }

    fun inject(application: TestApplication)
}