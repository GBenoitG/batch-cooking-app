package fr.bendev.batchcookingapp.framework.storage.datasource

import fr.bendev.batchcookingapp.data.datasource.local.SampleLocalDataSource
import fr.bendev.batchcookingapp.domain.model.Sample
import fr.bendev.batchcookingapp.framework.di.Injector
import fr.bendev.batchcookingapp.framework.storage.dao.SampleDao

/**
 * DESCRIPTION: Implementation class of the local datasource interface found in the data module. It links the data layer to the corresponding DAO
 * FILE NAMING CONVENTION: {DatabaseFramework}{OBJECT}DataSource (i.e. RoomSampleDataSource or RealmSampleDataSource)
*/
class RealmRoomSampleDataSource(
    private val sampleDao: SampleDao = Injector.sampleDao
): SampleLocalDataSource {

    override fun getSampleById(id: String) = sampleDao.getSampleById(id)
    override fun createSample(sample: Sample) = sampleDao.createSample(sample)

}