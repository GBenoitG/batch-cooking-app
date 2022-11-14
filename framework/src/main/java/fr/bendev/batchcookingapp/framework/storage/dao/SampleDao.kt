package fr.bendev.batchcookingapp.framework.storage.dao

import fr.bendev.batchcookingapp.domain.model.Sample

/**
 * DESCRIPTION: DAO interface that list all functions that will interact with the database
 * REALM - the DAO will be an internal class that directly details the database transactions
 * FILE NAMING CONVENTION: {Object}Dao

//ROOM
@Dao
interface SampleDao {
    @Transaction
    @Query("SELECT * FROM sample WHERE id = :id")
    fun getSampleById(id: Long): Flow<List<RoomSample>>
}
*/

//REALM
class SampleDao(
//    private realm: Realm = Injector.realm
) {
    fun getSampleById(id: String): Sample {
//        return realm.get().where<RealmSample>()
//            .equalTo("Sample", id)
//            .findFirst()
//            .toSample()
//    }
        TODO("Not yet implemented")
    }

    fun createSample(sample: Sample) {
        TODO("Not yet implemented")
    }
}