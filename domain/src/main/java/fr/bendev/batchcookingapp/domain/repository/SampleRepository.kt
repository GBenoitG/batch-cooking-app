package fr.bendev.batchcookingapp.domain.repository

import fr.bendev.batchcookingapp.domain.model.Sample
import kotlinx.coroutines.flow.Flow

/**
 * DESCRIPTION: Repository interface that lays out the functions necessary to access the framework layer (local and remote resources)
 * FILE NAMING CONVENTION: {OBJECT}Repository
*/
interface SampleRepository {
    fun getSampleById(): Flow<List<Sample>>
}