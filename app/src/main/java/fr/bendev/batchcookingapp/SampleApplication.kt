package fr.bendev.batchcookingapp

import android.app.Application
import fr.bendev.batchcookingapp.config.EnvironmentConstants
import fr.bendev.batchcookingapp.framework.di.Injector
import timber.log.Timber

class SampleApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        Injector
            .initNetwork(EnvironmentConstants.baseUrl)
            .build(this)

    }
}