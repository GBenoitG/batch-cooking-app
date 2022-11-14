package fr.bendev.batchcookingapp.framework.di

import android.app.Application
import fr.bendev.batchcookingapp.data.datasource.local.SampleLocalDataSource
import fr.bendev.batchcookingapp.data.datasource.remote.SampleRemoteDataSource
import fr.bendev.batchcookingapp.domain.repository.SampleRepository
import fr.bendev.batchcookingapp.data.repository.SampleRepositoryImpl
import fr.bendev.batchcookingapp.framework.network.SampleNetwork
import fr.bendev.batchcookingapp.framework.network.datasource.ApiSampleDataSource
import fr.bendev.batchcookingapp.framework.storage.dao.SampleDao
import fr.bendev.batchcookingapp.framework.storage.datasource.RealmRoomSampleDataSource

/**
 * Injector is here to have instances of many component inside the app. We can use it for field
 * injection and constructor injection.
 */
object Injector {

    /**
     * Context
     * */
    lateinit var application: Application
        private set

    /**
     * Network
     */
    private lateinit var network: SampleNetwork

    /**
     * DAOs
     * DESCRIPTION: List of instance of DAOs with lazy loading.
     * USAGE: It will depends on which Database system will be used: Realm or Rooms.
     * NAMING CONVENTION (for Realm): val {object}Dao: {Object}Dao by lazy { {Object}Dao() }
     * NAMING CONVENTION (for Room): val {object}Dao: {Object}Dao by lazy { databaseInstance.sampleDao }
     */
    val sampleDao: SampleDao by lazy { SampleDao() }

    /**
     * DataSources
     * DESCRIPTION: List of instance of data source with lazy loading.
     * NAMING CONVENTION: val {object}DataSource: {Object}RemoteDataSource by lazy { {Class}DataSource }
     */
    private val sampleLocalDataSource: SampleLocalDataSource by lazy { RealmRoomSampleDataSource() }
    private val sampleRemoteDataSource: SampleRemoteDataSource by lazy { ApiSampleDataSource() }


    /**
     * Repositories
     * DESCRIPTION: List of instance of repositories with lazy loading.
     * NAMING CONVENTION: val {object}Repository: {Object}Repository by lazy { {Object}DataSourceImpl }
    */
    val sampleRepository: SampleRepository by lazy { SampleRepositoryImpl(
        sampleLocalDataSource,
        sampleRemoteDataSource
    ) }

     /**/

    /**
     * SharedPreferences
     * DESCRIPTION: Instance of SharedPreferences class with mazy loading.
     * NAMING CONVENTION: val {object}SharePreferences: SharedPreferences by lazy { {Object}SharedPrefs }

        val sampleSharePreferences: SharedPreferences by lazy { SampleSharedPrefs }

     */


    /**
     * Based on Builder pattern
     */
    fun initNetwork(baseUrl: String) = apply {
        network = SampleNetwork.Builder()
            .setBaseUrl(baseUrl)
            .build()
    }

    fun build(application: Application) {
        this.application = application
    }

}