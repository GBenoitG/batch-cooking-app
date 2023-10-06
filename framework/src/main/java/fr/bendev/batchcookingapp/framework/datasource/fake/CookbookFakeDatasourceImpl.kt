package fr.bendev.batchcookingapp.framework.datasource.fake

import fr.bendev.batchcookingapp.data.datasources.local.CookbookLocalDatasource
import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CookbookFakeDatasourceImpl : CookbookLocalDatasource {

    private val _entries: MutableStateFlow<List<CookbookEntry>> = MutableStateFlow(generateFakeEntries(10))

    override fun getAllEntries(): Flow<List<CookbookEntry>> = _entries.asStateFlow()

    override suspend fun saveAllEntries(entries: List<CookbookEntry>) {
        _entries.update { entries }
    }

    private fun generateFakeEntries(number: Int): List<CookbookEntry> {
        return (1..number).map {
            CookbookEntry(
                "id-$it",
                "meal $it",
                generateFakeIngredients(it),
                "Description $it",
                listOf("tag"),
                null,
                null
            )
        }
    }

    private fun generateFakeIngredients(number: Int): List<String> {
        return (1..number).map { "Ingredients $it" }
    }
}