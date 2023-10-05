package fr.bendev.batchcookingapp

import android.app.Application
import fr.bendev.batchcookingapp.framework.di.BatchEnvironment
import fr.bendev.batchcookingapp.framework.di.Injector
import timber.log.Timber

class BatchCookingApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        Injector
            .initContext(application = this)
            .initEnv(env = BatchEnvironment.valueOf(BuildConfig.FLAVOR.uppercase()))
    }
}