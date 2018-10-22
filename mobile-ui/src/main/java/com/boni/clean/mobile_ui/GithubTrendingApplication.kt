package com.boni.clean.mobile_ui

import android.app.Activity
import android.app.Application
import com.boni.clean.mobile_ui.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber

class GithubTrendingApplication : Application(), HasActivityInjector {

    private lateinit var androidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        setupTimbler()

        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }

    private fun setupTimbler() {
        Timber.plant(Timber.DebugTree())
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return androidInjector
    }
}