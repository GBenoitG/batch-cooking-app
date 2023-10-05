package fr.bendev.batchcookingapp.framework.database.daos

import androidx.room.Dao
import androidx.room.Query
import fr.bendev.batchcookingapp.framework.database.entities.CookbookEntryDB
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CookbookEntryDao : BaseDao<CookbookEntryDB>() {

    @Query("SELECT * FROM cookbook_entry")
    abstract fun getEntries(): Flow<List<CookbookEntryDB>>

}