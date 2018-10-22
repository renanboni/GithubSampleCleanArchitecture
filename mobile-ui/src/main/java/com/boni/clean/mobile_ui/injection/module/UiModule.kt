package com.boni.clean.mobile_ui.injection.module

import com.boni.clean.domain.executor.PostExecutionThread
import com.boni.clean.mobile_ui.browse.BrowseActivity
import com.boni.clean.mobile_ui.UiThread
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesBrowseActivity(): BrowseActivity
}