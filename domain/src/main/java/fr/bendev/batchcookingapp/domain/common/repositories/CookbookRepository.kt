package fr.bendev.batchcookingapp.domain.common.repositories

import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry
import kotlinx.coroutines.flow.Flow

interface CookbookRepository {

    fun getAllEntries(): Flow<List<CookbookEntry>>

}