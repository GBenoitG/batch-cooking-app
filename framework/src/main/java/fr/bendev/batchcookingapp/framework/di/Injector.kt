package fr.bendev.batchcookingapp.framework.di

import android.app.Application
import fr.bendev.batchcookinapp.data.datasources.local.CookbookLocalDatasource
import fr.bendev.batchcookinapp.data.repositories.CookbookRepositoryImpl
import fr.bendev.batchcookingapp.domain.common.repositories.CookbookRepository
import fr.bendev.batchcookingapp.framework.database.BatchDatabase
import fr.bendev.batchcookingapp.framework.datasource.fake.CookbookFakeDatasourceImpl
import fr.bendev.batchcookingapp.framework.datasource.local.CookbookLocalDatasourceImpl

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

    private lateinit var environment: BatchEnvironment

    /**
     * Network
     */
    // private lateinit var network: BatchCookingNetwork

    /**
     * Database
     */
    private val database: BatchDatabase by lazy {
        BatchDatabase.getDatabase(application)
    }

    /**
     * DAOs
     * DESCRIPTION: List of instance of DAOs with lazy loading.
     * USAGE: It will depends on which Database system will be used: Realm or Rooms.
     * NAMING CONVENTION (for Realm): val {object}Dao: {Object}Dao by lazy { {Object}Dao() }
     * NAMING CONVENTION (for Room): val {object}Dao: {Object}Dao by lazy { databaseInstance.sampleDao }
     */


    /**
     * DataSources
     * DESCRIPTION: List of instance of data source with lazy loading.
     * NAMING CONVENTION: val {object}DataSource: {Object}RemoteDataSource by lazy { {Class}DataSource }
     */
    private val cookbookLocalDatasource: CookbookLocalDatasource by lazy {
        when (environment) {
            BatchEnvironment.DEV -> CookbookFakeDatasourceImpl()
            else -> CookbookLocalDatasourceImpl(database.cookbookEntryDao)
        }
    }


    /**
     * Repositories
     * DESCRIPTION: List of instance of repositories with lazy loading.
     * NAMING CONVENTION: val {object}Repository: {Object}Repository by lazy { {Object}DataSourceImpl }
     */
    val cookbookRepository: CookbookRepository by lazy {
        CookbookRepositoryImpl(cookbookLocalDatasource)
    }

    /**
     * SharedPreferences
     * DESCRIPTION: Instance of SharedPreferences class with mazy loading.
     * NAMING CONVENTION: val {object}SharePreferences: SharedPreferences by lazy { {Object}SharedPrefs }
     */


    /**
     * Based on Builder pattern
     */
    fun initContext(application: Application) = apply {
        this.application = application
    }

    fun initEnv(env: BatchEnvironment) = apply {
        environment = env
    }

}