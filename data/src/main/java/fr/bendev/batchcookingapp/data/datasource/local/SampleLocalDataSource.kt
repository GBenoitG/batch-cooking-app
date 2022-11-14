package fr.bendev.batchcookingapp.data.datasource.local

import fr.bendev.batchcookingapp.domain.model.Sample

/**
 * DESCRIPTION: Interface to access local database - class implemented in storage package in framework module
 * FILE NAMING CONVENTION: {OBJECT}LocalDataSource
 * DELETE - delete file and package if a database is not used by project
*/
interface SampleLocalDataSource {
    fun getSampleById(id: String): Sample
    fun createSample(sample: Sample)
}