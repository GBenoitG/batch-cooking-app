package fr.bendev.batchcookingapp.framework.network.datasource

import fr.bendev.batchcookingapp.data.datasource.remote.SampleRemoteDataSource
import fr.bendev.batchcookingapp.domain.model.Sample

/**
 * DESCRIPTION: Framework-specific implementation of the remote datasource interface found in the data module
 * FILE NAMING CONVENTION: Api{OBJECT}DataSource
*/
class ApiSampleDataSource: SampleRemoteDataSource {

    override fun postSample(sample: Sample) { TODO("Not yet implemented") }

    override fun fetchSample(): List<Sample> { TODO("Not yet implemented") }

}