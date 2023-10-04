package fr.bendev.batchcookinapp.data.datasources.local

import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry
import kotlinx.coroutines.flow.Flow

interface CookbookLocalDatasource {

    fun getAllEntries(): Flow<List<CookbookEntry>>

    suspend fun saveAllEntries(entries: List<CookbookEntry>)

}