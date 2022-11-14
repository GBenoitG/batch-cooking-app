package fr.bendev.batchcookingapp.data.datasource.remote

import fr.bendev.batchcookingapp.domain.model.Sample

/**
 * DESCRIPTION: Interface to access local database - class implemented in network package in framework module
 * FILE NAMING CONVENTION: OBJECT}RemoteDataSource
 * DELETE - delete file and package if data is not fetch from a server
*/
interface SampleRemoteDataSource {
    fun postSample(sample: Sample)
    fun fetchSample(): List<Sample>
}