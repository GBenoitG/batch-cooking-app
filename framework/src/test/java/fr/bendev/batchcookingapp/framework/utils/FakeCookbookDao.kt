package fr.bendev.batchcookingapp.framework.utils

import fr.bendev.batchcookingapp.framework.database.daos.CookbookEntryDao
import fr.bendev.batchcookingapp.framework.database.entities.CookbookEntryDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FakeCookbookDao : CookbookEntryDao() {

    val cookbookTable: MutableStateFlow<List<CookbookEntryDB>> = MutableStateFlow(emptyList())

    override fun insert(obj: CookbookEntryDB): Long {
        TODO("Not yet implemented")
    }

    override fun insert(obj: List<CookbookEntryDB>): List<Long> {
        val list = cookbookTable.value.toMutableList()
        list.removeIf { item -> obj.any { it.id == item.id } }
        list.addAll(obj)
        cookbookTable.update { list }
        return List(list.size) { index -> index.toLong() }
    }

    override fun update(obj: CookbookEntryDB) {
        TODO("Not yet implemented")
    }

    override fun update(obj: List<CookbookEntryDB>) {
        TODO("Not yet implemented")
    }

    override fun getEntries(): Flow<List<CookbookEntryDB>> = cookbookTable.asStateFlow()
}