package com.example.composestudy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // 로그찍는 라이브러리
        Timber.plant(Timber.DebugTree())
    }
}
