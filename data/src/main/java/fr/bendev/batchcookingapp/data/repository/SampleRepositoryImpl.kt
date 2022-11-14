package fr.bendev.batchcookingapp.data.repository

import fr.bendev.batchcookingapp.data.datasource.local.SampleLocalDataSource
import fr.bendev.batchcookingapp.data.datasource.remote.SampleRemoteDataSource
import fr.bendev.batchcookingapp.domain.model.Sample
import fr.bendev.batchcookingapp.domain.repository.SampleRepository
import kotlinx.coroutines.flow.Flow

/**
 * DESCRIPTION: Implementation class of repository interface
 * FILE NAMING CONVENTION: {OBJECT}RepositoryImpl
*/
class SampleRepositoryImpl (
    private val sampleLocalDataSource: SampleLocalDataSource,
    private val sampleRemoteDataSource: SampleRemoteDataSource,
): SampleRepository {

    override fun getSampleById(): Flow<List<Sample>> {
        TODO("Not yet implemented")
    }

}