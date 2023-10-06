package fr.bendev.batchcookingapp.data.repositories

import fr.bendev.batchcookingapp.data.datasources.local.CookbookLocalDatasource
import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry
import fr.bendev.batchcookingapp.domain.common.repositories.CookbookRepository
import kotlinx.coroutines.flow.Flow

class CookbookRepositoryImpl(
    private val cookbookLocalDatasource: CookbookLocalDatasource
) : CookbookRepository {

    override fun getAllEntries(): Flow<List<CookbookEntry>> =
        cookbookLocalDatasource.getAllEntries()

}