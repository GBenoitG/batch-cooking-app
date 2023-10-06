package fr.bendev.batchcookingapp.framework.datasource.local

import fr.bendev.batchcookingapp.data.datasources.local.CookbookLocalDatasource
import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry
import fr.bendev.batchcookingapp.framework.database.daos.CookbookEntryDao
import fr.bendev.batchcookingapp.framework.mappers.fromDBtoDomain
import fr.bendev.batchcookingapp.framework.mappers.fromDomainToDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CookbookLocalDatasourceImpl(
    private val cookbookEntryDao: CookbookEntryDao
) : CookbookLocalDatasource {

    override fun getAllEntries(): Flow<List<CookbookEntry>> =
        cookbookEntryDao.getEntries().map { it.fromDBtoDomain() }

    override suspend fun saveAllEntries(entries: List<CookbookEntry>) {
        cookbookEntryDao.insert(entries.fromDomainToDB())
    }
}